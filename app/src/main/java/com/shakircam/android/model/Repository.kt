package com.shakircam.android.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


data class Repository(
    val items: List<Item>,
) {

    @Parcelize
    data class Item(
        val description: String?,
        val full_name: String,
        val name: String,
        val owner: @RawValue Owner,
        val updated_at: String
    ): Parcelable

    @Parcelize
    data class Owner(
        val login: String,
        val avatar_url: String
    ): Parcelable
}