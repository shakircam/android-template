package com.shakircam.android.utils

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import java.text.SimpleDateFormat

class BindingData {

    companion object {


        /** ----------- data binding for github commits ---------- */

        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imageUrl: String?) {
            imageView.load(imageUrl) {
                crossfade(600)
            }
        }

        @SuppressLint("SimpleDateFormat")
        @BindingAdapter("timeFormat")
        @JvmStatic
        fun timeFormat(textView: TextView, date: String) {

            val parser = SimpleDateFormat("yyyy-MM-dd")
            val formatter = SimpleDateFormat("MM/dd/yyyy")
            val formattedDate = formatter.format(parser.parse(date)!!)
            textView.text = formattedDate
        }

    }
}