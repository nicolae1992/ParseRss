package nico.rss.com.pp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import nico.rss.com.pp.R
import nico.rss.com.pp.adapters.RecyclerAdapter
import nico.rss.com.pp.models.Item
import nico.rss.com.pp.models.RSS
import nico.rss.com.pp.rest.ApiUtils
import nico.rss.com.pp.rest.ApiUtilss
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var adapter: RecyclerView.Adapter<*>? = null
    private var arrayNews: ArrayList<Item>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()
        getNews()
    }

    private fun initAdapter() {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(this.arrayNews!!)
        recyclerView!!.adapter = adapter
    }

    private fun getNews() {
        val call = ApiUtilss.getNewsService().news
        call.enqueue(object : Callback<RSS> {
            override fun onResponse(call: Call<RSS>?, response: Response<RSS>?) {
                val kk = response!!.body()
                Log.d("body","body-200OK")
                if (kk != null) {
                    arrayNews?.addAll(kk.channel?.items!!)
                    adapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<RSS>?, t: Throwable?) {

                Log.d("error", "error ${t.toString()}")

            }

        })
    }

}
