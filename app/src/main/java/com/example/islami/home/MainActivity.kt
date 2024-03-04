package com.example.islami.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivityMainBinding
import com.example.islami.home.Tasbeh.TasbehFragment
import com.example.islami.home.hadeth.HadethFragment
import com.example.islami.home.quran.QuranFragment
import com.example.islami.home.radio.RadioFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {
        viewBinding.content.BottonNav.
        setOnItemSelectedListener { item ->
            val fragment : Fragment = when (item.itemId) {

                R.id.navigatioin_quran -> {
                   QuranFragment()
                }
                R.id.navigatioin_Sebha -> {
                    TasbehFragment()
                }
                R.id.navigatioin_hadeth -> {
                    HadethFragment()

                }
                R.id.navigatioin_radio -> {
                    RadioFragment()
                }
                else -> {
                    QuranFragment()
                }
            }

            pushFragment(fragment)
            true
        }

        viewBinding.content.BottonNav.selectedItemId = R.id.navigatioin_quran

    }

    private fun pushFragment(fragment:Fragment) {
        supportFragmentManager
            .beginTransaction().replace(R.id.fragment_container,fragment)
            .commit()

    }
}