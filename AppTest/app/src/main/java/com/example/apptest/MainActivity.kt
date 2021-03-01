package com.example.apptest

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.apptest.Routes.PUPPY_LIST_DETAIL_ARGUMENT
import com.example.apptest.Routes.PUPPY_LIST_DETAIL_SCREEN
import com.example.apptest.ui.theme.AppTestTheme
import com.example.apptest.ui.theme.OnBoardingScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTestTheme() {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.ONBOARDING_SCREEN) {

        composable(Routes.ONBOARDING_SCREEN) {
            OnBoardingScreen(navController = navController)
        }

        composable(Routes.PUPPY_LIST_SCREEN) {
            PuppyListScreen(navController = navController)
        }

        composable(
            route = PUPPY_LIST_DETAIL_SCREEN,
            arguments = listOf(navArgument(PUPPY_LIST_DETAIL_ARGUMENT) { type = NavType.IntType })
        ) {
            it.arguments?.getInt(PUPPY_LIST_DETAIL_ARGUMENT)?.let { puppyID ->
                PuppyListDetailScreen(
                    navController,
                    puppyID
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    AppTestTheme() {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    AppTestTheme(darkTheme = true) {
        MyApp()
    }
}
