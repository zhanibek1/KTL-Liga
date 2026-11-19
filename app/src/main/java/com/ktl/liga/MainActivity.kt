package com.ktl.liga

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : Activity() {

    private val url = "https://claude.ai/artifact/5dJsrEeX5LUNuKKeWBpSdE"

    private lateinit var web: WebView

    private val offlineHtml: String
        get() = """
            <body style="margin:0;height:100vh;display:flex;flex-direction:column;align-items:center;
            justify-content:center;background:#070b1a;color:#f2f5ff;font-family:sans-serif;text-align:center">
            <div style="font-size:64px">⚽</div>
            <h2>КТЛ ЛИГА</h2>
            <p style="color:#9aa6cf">Нет подключения к интернету</p>
            <a href="$url" style="margin-top:16px;padding:12px 24px;border-radius:14px;
            background:#37f58b;color:#04210f;font-weight:bold;text-decoration:none">Повторить</a>
            </body>
        """.trimIndent()

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.parseColor("#070B1A")
        window.navigationBarColor = Color.parseColor("#070B1A")

        web = WebView(this)
        web.setBackgroundColor(Color.parseColor("#070B1A"))
        setContentView(web)

        web.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            cacheMode = WebSettings.LOAD_DEFAULT
        }
        CookieManager.getInstance().apply {
            setAcceptCookie(true)
            setAcceptThirdPartyCookies(web, true)
        }
        web.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView,
                request: WebResourceRequest,
                error: WebResourceError
            ) {
                if (request.isForMainFrame) {
                    view.loadDataWithBaseURL(null, offlineHtml, "text/html", "UTF-8", null)
                }
            }
        }

        if (savedInstanceState == null) web.loadUrl(url) else web.restoreState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        web.saveState(outState)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (web.canGoBack()) web.goBack() else super.onBackPressed()
    }
}
