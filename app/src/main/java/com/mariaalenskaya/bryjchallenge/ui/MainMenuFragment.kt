package com.mariaalenskaya.bryjchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mariaalenskaya.bryjchallenge.databinding.MainMenuFragmentBinding

abstract class MainMenuFragment : Fragment(), MenuAwareFragment {

    abstract val fragmentUrl: String

    private var _binding: MainMenuFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var isOpen = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MainMenuFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val webView = binding.webView
        webView.loadUrl(fragmentUrl)

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
