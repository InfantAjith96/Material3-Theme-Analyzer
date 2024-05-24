package com.example.material3theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.material3theme.databinding.FragmentSettingsBinding
import com.example.materialtheme.MaterialTheme
import com.example.materialtheme.ThemeChooserDialogBuilder
import com.example.materialtheme.ThemeMode
import com.example.materialtheme.hasS
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SettingsFragment : BottomSheetDialogFragment() {

    private lateinit var materialTheme: MaterialTheme

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        materialTheme = MaterialTheme.getInstance(requireContext())
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (hasS()) {
            binding.dynamicGroup.check(if (materialTheme.isDynamicTheme) R.id.dynamic_on else R.id.dynamic_off)
            binding.dynamicGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
                if (isChecked) {
                    when (checkedId) {
                        R.id.dynamic_off -> materialTheme.isDynamicTheme = false
                        R.id.dynamic_on -> materialTheme.isDynamicTheme = true
                    }
                    requireActivity().recreate()
                }
            }
        } else {
            binding.dynamicColorLabel.isVisible = false
            binding.dynamicGroup.isVisible = false
        }
        binding.themeGroup.check(
            when (materialTheme.themeMode) {
                ThemeMode.AUTO -> R.id.auto_theme
                ThemeMode.LIGHT -> R.id.light_theme
                ThemeMode.DARK -> R.id.dark_theme
                else -> R.id.auto_theme
            }
        )

        binding.trueBlackGroup.check(if (materialTheme.isTrueBlack) R.id.true_black_on else R.id.true_black_off)
        binding.trueBlackGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked) {
                materialTheme.isTrueBlack = when (checkedId) {
                    R.id.true_black_on -> true
                    else -> false
                }
                requireActivity().recreate()
            }
        }

        binding.themeGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked) {
                materialTheme.themeMode = when (checkedId) {
                    R.id.auto_theme -> ThemeMode.AUTO
                    R.id.light_theme -> ThemeMode.LIGHT
                    R.id.dark_theme -> ThemeMode.DARK
                    else -> ThemeMode.AUTO
                }
            }
        }
        binding.changeTheme.setOnClickListener {
            ThemeChooserDialogBuilder(requireContext())
                .setTitle(R.string.choose_theme)
                .setPositiveButton("OK") { _, theme ->
                    materialTheme.staticTheme = theme
                    requireActivity().recreate()
                }
                .setNegativeButton("Cancel")
                .setNeutralButton("Default") { _, _ ->
                    materialTheme.resetTheme()
                    requireActivity().recreate()
                }
                .setIcon(R.drawable.ic_round_brush)
                .create()
                .show()
        }
    }
}