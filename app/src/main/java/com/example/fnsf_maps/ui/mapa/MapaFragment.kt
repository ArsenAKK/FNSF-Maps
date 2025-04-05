package com.example.fnsf_maps.ui.mapa

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fnsf_maps.databinding.FragmentMapaBinding
import com.example.fnsf_maps.R

class MapaFragment : Fragment() {

    private var _binding: FragmentMapaBinding? = null
    private val binding get() = _binding!!
    private lateinit var mapWebView: WebView // Add WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mapaViewModel =
            ViewModelProvider(this).get(MapaViewModel::class.java)

        _binding = FragmentMapaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Assuming you have a WebView in your fragment_mapa.xml with id "mapWebView"
        mapWebView = binding.root.findViewById(R.id.mapWebView) // Initialize WebView

        mapWebView.settings.javaScriptEnabled = true
        mapWebView.loadUrl("https://luisr091.github.io/Map_App---JFNSF/")  // Load the HTML

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}