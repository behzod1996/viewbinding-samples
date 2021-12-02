package com.example.viewbindingsamples

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.viewbindingsamples.databinding.FragmentTwoBinding

class FragmentTwo : Fragment(R.layout.fragment_two) {

    // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)
    // private var fragmentBinding : FragmentTwoBinding? = null
    private val fragmentBinding by fragmentViewBinding(FragmentTwoBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fragmentBinding.btnDone.setOnClickListener {
            val str: String = fragmentBinding.etFragmentOne.text.toString()
            if(str.isNotEmpty()) {
                toast(str)
            } else {
                toast("Please, enter a something")
            }
        }
    }
}