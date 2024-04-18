package com.example.riskprofileassessment.data.model

import kotlinx.serialization.Serializable
import javax.annotation.concurrent.Immutable


@Immutable
@Serializable
data class Terms(
    val content: String = "",
    val title: String = ""
)