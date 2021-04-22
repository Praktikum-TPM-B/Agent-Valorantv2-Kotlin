package com.maulanakurnia.agentvalorantv2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.maulanakurnia.agentvalorantv2.R
import com.maulanakurnia.agentvalorantv2.databinding.ActivityMainBinding
import com.maulanakurnia.agentvalorantv2.fragment.AgentFragment
import com.maulanakurnia.agentvalorantv2.fragment.CallFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val SELECTED_MENU = "selected_menu"
    }

    private val navView: BottomNavigationView
        get() = findViewById(R.id.nav_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        setupSelectedMenu(savedInstanceState)
    }

    private fun setupSelectedMenu(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU)
        } else {
            navView.selectedItemId = R.id.action_home
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_MENU, navView.selectedItemId)
    }

    private fun setupNavigation() {
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_home -> {
                        loadFragment(AgentFragment())
                        return true
                    }
                    R.id.action_call -> {
                        loadFragment(CallFragment())
                        return true
                    }
                }
                return false
            }
        }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.fr_main_container, fragment, fragment::class.java.simpleName)
            .commit()
    }
}