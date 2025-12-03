package com.fredo.flashcardapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)
        val addButton = findViewById<ImageButton>(R.id.btn_add)

        flashcardQuestion.setOnClickListener {
            findViewById<View>(R.id.flashcard_question).visibility = View.INVISIBLE
            findViewById<View>(R.id.flashcard_answer).visibility = View.VISIBLE
        }

        flashcardAnswer.setOnClickListener {
            findViewById<View>(R.id.flashcard_question).visibility = View.VISIBLE
            findViewById<View>(R.id.flashcard_answer).visibility = View.INVISIBLE
        }

        val addCardLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val question = data?.getStringExtra("question")
                val answer = data?.getStringExtra("answer")

                flashcardQuestion.text = question
                flashcardAnswer.text = answer
            }

            flashcardQuestion.visibility = View.VISIBLE
            flashcardAnswer.visibility = View.INVISIBLE
        }

        addButton.setOnClickListener {
            val intent = Intent(this, AddCardActivity::class.java)
            addCardLauncher.launch(intent)
        }
    }
}