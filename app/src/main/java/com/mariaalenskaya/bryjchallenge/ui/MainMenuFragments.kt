package com.mariaalenskaya.bryjchallenge.ui

class HomeFragment : MainMenuFragment() {
    override val fragmentUrl: String = "https://www.thebay.com/"
}

class ShopFragment : MainMenuFragment() {
    override val fragmentUrl: String = "https://www.thebay.com/c/men"
}

class AccountFragment : MainMenuFragment() {
    override val fragmentUrl: String = "https://www.thebay.com/account/login"
}

class BagFragment : MainMenuFragment() {
    override val fragmentUrl: String = "https://www.thebay.com/cart"
}
