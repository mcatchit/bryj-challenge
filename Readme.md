# Bryj Challenge
I have divided development process into three stages.

## Analyzing:
1. Application has only 4 main pages and navigation between them is executed via tabbar (bottom navigation menu).
2. All pages have a native header with menu button and all of them represent a webView with own initial url.
3. Each webView should support functions of opening/hiding menu on its open web page.
4. Opening/hiding menu on currently open web page is called by clicking on native header menu button.

## Planning:
1. Application can be implemented as single activity with fragments representing web pages.
2. Native header should belong to activity the same way as bottom navigation, that's why  activity must be able to notify fragments about clicks on menu button.
3. The only difference between fragments is url of initially opened page, that's why all fragments can have common abstract implementation.
4. Mechanism of clicking button on a web page can be provided in a custom web view, which will encapsulate its basic initialization and will have two additional methods: showMenu() and hideMenu(). These methods will call special JS code on the open page to execute click on the required button.
5. Basic fragment should implement a interface of a 'menu button click listener' and its notification method which will call appropriate method of custom web view.

## Implementation:
1. Created MenuAwareWebView and added calls of JS functions for opening and hiding menu.
2. Created MenuAwareFragment interface and its implementation - abstract class MainMenuFragment with abstract property fragmentWebPageUrl. When MainMenuFragment is created it loads its initial url to its webView. Also it remembers whether menu is opened and calls corresponding function when menu button is clicked.
3. Created application navigation graph and added four implementations of MainMenuFragment to it as destinations.
4. Associated graph with navigation host and bottom navigation view.
5. Added listener to menu button clicks. Activity retrieves from its supportFragmentManager current fragment and if it is a MenuAwareFragments calls menuClicked() function.

## Additional:
- Added custom web view client, because clicking links on open web page caused redirection to browser.

## What I would like to improve but didn't have time:
1. Save state of web pages after switching to others and returning back.
2. Make architecture more flexible, create some kind of factory for fragments in order to make adding of new pages almost automatic.
3. Clean project resources, dependencies, etc.