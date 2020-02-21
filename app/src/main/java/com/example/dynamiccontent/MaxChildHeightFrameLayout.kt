package com.example.dynamiccontent

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import kotlin.math.max

class MaxChildHeightFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    // to keep track of max height
    private var maxHeight: Int = 0

    // required to get support the minHeight attribute
    private val minHeight = attrs?.getAttributeValue(
        "http://schemas.android.com/apk/res/android",
        "minHeight"
    )?.substringBefore(".")?.toInt() ?: 0


    override fun getSuggestedMinimumHeight(): Int {
        var maxChildHeight = 0
        for (i in 0 until childCount) {
            maxChildHeight = max(maxChildHeight, getChildAt(i).measuredHeight)
        }
        if (maxHeight != 0 && layoutParams.height < (maxHeight - maxChildHeight) && maxHeight > maxChildHeight) {
            return maxHeight
        } else if (maxHeight == 0 || maxHeight < maxChildHeight) {
            maxHeight = maxChildHeight
        }
        return if (background == null) minHeight else max(
            minHeight,
            background.minimumHeight
        )
    }

}