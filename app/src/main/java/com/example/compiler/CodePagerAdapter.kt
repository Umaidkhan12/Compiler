package com.example.compiler

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CodePagerAdapter(
    activity: FragmentActivity,
    private val languages: List<String>
) : FragmentStateAdapter(activity) {

    private val fragmentMap = mutableMapOf<Int, CodeEditor>()

    override fun getItemCount(): Int = languages.size

    override fun createFragment(position: Int): Fragment {
        val fragment = CodeEditor.newInstance(languages[position])
        fragmentMap[position] = fragment
        return fragment
    }

    fun getFragment(position: Int): CodeEditor? {
        return fragmentMap[position]
    }
}