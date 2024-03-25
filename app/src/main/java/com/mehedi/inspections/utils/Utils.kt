package com.mehedi.inspections.utils

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mehedi.inspections.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun Fragment.toast(msg: String) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()

}

fun Long.toDateMonth(): String {
    val dateFormat = SimpleDateFormat("d, MMM", Locale.ENGLISH)
    return dateFormat.format(Date(this))
}

fun Long.toDateMonthTime(): String {
    val dateFormat = SimpleDateFormat("dd/M/yy 'at' hh:mm a", Locale.ENGLISH)
    return dateFormat.format(Date(this))
}


fun View.handleVisibility(txtView: TextView) {
    if (visibility == View.VISIBLE) {
        txtView.setCompoundDrawablesRelativeWithIntrinsicBounds(
            0,
            0,
            R.drawable.ic_down_arrow,
            0
        )
        hide()
    } else {
        txtView.setCompoundDrawablesRelativeWithIntrinsicBounds(
            0,
            0,
            R.drawable.ic_up_arrow,
            0
        )
        show()
    }

}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}
