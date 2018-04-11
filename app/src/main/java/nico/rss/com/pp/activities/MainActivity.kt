package nico.rss.com.pp.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import butterknife.BindView
import butterknife.ButterKnife
import nico.rss.com.pp.R
import nico.rss.com.pp.adapters.RecyclerAdapter
import nico.rss.com.pp.models.Item
import nico.rss.com.pp.models.RSS
import nico.rss.com.pp.rest.ApiUtilss
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var adapter: RecyclerAdapter? = null
    private var arrayNews: ArrayList<Item>? = ArrayList()

    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView
    @BindView(R.id.progress_bar)
    lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        initAdapter()
        getNews()
    }

    private fun initAdapter() {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(this.arrayNews!!)
        recyclerView.adapter = adapter
    }

    fun listener() {
        adapter!!.setClickListener(object : RecyclerAdapter.ItemClickListener {
            override fun onClick(position: Int) {
                moveTo(arrayNews!![position].link!!)
            }

        })
    }

    fun moveTo(url: String) {
        startActivity( Intent(this@MainActivity, InfoActivity::class.java).apply {
            putExtra("url", url)
        })
    }

    private fun getNews() {
        val call = ApiUtilss.getNewsService().news
        call.enqueue(object : Callback<RSS> {
            override fun onResponse(call: Call<RSS>?, response: Response<RSS>?) {
                val kk = response!!.body()
                if (kk != null) {
                    arrayNews?.addAll(kk.channel?.items!!)
                    adapter!!.notifyDataSetChanged()
                    listener()
                }
                progress.visibility = View.GONE
            }

            override fun onFailure(call: Call<RSS>?, t: Throwable?) {
                progress.visibility = View.GONE
            }

        })
    }

}
