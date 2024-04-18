package com.example.riskprofileassessment.di

import android.content.Context
import com.example.riskprofileassessment.data.repository.QuestionsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuestionsRepositoryModule {
    @Singleton
    @Provides
    fun providesQuestionsRepository(@ApplicationContext context: Context): QuestionsRepository {
        return QuestionsRepository(context)
    }
}