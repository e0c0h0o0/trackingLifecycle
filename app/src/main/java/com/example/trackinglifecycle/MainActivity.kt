package com.example.trackinglifecycle

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var buttonSayHello: Button
    private lateinit var editTextHello: EditText
    private lateinit var textViewHello: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")

        // Initialize views
        buttonSayHello = findViewById(R.id.buttonSayHello)
        editTextHello = findViewById(R.id.editTextHello)
        textViewHello = findViewById(R.id.textViewHello)

        // Set a click listener on the button to update the EditText and TextView
        buttonSayHello.setOnClickListener {
            editTextHello.setText("Hello")
            textViewHello.text = "Hello"
        }

        // Restore the state if there is a saved instance
        savedInstanceState?.let {
            editTextHello.setText(it.getString("editTextValue"))
            textViewHello.text = it.getString("textViewValue")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("editTextValue", editTextHello.text.toString())
        outState.putString("textViewValue", textViewHello.text.toString())
        Log.d(TAG, "onSaveInstanceState: ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        editTextHello.setText(savedInstanceState.getString("editTextValue"))
        textViewHello.text = savedInstanceState.getString("textViewValue")
        Log.d(TAG, "onRestoreInstanceState: ")
    }
}
