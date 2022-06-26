package com.martial.nasapod.model

import com.martial.nasapod.utils.formatDate

data class GalaxyUI(
    val title: String,
    val imageUrl: String,
    val hdImageUrl: String,
    val description: String,
    val createdOn: String,
    val copyrightBy: String? = null
)

fun GalaxyDetailItem.toGalaxyUI(): GalaxyUI {
    return GalaxyUI(
        title = title,
        description = explanation,
        imageUrl = url,
        hdImageUrl = hdurl,
        createdOn = date.formatDate("yyyy-MM-dd", "MMMM dd, yyyy"),
        copyrightBy = copyright?.let { "\u00A9 $it" } ?: ""
    )
}