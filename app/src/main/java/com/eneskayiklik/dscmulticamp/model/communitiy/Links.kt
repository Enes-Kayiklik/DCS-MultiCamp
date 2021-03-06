package com.eneskayiklik.dscmulticamp.model.communitiy

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links(
    val instagram: String,
    val participation: String,
    val twitter: String,
    val youtube: String
): Parcelable