package com.example.periodscalculator

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.periodscalculator.Adapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tablayout:TabLayout=findViewById(R.id.tabs)
        val viewpager:ViewPager2=findViewById(R.id.pager)
        viewpager.adapter= Adapter(this)
        TabLayoutMediator(tablayout,viewpager){tab,index->
            tab.text=when(index){
                0->{"Chats"}
                1->{"Status"}
                2->{"Calls"}
                else -> {throw Resources.NotFoundException("Tab not found")}
            }
        }

    }
}