package com.eneskayiklik.dscmulticamp.model.communitiy

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CommunityItem(
    val banner: String,
    val description: String,
    val leader: Leader,
    val links: Links,
    val name: String
): Parcelable