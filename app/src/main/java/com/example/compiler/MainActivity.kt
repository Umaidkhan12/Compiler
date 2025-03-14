package com.example.compiler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.compiler.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var codePagerAdapter: CodePagerAdapter
    // JDoodle API expects language strings (e.g., "c", "cpp", "python3")
    private val languages = listOf("c", "cpp", "python3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        codePagerAdapter = CodePagerAdapter(this, languages)
        binding.viewPager.adapter = codePagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "C"
                1 -> "C++"
                else -> "Python"
            }
        }.attach()

        binding.fabCompile.setOnClickListener {
            compileCurrentTab()
        }
    }

    private fun compileCurrentTab() {
        val currentItem = binding.viewPager.currentItem
        val fragment = codePagerAdapter.getFragment(currentItem)
        if (fragment != null) {
            val code = fragment.getCode()
            val language = languages[currentItem]
            fragment.showLoading()
            compileCode(language, code) { output ->
                fragment.hideLoading()
                fragment.setOutput(output)
            }
        }
    }

    // Sends the code to the JDoodle API and returns the output via a callback.
    private fun compileCode(language: String, code: String, callback: (String) -> Unit) {
        val url = "https://api.jdoodle.com/v1/execute"
        val requestBody = JSONObject().apply {
            put("script", code)
            put("language", language)
            put("versionIndex", "0")
            put("clientId", BuildConfig.JDOODLE_CLIENT_ID)
            put("clientSecret", BuildConfig.JDOODLE_CLIENT_SECRET)
        }

        val jsonRequest = JsonObjectRequest(
            Request.Method.POST, url, requestBody,
            { response ->
                val output = response.optString("output", "No output received")
                callback(output)
            },
            { error ->
                callback("Error: ${error.networkResponse?.statusCode} - ${String(error.networkResponse?.data ?: ByteArray(0))}")
            }
        )
        Volley.newRequestQueue(this).add(jsonRequest)
    }
}