package com.example.compiler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.compiler.databinding.FragmentCodeEditorBinding

class CodeEditor : Fragment() {

    companion object {
        private const val ARG_LANGUAGE = "language"
        fun newInstance(language: String): CodeEditor {
            val fragment = CodeEditor()
            val args = Bundle()
            args.putString(ARG_LANGUAGE, language)
            fragment.arguments = args
            return fragment
        }
    }

    private var _binding: FragmentCodeEditorBinding? = null
    private val binding get() = _binding!!
    private var language: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        language = arguments?.getString(ARG_LANGUAGE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCodeEditorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getCode(): String {
        return binding.editTextCode.text.toString()
    }

    fun setOutput(result: String) {
        binding.tvOutput.text = result
    }

    fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }
}