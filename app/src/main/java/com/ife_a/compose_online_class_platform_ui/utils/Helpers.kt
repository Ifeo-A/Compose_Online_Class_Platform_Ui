package com.ife_a.compose_online_class_platform_ui.utils

import android.content.Context
import android.widget.Toast

fun toast(context: Context, text: String, length: Int = Toast.LENGTH_SHORT){
    Toast.makeText(
        context,
        text,
        length
    ).show()
}

/**
 * Repeat the values in the given array x number of times.
 * It is expected that only one entry is in the given array
 * because this function only repeats the first entry in the array.
 */
fun <T> List<T>.repeat(times: Int): List<T>{

    val listToReturn = mutableListOf<T>()

    for (i in 0 until times){
        listToReturn.add(this[0])
    }

    return listToReturn
}

fun getPlayTimeFromMillis(millis: Long): String{

    val duration = millis / 1000
    val hours = duration / 3600
    val minutes = (duration - hours *3600 ) / 60
    val seconds = duration - (hours * 3600 + minutes * 60)

    return "$hours " +
            if(hours > 1) "hours" else "hour" +
            " $minutes " +
            if(minutes > 1) "minutes" else "minute"

}