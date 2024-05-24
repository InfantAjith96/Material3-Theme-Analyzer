package com.example.material3theme

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.material3theme.databinding.ActivityMainBinding
import com.example.materialtheme.MaterialTheme
import com.example.materialtheme.ThemeChooserDialogBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MaterialTheme.applyToActivity(this)
        enableEdgeToEdge(
//            statusBarStyle = SystemBarStyle.auto(
//                resources.getColor(com.example.materialtheme.R.color.amber_primaryInverse, null),
//                darkScrim = resources.getColor(com.example.materialtheme.R.color.amber_tertiary, null)
//            )
        )
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val materialTheme = MaterialTheme.getInstance(this)
//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.changeTheme.setOnClickListener {
            ThemeChooserDialogBuilder(this)
                .setTitle(R.string.choose_theme)
                .setPositiveButton("OK") { _, theme ->
                    materialTheme.staticTheme = theme
                    recreate()
                }
                .setNegativeButton("Cancel")
                .setNeutralButton("Default") { _, _ ->
                    materialTheme.resetTheme()
                    recreate()
                }
                .setIcon(R.drawable.ic_round_brush)
                .create()
                .show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.settings) {
            SettingsFragment().show(supportFragmentManager, "Settings")
        }
        return super.onOptionsItemSelected(item)
    }
}