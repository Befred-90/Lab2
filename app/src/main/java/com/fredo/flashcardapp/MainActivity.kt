package com.fredo.flashcardapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.flashcard_question).setOnClickListener {
            findViewById<View>(R.id.flashcard_question).visibility = View.INVISIBLE
            findViewById<View>(R.id.flashcard_answer).visibility = View.VISIBLE
        }


        findViewById<View>(R.id.flashcard_answer).setOnClickListener {
            findViewById<View>(R.id.flashcard_question).visibility = View.VISIBLE
            findViewById<View>(R.id.flashcard_answer).visibility = View.INVISIBLE
        }

    }
}