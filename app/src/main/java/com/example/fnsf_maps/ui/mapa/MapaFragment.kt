package com.example.fnsf_maps.ui.mapa

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.ConsoleMessage
import android.util.Log
import android.webkit.GeolocationPermissions
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fnsf_maps.databinding.FragmentMapaBinding

class MapaFragment : Fragment() {

    private var _binding: FragmentMapaBinding? = null
    private val binding get() = _binding!!
    private lateinit var mapWebView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mapaViewModel = ViewModelProvider(this).get(MapaViewModel::class.java)
        _binding = FragmentMapaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            1
        )

        mapWebView = binding.mapWebView
        val progressBar = binding.progressBar

        mapWebView.settings.javaScriptEnabled = true
        mapWebView.settings.domStorageEnabled = true
        mapWebView.settings.allowFileAccess = true
        mapWebView.settings.allowContentAccess = true
        mapWebView.settings.mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        mapWebView.settings.javaScriptCanOpenWindowsAutomatically = true
        mapWebView.settings.mediaPlaybackRequiresUserGesture = false

        mapWebView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: android.graphics.Bitmap?) {
                progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                progressBar.visibility = View.GONE
            }
        }

        mapWebView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
                consoleMessage?.message()?.let { msg ->
                    Log.d("WebView", "Console: $msg")
                }
                return true
            }

            override fun onGeolocationPermissionsShowPrompt(origin: String?, callback: GeolocationPermissions.Callback?) {
                callback?.invoke(origin, true, false)
            }
        }

        mapWebView.clearCache(true)
        mapWebView.clearHistory()
        WebView.setWebContentsDebuggingEnabled(true)
        mapWebView.loadUrl("https://arsenakk.github.io/mapa/")

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
