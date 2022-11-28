package cm.azeupaul.daily30camerounianfoods.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cm.azeupaul.daily30camerounianfoods.R

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

val Dancing = FontFamily(
    Font(R.font.dancing_script_regular, FontWeight.Normal),
    Font(R.font.dancing_script_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = Dancing,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    body1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
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