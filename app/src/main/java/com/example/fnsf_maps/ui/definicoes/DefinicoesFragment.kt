package com.example.fnsf_maps.ui.definicoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fnsf_maps.R
import com.example.fnsf_maps.databinding.FragmentDefinicoesBinding

class DefinicoesFragment : Fragment() {

    private var _binding: FragmentDefinicoesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDefinicoesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val myTextView: TextView = binding.myTextView
        myTextView.text = "Definições"

        binding.themeChipGroup.setOnCheckedStateChangeListener { _, checkedIds ->
            when (checkedIds.firstOrNull()) {
                R.id.chip_light_theme -> applyTheme(AppCompatDelegate.MODE_NIGHT_NO)
                R.id.chip_dark_theme -> applyTheme(AppCompatDelegate.MODE_NIGHT_YES)
                else -> applyTheme(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM) // Or a default
            }
        }

        return root
    }

    private fun applyTheme(themeMode: Int) {
        AppCompatDelegate.setDefaultNightMode(themeMode)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}