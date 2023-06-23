package rs.ac.metropolitan.cs330_pz.animacija

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import rs.ac.metropolitan.cs330_pz.R
@Composable
fun Bee() {
    var visible by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .padding(16.dp)
            .size(48.dp)
            .background(Color.Transparent)
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(initialAlpha = 0.1f),
            exit = fadeOut(animationSpec = tween(250))
        ) {
            Image(
                painter = painterResource(R.drawable.bee_image),
                contentDescription = "Bee",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


