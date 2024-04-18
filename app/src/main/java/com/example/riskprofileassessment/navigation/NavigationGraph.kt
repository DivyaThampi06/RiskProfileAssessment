package com.example.riskprofileassessment.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.riskprofileassessment.ui.screens.question.Question
import com.example.riskprofileassessment.ui.screens.question.gotoQuestion
import com.example.riskprofileassessment.ui.screens.result.AssessmentResult
import com.example.riskprofileassessment.ui.screens.terms.Terms
import com.example.riskprofileassessment.ui.screens.terms.gotoTerms
import com.example.riskprofileassessment.ui.screens.userinfo.UserInfo

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationGraph(
    navController: NavHostController
){
    NavHost(navController,
        startDestination = Route.UserInfo.value,
        route = Route.MainActivity.value) {
        slideComposable(Route.UserInfo.value) {
            UserInfo(navController::gotoTerms)
        }
        slideComposable(Route.Terms.value) {
            Terms(
                acceptClicked = navController::gotoQuestion,
                rejectClicked = navController::popBackStack
            )
        }
        slideComposable(Route.Question.value) {
            Question()
        }
        slideComposable(Route.AssessmentResult.value) {
            AssessmentResult()
        }
    }
}