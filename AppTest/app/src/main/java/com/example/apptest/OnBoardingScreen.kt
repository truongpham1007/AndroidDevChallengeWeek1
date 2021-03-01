package com.example.apptest.ui.theme

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.*
import com.example.apptest.R
import com.example.apptest.Routes

@Composable
fun OnBoardingScreen(
    navController: NavController
) {
    OnBoardingUI(navController = navController)
}

@Composable
fun OnBoardingUI(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.orange))
    ) {
        Spacer(Modifier.requiredHeight(100.dp))
        Image(
            painter = painterResource(R.drawable.art_puppy),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .clip(CircleShape) ,
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.Center
        )

        Spacer(Modifier.requiredHeight(16.dp))

        Text(
            text = stringResource(R.string.adopt_puppy),
            color = colorResource(id = R.color.dark_grey),
            style = LocalTextStyle.current.copy(
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(resId = R.font.nunito_bold))
            )
        )
        Handler(Looper.getMainLooper()).postDelayed(
            {
                navController.navigate(Routes.PUPPY_LIST_SCREEN)
            },
            2000
        )
    }

}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    AppTestTheme(darkTheme = true) {
        OnBoardingScreen(navController = rememberNavController())
    }
}

