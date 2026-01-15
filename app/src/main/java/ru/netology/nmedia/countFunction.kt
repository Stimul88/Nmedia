package ru.netology.nmedia

import android.annotation.SuppressLint

@SuppressLint("DefaultLocale")
fun countFunction (count: Int) = when(count) {
    in 0..999 -> count.toInt().toString()
    in 1000 .. 9999 -> String.format("%.3f", (count/1000.0)).dropLast(2).trimEnd('0','.').plus('K')
    in 10000 .. 999999 ->String.format("%d", (count/1000.0).toInt()).plus('K')
    else -> String.format("%.2f", (count/1000000.0)).dropLast(1).trimEnd('0','.').plus('M')
}
