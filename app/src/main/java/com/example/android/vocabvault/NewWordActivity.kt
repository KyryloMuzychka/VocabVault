
package com.example.android.vocabvault

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewWordActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        val originalWordView = findViewById<EditText>(R.id.original_word)
        val translatedWordView = findViewById<EditText>(R.id.translated_word)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(originalWordView.text) || TextUtils.isEmpty(translatedWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val originalWordText = originalWordView.text.toString()
                val translatedWordText = translatedWordView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, arrayListOf(originalWordText, translatedWordText) )

                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}
