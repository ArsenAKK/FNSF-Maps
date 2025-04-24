package com.example.fnsf_maps.ui.contactos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fnsf_maps.databinding.FragmentContactosBinding

class ContactosFragment : Fragment() {

    private var _binding: FragmentContactosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val contactosViewModel =
            ViewModelProvider(this).get(ContactosViewModel::class.java)

        _binding = FragmentContactosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Access the TextView using View Binding
        val myTextView: TextView = binding.myTextView
        myTextView.text = "Contactos"


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}