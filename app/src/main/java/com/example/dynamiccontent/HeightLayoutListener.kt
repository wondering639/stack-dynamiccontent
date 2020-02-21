package com.example.dynamiccontent

import android.view.View
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment
import kotlin.math.max

class HeightLayoutListener(
    private val activity: MainActivity,
    private val root: View,
    private val previousHeight: Int,
    private val targetScroll: Int
) : ViewTreeObserver.OnGlobalLayoutListener {

    override fun onGlobalLayout() {
        root.viewTreeObserver.removeOnGlobalLayoutListener(this)

        val padding = max((previousHeight - root.height), 0)
        activity.setPaddingBottom(padding)
        activity.setScrollPosition(targetScroll)
    }

    companion object {

        fun create(fragment: Fragment): HeightLayoutListener {
            val activity = fragment.activity as MainActivity
            val root = fragment.view!!
            val previousHeight = fragment.requireArguments().getInt("height")
            val targetScroll = fragment.requireArguments().getInt("scroll")

            return HeightLayoutListener(activity, root, previousHeight, targetScroll)
        }
    }
}