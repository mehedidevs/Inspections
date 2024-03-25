package com.mehedi.inspections.views

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.mehedi.inspections.R
import com.mehedi.inspections.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configStatusBar()
        setSupportActionBar(binding.toolBar)
    }

    private fun configStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.decorView.windowInsetsController
                ?.setSystemBarsAppearance(0, APPEARANCE_LIGHT_STATUS_BARS)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_top, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_add -> {
                Toast.makeText(this, "Add Clicked", Toast.LENGTH_LONG).show()
            }
        }
        return true
    }


}