package com.mariaalenskaya.bryjchallenge.ui

/**
 * Must be implemented by fragments that should receive notifications about clicks on menu button at toolbar.
 */
interface MenuAwareFragment {
    /**
     * Notifies fragment that menu button at toolbar was clicked.
     */
    fun menuClicked()
}
