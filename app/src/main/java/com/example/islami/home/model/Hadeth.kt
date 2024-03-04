package com.example.islami.home.model
import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hadeth(val title:String , val content :String):Parcelable
