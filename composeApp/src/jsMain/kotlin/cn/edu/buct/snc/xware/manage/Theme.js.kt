package cn.edu.buct.snc.xware.manage

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import cn.edu.buct.snc.xware.manage.misc.LoadFontAsync
import cn.edu.buct.snc.xware.manage.misc.loadFontAsync
import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger {}

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

@Composable
actual fun platformComposableInit() {
}

fun loadFontAsyncListened(
    path: String,
    weight: FontWeight,
    style: FontStyle,
    identifier: String? = null,
): LoadFontAsync = loadFontAsync(path, weight, style, identifier, false).also {
    it.onCompleted { result ->
        result.onSuccess {
            logger.debug { "Font loaded: $it" }
            rebuildFontFamily()
            rebuildTypography()
        }
        result.onFailure {
            logger.error { "Font load failed: $it" }
        }
    }
}

val black by loadFontAsyncListened(
    "fonts/NotoSansSC-Black.ttf",
    FontWeight.Black,
    FontStyle.Normal
)
val bold by loadFontAsyncListened(
    "fonts/NotoSansSC-Bold.ttf",
    FontWeight.Bold,
    FontStyle.Normal
)
val extraBold by loadFontAsyncListened(
    "fonts/NotoSansSC-ExtraBold.ttf",
    FontWeight.ExtraBold,
    FontStyle.Normal
)
val extraLight by loadFontAsyncListened(
    "fonts/NotoSansSC-ExtraLight.ttf",
    FontWeight.ExtraLight,
    FontStyle.Normal
)
val light by loadFontAsyncListened(
    "fonts/NotoSansSC-Light.ttf",
    FontWeight.Light,
    FontStyle.Normal
)
val medium by loadFontAsyncListened(
    "fonts/NotoSansSC-Medium.ttf",
    FontWeight.Medium,
    FontStyle.Normal
)
val regular by loadFontAsyncListened(
    "fonts/NotoSansSC-Regular.ttf",
    FontWeight.Normal,
    FontStyle.Normal
)
val semiBold by loadFontAsyncListened(
    "fonts/NotoSansSC-SemiBold.ttf",
    FontWeight.SemiBold,
    FontStyle.Normal
)
val thin by loadFontAsyncListened(
    "fonts/NotoSansSC-Thin.ttf",
    FontWeight.Thin,
    FontStyle.Normal
)

val fontFamilyState: MutableState<FontFamily> = mutableStateOf(FontFamily.Default)

fun rebuildFontFamily() {
    logger.debug { "Rebuilding FontFamily..." }
    val fontList = listOfNotNull(
        black,
        bold,
        extraBold,
        extraLight,
        light,
        medium,
        regular,
        semiBold,
        thin,
    )
    fontFamilyState.value = if (fontList.isNotEmpty())
        FontFamily(
            fonts = fontList
        ) else FontFamily.Default
}

fun rebuildTypography() {
    logger.debug { "Rebuilding Typography..." }
    typographyState.value = Typography(
        displayLarge = baseTypography.displayLarge.copy(fontFamily = fontFamilyState.value),
        displayMedium = baseTypography.displayMedium.copy(fontFamily = fontFamilyState.value),
        displaySmall = baseTypography.displaySmall.copy(fontFamily = fontFamilyState.value),
        headlineLarge = baseTypography.headlineLarge.copy(fontFamily = fontFamilyState.value),
        headlineMedium = baseTypography.headlineMedium.copy(fontFamily = fontFamilyState.value),
        headlineSmall = baseTypography.headlineSmall.copy(fontFamily = fontFamilyState.value),
        titleLarge = baseTypography.titleLarge.copy(fontFamily = fontFamilyState.value),
        titleMedium = baseTypography.titleMedium.copy(fontFamily = fontFamilyState.value),
        titleSmall = baseTypography.titleSmall.copy(fontFamily = fontFamilyState.value),
        bodyLarge = baseTypography.bodyLarge.copy(fontFamily = fontFamilyState.value),
        bodyMedium = baseTypography.bodyMedium.copy(fontFamily = fontFamilyState.value),
        bodySmall = baseTypography.bodySmall.copy(fontFamily = fontFamilyState.value),
        labelLarge = baseTypography.labelLarge.copy(fontFamily = fontFamilyState.value),
        labelMedium = baseTypography.labelMedium.copy(fontFamily = fontFamilyState.value),
        labelSmall = baseTypography.labelSmall.copy(fontFamily = fontFamilyState.value),
    )
}
