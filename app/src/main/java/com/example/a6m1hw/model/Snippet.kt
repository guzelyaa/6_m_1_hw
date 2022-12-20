package com.example.a6m1hw.model

data class Snippet(
    var channelId: String? = null,
    var channelTitle: String? = null,
    var description: String? = null,
    var localized: Localized? = null,
    var publishedAt: String? = null,
    var thumbnails: Thumbnails? = null,
    var title: String? = null
)