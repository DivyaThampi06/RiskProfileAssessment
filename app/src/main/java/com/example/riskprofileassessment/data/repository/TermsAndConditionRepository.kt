package com.example.riskprofileassessment.data.repository

import android.content.Context
import com.example.riskprofileassessment.R
import com.example.riskprofileassessment.data.model.Terms
import com.example.riskprofileassessment.utility.readRawJson
import javax.inject.Inject

class TermsAndConditionRepository @Inject constructor(private val context: Context) {
    suspend fun getTermsAndConditions(): Terms {
        return context.readRawJson(R.raw.terms)
    }
}