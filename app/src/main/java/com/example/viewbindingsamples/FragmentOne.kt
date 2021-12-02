package com.example.viewbindingsamples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.viewbindingsamples.databinding.FragmentOneBinding

class FragmentOne : Fragment() {

    // assign the _binding variable initially to null and
    // also when the view is destroyed again it has to be set to null
    private var _binding: FragmentOneBinding? = null
    // with the backing property of the kotlin we extract
    // the non null value of the _binding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneBinding.inflate(layoutInflater)
        navigateToFragmentTwo()
        return binding.root
    }

    private fun navigateToFragmentTwo() {
        binding.btnDone.setOnClickListener {
            val str: String = binding.etFragmentOne.text.toString()
            if(str.isNotEmpty()) {
                toast(str)
            } else {
                toast("Please, a enter something")
            }
        }
    }
    

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}