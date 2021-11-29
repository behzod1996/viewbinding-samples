package com.example.viewbindingsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewbindingsamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Create an instance of ActivityMainBinding
    // as we have only one layout activity_main.xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}