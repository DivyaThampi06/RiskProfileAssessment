package com.example.riskprofileassessment.data.model

import kotlinx.serialization.Serializable
import javax.annotation.concurrent.Immutable

@Immutable
@Serializable
data class Questions(
    val questions: List<Question>
)

@Immutable
@Serializable
data class Question(
    val options: List<Option> = listOf(),
    val question: String = ""
)

@Immutable
@Serializable
data class Option(
    val option: String,
    val score: Int
)