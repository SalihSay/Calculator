package com.example.hesaplayc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var textView: TextView
    private var isNegative = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        textView = findViewById(R.id.textViewResult)
    }

    fun buttonClick(view: View) {
        val button = view as Button
        val number = button.text.toString()

        if (editText.isFocused) {
            editText.append(number)
        } else if (editText2.isFocused) {
            editText2.append(number)
        }
    }

    fun toggleSign(view: View) {
        val activeEditText = if (editText.hasFocus()) editText else editText2

        // Eğer sayı girilmişse çıkarma işlemi yap
        val sayi1 = editText.text.toString().toDoubleOrNull()
        val sayi2 = editText2.text.toString().toDoubleOrNull()

        if (sayi1 != null && sayi2 != null) {
            textView.text = "Sonuç: ${sayi1 - sayi2}"
        } else {
            // Sayı girilmemişse işareti değiştirme işlemi yap
            val currentText = activeEditText.text.toString()
            if (currentText.isEmpty() || !currentText.startsWith("-")) {
                activeEditText.setText("-$currentText")
            } else if (currentText.startsWith("-")) {
                activeEditText.setText(currentText.removePrefix("-"))
            }
            activeEditText.setSelection(activeEditText.text.length)
        }
    }



    private fun toggleSignInEditText(editText: EditText) {
        val currentText = editText.text.toString()
        if (currentText.isNotEmpty()) {
            if (currentText.startsWith("-")) {
                editText.setText(currentText.removePrefix("-"))
            } else {
                editText.setText("-$currentText")
            }
            editText.setSelection(editText.text.length)
        }
    }

    fun topla(view: View) {
        val sayi1 = editText.text.toString().toDoubleOrNull()
        val sayi2 = editText2.text.toString().toDoubleOrNull()
        if (sayi1 == null || sayi2 == null) {
            textView.text = "Sayı girmeyi unutmayınız!"
        } else {
            textView.text = "Sonuç: ${sayi1 + sayi2}"
        }
    }

    fun cikar(view: View) {
        val sayi1 = editText.text.toString().toDoubleOrNull()
        val sayi2 = editText2.text.toString().toDoubleOrNull()
        if (sayi1 == null || sayi2 == null) {
            textView.text = "Sayı girmeyi unutmayınız!"
        } else {
            textView.text = "Sonuç: ${sayi1 - sayi2}"
        }
    }

    fun bol(view: View) {
        val sayi1 = editText.text.toString().toDoubleOrNull()
        val sayi2 = editText2.text.toString().toDoubleOrNull()
        if (sayi1 == null || sayi2 == null) {
            textView.text = "Sayı girmeyi unutmayınız!"
        } else if (sayi2 == 0.0) {
            textView.text = "Sıfıra bölme hatası!"
        } else {
            textView.text = "Sonuç: ${sayi1 / sayi2}"
        }
    }

    fun carp(view: View) {
        val sayi1 = editText.text.toString().toDoubleOrNull()
        val sayi2 = editText2.text.toString().toDoubleOrNull()
        if (sayi1 == null || sayi2 == null) {
            textView.text = "Sayı girmeyi unutmayınız!"
        } else {
            textView.text = "Sonuç: ${sayi1 * sayi2}"
        }
    }
}
