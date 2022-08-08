package com.example.periodscalculator

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.periodscalculator.Music
import com.example.periodscalculator.ThreeFragment
import com.example.periodscalculator.TwoFragment

class Adapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount()=3

    override fun createFragment(position: Int): Fragment {
        return when(position)
        {
            0->{Music()}
            1->{ TwoFragment() }
            2->{ThreeFragment()}
            else -> {throw Resources.NotFoundException("Position not Found") }
        }
    }
}