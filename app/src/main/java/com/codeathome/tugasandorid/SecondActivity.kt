package com.codeathome.tugasandorid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.codeathome.tugasandorid.Fragment.HomeFragment
import com.codeathome.tugasandorid.Fragment.SearchFragment
import com.codeathome.tugasandorid.Fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {
    private lateinit var textViewEmail: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // fragment
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        // Ref
        textViewEmail = findViewById(R.id.outputemail)
        val email = intent.getStringExtra(MainActivity.EMAIL)
        textViewEmail.text = email
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: Fragment? = null
        when (item.itemId) {
            R.id.nav_home -> selectedFragment = HomeFragment()
            R.id.nav_search -> selectedFragment = SearchFragment()
            R.id.nav_setting -> selectedFragment = SettingFragment()
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, selectedFragment!!)
            .commit()

        false
    }


}