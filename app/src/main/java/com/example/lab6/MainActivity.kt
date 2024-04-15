package com.example.lab6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.lab6.adapter.ViewPagerAdapter
import com.example.lab6.databinding.ActivityMainBinding
import com.example.lab6.fragments.AthletesFragment
import com.example.lab6.fragments.EventsFragment
import com.example.lab6.fragments.HistoricalArchivesFragment
import com.example.lab6.fragments.NewsFragment
import com.example.lab6.fragments.ProfileFragment
import com.example.lab6.fragments.SportsFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tabTitles = listOf("Sports", "News", "Athletes", "Events", "Historic Archives", "Profile")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = listOf(SportsFragment(), NewsFragment(), AthletesFragment(), EventsFragment() , HistoricalArchivesFragment(), ProfileFragment() )

        binding.viewPager.adapter = ViewPagerAdapter(this, fragments)

        TabLayoutMediator(binding.navTabBar, binding.viewPager, ){tab, position->
            tab.text = tabTitles[position]
        }.attach()

        binding.viewPager.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {

                when(position){
                    1-> binding.bottomNavBar.selectedItemId = R.id.navigation_news
                    3-> binding.bottomNavBar.selectedItemId = R.id.navigation_events
                    4-> binding.bottomNavBar.selectedItemId = R.id.navigation_historical_archives
                    else ->{
                        binding.bottomNavBar.selectedItemId = R.id.navigation_hidden
                    }
                }
                super.onPageSelected(position)
            }



        })

        binding.bottomNavBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_news -> {
                    binding.viewPager.currentItem = 1
                    true
                }
                R.id.navigation_events -> {
                    binding.viewPager.currentItem = 3
                    true
                }
                R.id.navigation_historical_archives -> {
                    binding.viewPager.currentItem = 4
                    true
                }

                else -> true
            }
        }





    }



}