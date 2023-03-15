package com.mariaalenskaya.bryjchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mariaalenskaya.bryjchallenge.databinding.MainMenuFragmentBinding

/**
 * Base class for fragments displayed in main menu.
 * Loads initial [fragmentWebPageUrl] to web view and supports notifications about toolbar menu button clicks.
 */
abstract class MainMenuFragment : Fragment(), MenuAwareFragment {

    /**
     * Initial web page url.
     */
    abstract val fragmentWebPageUrl: String

    private var _binding: MainMenuFragmentBinding? = null

    private val binding
        get() = _binding
            ?: error("Binding is only valid between onCreateView and onDestroyView.")

    private var isOpen = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainMenuFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.webView.loadUrl(fragmentWebPageUrl)

        return root
    }

    override fun menuClicked() {
        with(binding.webView) {
            if (!isOpen) {
                showMenu()
            } else {
                hideMenu()
            }
        }

        isOpen = !isOpen
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
