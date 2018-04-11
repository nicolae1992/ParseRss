package nico.rss.com.pp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.squareup.picasso.Picasso
import nico.rss.com.pp.R
import nico.rss.com.pp.models.Item


class RecyclerAdapter(private val news: ArrayList<Item>) : RecyclerView.Adapter<RecyclerAdapter.NewsHolder>() {
    companion object {
        var clickListener: ItemClickListener? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val postView = inflater.inflate(R.layout.recyclerview_item_row, parent, false)
        return NewsHolder(postView)
    }

    override fun getItemCount() = news.size

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val item = news[position]
        holder.mTvTitle.text = item.title
        holder.mTvDescription.text = item.description
        Picasso.get().load(item.enclosure!!.url).into(holder.imageNews)

    }

    class NewsHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //private var view: View = v
        //  var imageNews: ImageView
        //var titleNews: TextView


        @BindView(R.id.tv_title)
        lateinit var mTvTitle: TextView
        @BindView(R.id.tv_description)
        lateinit var mTvDescription: TextView
        @BindView(R.id.iv_news)
        lateinit var imageNews: ImageView

        init {
            ButterKnife.bind(this, v)
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (clickListener != null) clickListener!!.onClick(adapterPosition)
        }

    }

    interface ItemClickListener {
        fun onClick( position: Int)
    }

    fun setClickListener(itemClickListener: ItemClickListener) {
        clickListener = itemClickListener
    }

}