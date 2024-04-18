package com.example.riskprofileassessment.ui.screens.userinfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserInfo(startClicked: () -> Unit = {}) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 10.dp)
        .padding(bottom = 10.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp)) {
        var fullNameTextFieldState by remember { mutableStateOf("") }
        var emailTextFieldState by remember { mutableStateOf("") }
        var mobileTextFieldState by remember { mutableStateOf("") }

        Text(text = "Enter the user details to start the assessment and calculate the Risk Profile")

        OutlinedTextField(value = fullNameTextFieldState,
            onValueChange = {
                fullNameTextFieldState = it
            },
            placeholder = {
                Text(text = "Full Name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next))
        OutlinedTextField(value = emailTextFieldState,
            onValueChange = {
                emailTextFieldState = it
            },
            placeholder = {
                Text(text = "Email")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next))
        OutlinedTextField(value = mobileTextFieldState,
            onValueChange = {
                mobileTextFieldState = it
            },
            placeholder = {
                Text(text = "Mobile Number")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Done))

        Spacer(modifier = Modifier.weight(1f))

        ElevatedButton(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            onClick = startClicked) {
            Text("Start",
                style = TextStyle(fontSize = 18.sp))
        }
    }
}