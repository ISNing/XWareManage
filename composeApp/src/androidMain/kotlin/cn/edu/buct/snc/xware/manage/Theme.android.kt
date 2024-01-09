package cn.edu.buct.snc.xware.manage

import android.annotation.SuppressLint
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable

@Composable
actual fun PlatformSpecifiedAppTheme(
    colorScheme: ColorScheme,
    shapes: Shapes,
    typography: Typography,
    content: @Composable () -> Unit
) = MaterialTheme(
    colorScheme = colorScheme,
    shapes = shapes,
    typography = typography,
    content = content
)

@SuppressLint("ComposableNaming")
@Composable
actual fun platformComposableInit() {
    // no-op
}
