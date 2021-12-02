package com.example.viewbindingsamples

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.viewbindingsamples.databinding.FragmentThreeBinding

class FragmentThree : Fragment(R.layout.fragment_three) {

    private val fragmentThreeBinding by fragmentViewBinding(FragmentThreeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigate()
    }

    private fun navigate() = with(fragmentThreeBinding) {
        btnDoneFragmentThree.setOnClickListener {
            val str: String = tietFragmentThree.text.toString()
            if(str.isNotEmpty()) {
                Log.d("Message","Str is full")
                toast(str)
            } else {
                Log.d("Message","Str is empty")
                toast("Please, enter a something")
            }
        }

    }
}