package com.example.uts

import android.content.Intent
import android.os.Build.VERSION_CODES.N
import android.os.Build.VERSION_CODES.O
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    val fragmentNovelFragment: Fragment = NovelFragment()
    val fragmentProfil: Fragment = ProfilFragment()
    val fm: FragmentManager = supportFragmentManager
    var active : Fragment = fragmentNovelFragment


    private lateinit var bottomNavigationId: BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonNavigation()
    }

    private fun buttonNavigation() {
        fm.beginTransaction().add(R.id.container, fragmentNovelFragment).show(fragmentNovelFragment).commit()
        fm.beginTransaction().add(R.id.container, fragmentProfil).hide(fragmentProfil).commit()

        bottomNavigationId = binding.navView
        menu = bottomNavigationId.menu

        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationId.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    callFragment(0, fragmentNovelFragment)
                }

                R.id.navigation_profile -> {
                    callFragment(1, fragmentProfil)
                }
            }
            false
        }
    }

    private fun callFragment(index: Int, fragment: Fragment) {
        menuItem  = menu.getItem(index)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}