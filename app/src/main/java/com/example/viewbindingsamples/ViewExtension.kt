package com.example.viewbindingsamples

import android.content.Context
import android.view.View

import android.widget.Toast

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
fun View.getString(resId: Int): String {
    return resources.getString(resId)
}
fun View.visible() {
    this.visibility = View.VISIBLE
}
fun View.gone() {
    this.visibility = View.GONE
}