package com.enhance.it.app.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Repo(
    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("description")
    val description: String?,

    @Expose
    @SerializedName("avatar_url")
    val avatar_url: String?

)