package com.mehedi.inspections

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("headLine")
fun bindHeadline(textView: TextView, inspection: Inspection?) {
    inspection?.let {
        textView.text = inspection.propertyName
    }
}