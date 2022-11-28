package cm.azeupaul.daily30camerounianfoods.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Food(
    val day: Int,
    @StringRes val name: Int,
    @StringRes val content: Int,
    @DrawableRes val image: Int
)
