package com.example.a6m1hw.model

import java.io.Serializable

data class Item(
    var contentDetails: ContentDetails? = null,
    var etag: String? = null,
    var id: String? = null,
    var kind: String? = null,
    var snippet: Snippet? = null
):Serializable