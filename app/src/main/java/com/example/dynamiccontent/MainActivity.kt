package com.example.dynamiccontent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.widget.NestedScrollView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // onClick handlers
        findViewById<Button>(R.id.button_fragment1).setOnClickListener {
            insertBlueFragment()
        }

        findViewById<Button>(R.id.button_fragment2).setOnClickListener {
            insertYellowFragment()
        }


        // by default show the blue fragment
        insertBlueFragment()
    }


    private fun insertYellowFragment() {
        val fragment = YellowFragment().apply {
            this.arguments = createArgs()
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun insertBlueFragment() {
        val fragment = BlueFragment().apply {
            this.arguments = createArgs()
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }


    private fun createArgs(): Bundle {
        val scroll = findViewById<NestedScrollView>(R.id.myScrollView)
        val container = findViewById<View>(R.id.fragment_container)

        return Bundle().apply {
            putInt("scroll", scroll.scrollY)
            putInt("height", container.height)
        }
    }


    fun setPaddingBottom(padding: Int) {
        val wrapper = findViewById<View>(R.id.wrapper) // add this ID to your ConstraintLayout
        wrapper.setPadding(0, 0, 0, padding)

        val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(wrapper.width, View.MeasureSpec.EXACTLY)
        val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        wrapper.measure(widthMeasureSpec, heightMeasureSpec)
        wrapper.layout(0, 0, wrapper.measuredWidth, wrapper.measuredHeight)
    }


    fun setScrollPosition(scrollY: Int) {
        val scroll = findViewById<NestedScrollView>(R.id.myScrollView)
        scroll.scrollY = scrollY
    }


}
