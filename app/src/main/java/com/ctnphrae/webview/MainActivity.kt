package com.ctnphrae.webview
import android.app.ProgressDialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        et_url.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
//            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
//                //Perform Code
//
//                var getUrl =  "http://"+et_url.text.toString()
//                requestUrl(getUrl)
//
//                return@OnKeyListener true
//            }
//            false
//        })

        et_url.setOnKeyListener { v, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_ENTER &&
                event.action == KeyEvent.ACTION_UP){

                var getUrl = "http://"+et_url.text.toString()
                requestUrl(getUrl)

                return@setOnKeyListener true

            }
            false
        }

        supportActionBar?.hide()

        btn_go.setOnClickListener {

            var getUrl = "http://"+et_url.text.toString()
            requestUrl(getUrl)


        }

    }

    fun requestUrl(url:String){

        webView.webViewClient =  object: WebViewClient(){

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                var getUrl = "https://"+et_url.text.toString()
                requestUrl(getUrl)
            }

        }

        webView.settings.javaScriptEnabled  = true
        webView.loadUrl(url)

    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack()
        }else{
            super.onBackPressed()
        }
    }
}
