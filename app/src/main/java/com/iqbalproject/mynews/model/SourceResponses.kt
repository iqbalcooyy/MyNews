package com.iqbalproject.mynews.model

data class Sources(
    val sources: List<SourceDetail>? = null
)

data class SourceDetail (
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val category: String? = null,
    val language: String? = null,
    val country: String? = null,
    val url: String? = null
)