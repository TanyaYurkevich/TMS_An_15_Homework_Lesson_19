package com.example.tms_an_15_homework_lesson_19

import android.os.Parcel
import android.os.Parcelable

data class ItemNote(
    val date: String?,
    val title: String,
    val text: String,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeString(title)
        parcel.writeString(text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemNote> {
        override fun createFromParcel(parcel: Parcel): ItemNote {
            return ItemNote(parcel)
        }

        override fun newArray(size: Int): Array<ItemNote?> {
            return arrayOfNulls(size)
        }
    }
}

