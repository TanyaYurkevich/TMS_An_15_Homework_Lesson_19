package com.example.tms_an_15_homework_lesson_19

import android.app.Activity
import android.content.Intent
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import java.util.Date
import java.util.Locale

class CreatingNote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creating_note)
        val button = findViewById<AppCompatButton>(R.id.cr_button)
        button.setOnClickListener {
            val titleCr = findViewById<AppCompatEditText>(R.id.cr_title)
            val textCr = findViewById<AppCompatEditText>(R.id.cr_text)
            val date = getCurrentDate()
            val title = titleCr.text.toString()
            val text = textCr.text.toString()
            if (title.isEmpty() && text.isEmpty()) {
                Toast.makeText(this, "No data to save", Toast.LENGTH_SHORT).show()
            }
            if (!title.isEmpty() || !text.isEmpty()) {
                val newNote = ItemNote(date,title, text)
                Intent().let {
                    it.putExtra(NEW_NOTE, newNote)
                    setResult(Activity.RESULT_OK, it)
                    finish()
                }
            }
        }
    }
    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        return dateFormat.format(Date())
    }
    companion object {
        const val NEW_NOTE = "Note"
    }
}
