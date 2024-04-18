package com.example.riskprofileassessment.ui.screens.terms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riskprofileassessment.data.model.Terms
import com.example.riskprofileassessment.data.repository.TermsAndConditionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TermsViewModel @Inject constructor(
    private val termsAndConditionRepository: TermsAndConditionRepository,
    private val dispatcher: CoroutineDispatcher
): ViewModel() {
    private val _uiState = MutableStateFlow(TermsUIState())
    val uiState = _uiState.asStateFlow()

    init {
        getChargingStations()
    }

    private fun getChargingStations() = viewModelScope.launch(dispatcher) {
        val terms = termsAndConditionRepository.getTermsAndConditions()
        _uiState.update { currentState ->
            currentState.copy(
                terms = terms
            )
        }
    }
}

data class TermsUIState(
    val terms: Terms = Terms()
)