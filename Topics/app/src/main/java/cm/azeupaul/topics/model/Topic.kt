package cm.azeupaul.topics.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameResourceId: Int,
    val courses: Int,
    @DrawableRes val imageResourceId: Int
)
