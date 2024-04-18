package com.example.riskprofileassessment.data.repository

import android.content.Context
import com.example.riskprofileassessment.R
import com.example.riskprofileassessment.data.model.Questions
import com.example.riskprofileassessment.utility.readRawJson
import javax.inject.Inject

class QuestionsRepository @Inject constructor(private val context: Context) {
    suspend fun getQuestions(): Questions {
        return context.readRawJson(R.raw.questions)
    }
}