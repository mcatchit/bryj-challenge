package com.mariaalenskaya.bryjchallenge.ui

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Client which allows web view to load urls independently without redirecting to browser.
 * All links clicked in the web view will be processed by the web view itself.
 */
class SelfUrlLoadingWebViewClient : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        view.loadUrl(request.url.toString())
        return false
    }
}