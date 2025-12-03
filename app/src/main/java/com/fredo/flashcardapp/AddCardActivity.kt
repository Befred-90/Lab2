package com.fredo.flashcardapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class AddCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        val questionEditText = findViewById<EditText>(R.id.edit_question)
        val answerEditText = findViewById<EditText>(R.id.edit_answer)
        val cancelButton = findViewById<ImageButton>(R.id.btn_annuler)
        val saveButton = findViewById<ImageButton>(R.id.btn_save)

        cancelButton.setOnClickListener {
            finish()
        }

        saveButton.setOnClickListener {
            val question = questionEditText.text.toString()
            val answer = answerEditText.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("question", question)
            resultIntent.putExtra("answer", answer)

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}