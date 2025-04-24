package com.example.fnsf_maps.ui.informacoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fnsf_maps.databinding.FragmentInformacoesBinding

class InformacoesFragment : Fragment() {

    private var _binding: FragmentInformacoesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val informacoesViewModel =
            ViewModelProvider(this).get(InformacoesViewModel::class.java)

        _binding = FragmentInformacoesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Access the TextView using View Binding
        val myTextView: TextView = binding.myTextView
        myTextView.text = "Informações"


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}