package com.eneskayiklik.dscmulticamp.model.communitie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Leader(
    val name: String,
    val photo: String
): Parcelable