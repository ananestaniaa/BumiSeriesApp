package com.example.uts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NovelClass(
    val novelimg: Int,
    val novelname: String,
    val noveldate: String,
    val novelauthor: String,
    val noveldesc: String,
) : Parcelable