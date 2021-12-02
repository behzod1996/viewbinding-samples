package com.example.viewbindingsamples


import android.content.Context
import android.view.View

import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

// It shows a toast message via an extension function for activity
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Fragment.toast(message: String) {
    Toast.makeText(requireContext(),message,Toast.LENGTH_LONG).show()
}

// It helps to replace easily fragments in activity
// https://stackoverflow.com/questions/45713747/any-code-improvement-in-adding-replacing-fragment
// https://proandroiddev.com/kotlin-extensions-to-commit-fragments-safely-de06218a1f4
fun AppCompatActivity.replaceFragmentSafely(
    fragment: Fragment,
    @IdRes resId: Int
) {
    supportFragmentManager.beginTransaction().apply {
        replace(resId,fragment)
        addToBackStack(null)
        commit()
    }
}

// It gets a string id
fun View.getString(resId: Int): String {
    return resources.getString(resId)
}
// It shows a visible of view
fun View.visible() {
    this.visibility = View.VISIBLE
}
// It shows a gone of view
fun View.gone() {
    this.visibility = View.GONE
}