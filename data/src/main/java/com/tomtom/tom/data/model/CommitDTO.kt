package com.tomtom.tom.data.model

import com.google.gson.annotations.SerializedName

open class CommitDTO() {
        @SerializedName("commit")
        val innerCommit: InnerCommit? = null

        open class InnerCommit() {
                @SerializedName("author")
                val author: Author? = null
                @SerializedName("message")
                val message: String? = null

                open class Author() {
                        @SerializedName("date")
                        val id: String? = null
                }
        }

}
