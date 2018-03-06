package com.tomtom.tom.data.model

import com.google.gson.annotations.SerializedName

data class RepoDTO (
        @SerializedName("id") val id: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("description") val description: String?
        )

