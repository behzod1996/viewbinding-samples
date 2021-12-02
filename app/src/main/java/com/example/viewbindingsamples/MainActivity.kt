package com.example.viewbindingsamples


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.viewbindingsamples.databinding.ActivityMainBinding

// To set up an instance of the binding class for use with an activity

class MainActivity : AppCompatActivity() {

    // Create an instance of ActivityMainBinding
    // as we have only one layout activity_main.xml
    private lateinit var binding: ActivityMainBinding

    // onCreate(Bundle) is where you initialize your activity.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Message","Create onCreate()")
        // Call the static inflate() method included in the generated binding class.
        // This creates an instance of the binding class for the activity to use.
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Pass the root view to setContentView() to make it the active view on the screen.
        setContentView(binding.root)
        title = "ViewBinding in Android"
        setUpBinding()
        replace()
    }
    private fun replace() {
        binding.btnNavigateFragmentOne.setOnClickListener {
            Log.d("Message","Navigate Fragment One")
            replaceFragmentSafely(FragmentOne(),R.id.fragment_holder)
        }
        binding.btnNavigateFragmentTwo.setOnClickListener {
            Log.d("Message","Navigate Fragment Two")
            replaceFragmentSafely(FragmentTwo(),R.id.fragment_holder)
        }
        binding.btnNavigateFragmentThree.setOnClickListener {
            Log.d("Message","Navigate Fragment Three")
            replaceFragmentSafely(FragmentThree(),R.id.fragment_holder)
        }
    }


    // ‘with’ for calling functions on context objects without providing the lambda result
    private fun setUpBinding() = with(binding) {
        btnSave.setOnClickListener {
            val str: String = tietText.text.toString()
            if(str.isNotEmpty()){
                toast("You entered ${tietText.text.toString()}")
            } else {
                toast("Please enter something")
            }
        }

    }


    /**
     *ViewBinding without scope functions*

    private fun bind() {
    binding.tvTitle.text = getText(R.string.tv_title)
    binding.tvDescription.text = getText(R.string.tv_description)
    binding.tvDate.text = getText(R.string.tv_date)
    }

    *ViewBinding with apply (scope) function*

    private fun bindingWithApply() {
        binding.apply {
            tvTitle.text = getText(R.string.tv_title)
            tvDescription.text = getText(R.string.tv_title)
            tvDate.text = getText(R.string.tv_title)
        }
    }
    *ViewBinding with scope function*

    private fun bindingWith() = with(binding) {
    btnSave.setOnClickListener {
    val string: String = tietText.text.toString()
    performOperation(string)
    }

    *General function which computes string value*

    private fun performOperation(string: String) {
    if(string.isNotEmpty()) {
    toast("You entered ${binding.tietText.text.toString()}")
    } else {
    toast("Please, enter something")
    }
    }

    *Extension function which computes string value*

    private fun Context.performOperation(string: String) {
    if(string.isNotEmpty()) {
    toast("You entered -> ${binding.tietText.text.toString()}")
    } else {
    toast("Please, enter something")
    }
    }
    */


}