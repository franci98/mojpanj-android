package si.kflabs.mojpanj.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import si.kflabs.mojpanj.R

val SourceSansPro = FontFamily(
    //Normal
    Font(R.font.sourcesanspro_extralight, FontWeight.W200),
    Font(R.font.sourcesanspro_light, FontWeight.W300),
    Font(R.font.sourcesanspro_regular, FontWeight.W400),
    Font(R.font.sourcesanspro_semibold, FontWeight.W600),
    Font(R.font.sourcesanspro_bold, FontWeight.W700),
    Font(R.font.sourcesanspro_black, FontWeight.W900),

    //Italic
    Font(R.font.sourcesanspro_extralightitalic, FontWeight.W200),
    Font(R.font.sourcesanspro_lightitalic, FontWeight.W300),
    Font(R.font.sourcesanspro_semibolditalic, FontWeight.W600),
    Font(R.font.sourcesanspro_bolditalic, FontWeight.W700),
    Font(R.font.sourcesanspro_blackitalic, FontWeight.W900),
    )
// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = SourceSansPro,
    h1 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 104.sp,
        letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 65.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 52.sp,
        letterSpacing = 0.sp
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 37.sp,
        letterSpacing = 0.25.sp
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
        letterSpacing = 0.sp
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        letterSpacing = 0.1.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        letterSpacing = 0.5.sp
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        letterSpacing = 0.25.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        letterSpacing = 1.25.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        letterSpacing = 0.4.sp
    ),
    overline = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        letterSpacing = 1.5.sp
    ),


    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)