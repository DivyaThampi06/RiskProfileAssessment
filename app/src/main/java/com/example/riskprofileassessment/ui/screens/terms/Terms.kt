package com.example.riskprofileassessment.ui.screens.terms

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.riskprofileassessment.navigation.Route

fun NavHostController.gotoTerms() {
    navigate(Route.Terms.value)
}

@Composable
fun Terms(acceptClicked: () -> Unit = {},
          rejectClicked: () -> Unit = {}) {
    val termsViewModel: TermsViewModel = hiltViewModel()
    val termsState = termsViewModel.uiState.collectAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.background)
        .padding(10.dp)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .weight(weight = 1f, fill = false)) {
            Text(text = termsState.value.terms.title,
                style = TextStyle(fontSize = 25.sp,
                    fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = termsState.value.terms.content)
        }
        Spacer(modifier = Modifier
            .height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            OutlinedButton(modifier = Modifier
                .weight(1f)
                .height(50.dp),
                onClick = rejectClicked) {
                Text("Reject",
                    style = TextStyle(fontSize = 18.sp))
            }
            ElevatedButton(modifier = Modifier
                .weight(1f)
                .height(50.dp),
                onClick = acceptClicked) {
                Text("Accept",
                    style = TextStyle(fontSize = 18.sp))
            }
        }
    }
}