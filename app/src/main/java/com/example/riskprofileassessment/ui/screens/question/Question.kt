package com.example.riskprofileassessment.ui.screens.question

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.riskprofileassessment.data.model.Question
import com.example.riskprofileassessment.navigation.Route
import com.example.riskprofileassessment.ui.customviews.AnimatedLinearProgressIndicator

fun NavHostController.gotoQuestion() {
    navigate(Route.Question.value)
}

@Composable
fun Question() {
    val questionViewModel: QuestionViewModel = hiltViewModel()
    val questionUIState = questionViewModel.uiState.collectAsState()
    val currentQuestionIndex = questionUIState.value.currentQuestion
    val questions = questionUIState.value.questions.questions
    val currentQuestion = if(currentQuestionIndex == -1) {
        Question()
    }
    else {
        questions[currentQuestionIndex]
    }
    BackHandler {
        questionViewModel.previousQuestion()
    }
    val progressValue = (currentQuestionIndex + 1).toFloat()/questions.size
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.background)) {
        Log.d("Progress", progressValue.toString())
        if(!progressValue.isNaN()) {
            AnimatedLinearProgressIndicator(progressValue)
        }
        Spacer(modifier = Modifier
            .height(20.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(10.dp)
            .weight(weight = 1f)) {
            Text(
                text = currentQuestion.question,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(30.dp))
            QuestionOptions(options = currentQuestion.options)
        }
        Spacer(modifier = Modifier
            .height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            OutlinedButton(modifier = Modifier
                .weight(1f)
                .height(50.dp),
                enabled = currentQuestionIndex != 0,
                onClick = questionViewModel::previousQuestion) {
                Text("Previous",
                    style = TextStyle(fontSize = 18.sp))
            }
            ElevatedButton(modifier = Modifier
                .weight(1f)
                .height(50.dp),
                enabled = currentQuestionIndex != questionUIState.value.questions.questions.lastIndex,
                onClick = questionViewModel::nextQuestion) {
                Text("Next",
                    style = TextStyle(fontSize = 18.sp))
            }
        }
    }
}