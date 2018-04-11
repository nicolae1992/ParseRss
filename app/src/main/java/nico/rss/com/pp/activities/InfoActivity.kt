package nico.rss.com.pp.activities

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar
import butterknife.BindView
import butterknife.ButterKnife
import nico.rss.com.pp.R
import android.webkit.WebSettings
import android.widget.Toast
import android.webkit.WebViewClient


class InfoActivity : AppCompatActivity() {
    @BindView(R.id.webview)
    lateinit var webView: WebView
    @BindView(R.id.progressBar)
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        ButterKnife.bind(this)
        val strUrl: String = intent.getStringExtra("url")
        strUrl.let { loadUrl(strUrl) }
    }


    @SuppressLint("SetJavaScriptEnabled")
    fun loadUrl(url: String) {
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
            }
        }

        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
        // setContentView(webView )
    }
}
