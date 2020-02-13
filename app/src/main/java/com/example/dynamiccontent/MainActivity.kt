package com.example.dynamiccontent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, YellowFragment())
        transaction.commit()
    }


    private fun insertBlueFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, BlueFragment())
        transaction.commit()
    }


}
