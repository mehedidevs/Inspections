package com.mehedi.inspections.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.mehedi.inspections.data.Inspection

@BindingAdapter("headLine")
fun bindHeadline(textView: TextView, inspection: Inspection?) {
    inspection?.let {
        textView.text = inspection.propertyName
    }
}