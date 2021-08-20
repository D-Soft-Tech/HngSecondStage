package com.example.hngsecondstage

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hngsecondstage.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var ingressiveLogo: ImageView
    private lateinit var zuriLogo: ImageView
    private lateinit var saveBtn: Button
    private lateinit var inputText: TextInputEditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // View Initialization
        ingressiveLogo = binding.imageView
        zuriLogo = binding.imageView2
        saveBtn = binding.button
        inputText = binding.textEt
        resultTextView = binding.textView

        // onclick listener on The save button
        saveBtn.setOnClickListener {
            // validate the input textInputEditText
            if (inputText.text.toString().trim().isNotEmpty()) {
                resultTextView.text = inputText.text.toString()
                inputText.setText("")
            } else {
                inputText.error = "Field can not be empty"
            }
            closeSoftKeyboard()
        }

        // link to zuri website at the onclick of the logos
        ingressiveLogo.setOnClickListener {
            linkToZuriWebsite()
        }

        zuriLogo.setOnClickListener {
            linkToZuriWebsite()
        }
    }

    private fun linkToZuriWebsite() {
        val webPage = Uri.parse("https://internship.zuri.team")
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        startActivity(intent)
    }

    private fun closeSoftKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
