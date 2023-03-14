package com.mariaalenskaya.bryjchallenge.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.webkit.WebView

@SuppressLint("SetJavaScriptEnabled")
class MenuAwareWebView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : WebView(context, attrs, defStyle) {

    init {
        scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        settings.loadsImagesAutomatically = true
        settings.javaScriptEnabled = true
    }

    fun showMenu() {
        loadUrl(showMenuFunction)
    }

    fun hideMenu() {
        loadUrl(hideMenuFunction)
    }

    private companion object {

        private const val BUTTON_SELECTOR_PLACEHOLDER = "[selector]"

        private const val CLICK_BUTTON_FUNCTION_TEMPLATE = "javascript:(function(){" +
                "l=document.querySelector('$BUTTON_SELECTOR_PLACEHOLDER');" +
                "e=document.createEvent('HTMLEvents');" +
                "e.initEvent('click',true,true);" +
                "l.dispatchEvent(e);" +
                "})()"

        private const val SHOW_MENU_BUTTON_SELECTOR = ".navbar-toggler"

        private const val HIDE_MENU_BUTTON_SELECTOR = ".close-button"

        private val showMenuFunction = CLICK_BUTTON_FUNCTION_TEMPLATE.replace(
            BUTTON_SELECTOR_PLACEHOLDER, SHOW_MENU_BUTTON_SELECTOR
        )

        private val hideMenuFunction = CLICK_BUTTON_FUNCTION_TEMPLATE.replace(
            BUTTON_SELECTOR_PLACEHOLDER, HIDE_MENU_BUTTON_SELECTOR
        )
    }
}
