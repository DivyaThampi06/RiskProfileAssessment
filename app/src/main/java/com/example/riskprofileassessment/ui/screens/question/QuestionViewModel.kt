package com.example.riskprofileassessment.ui.screens.question

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riskprofileassessment.data.model.Questions
import com.example.riskprofileassessment.data.repository.QuestionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val questionsRepository: QuestionsRepository,
    private val dispatcher: CoroutineDispatcher
): ViewModel() {
    private val _uiState = MutableStateFlow(QuestionUIState())
    val uiState = _uiState.asStateFlow()

    init {
        getQuestions()
    }

    private fun getQuestions() = viewModelScope.launch(dispatcher) {
        val questions = questionsRepository.getQuestions()
        _uiState.update { currentState ->
            currentState.copy(
                questions = questions
            )
        }
        _uiState.update { currentState ->
            currentState.copy(
                currentQuestion = 0
            )
        }
    }

    fun nextQuestion() {
        if(_uiState.value.currentQuestion < _uiState.value.questions.questions.lastIndex) {
            _uiState.update { currentState ->
                currentState.copy(
                    currentQuestion = currentState.currentQuestion + 1
                )
            }
        }
    }

    fun previousQuestion() {
        if(_uiState.value.currentQuestion != 0) {
            _uiState.update { currentState ->
                currentState.copy(
                    currentQuestion = currentState.currentQuestion - 1
                )
            }
        }
    }
}

data class QuestionUIState(
    val questions: Questions = Questions(listOf()),
    val currentQuestion: Int = -1
)