package com.laksana.barvolumeapp

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.laksana.barvolumeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var editWidth: EditText
    private lateinit var editLength: EditText
    private lateinit var editHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editLength = binding.editTextPanjang
        editWidth = binding.editTextLebar
        editHeight = binding.editTextTinggi

        binding.btnCalculate.setOnClickListener{
            val inputLength = editLength.text.toString().trim()
            val inputWidth = editWidth.text.toString().trim()
            val inputHeight = editHeight.text.toString().trim()

            var isEmptyFields = false
            if (inputLength.isEmpty()) {
                isEmptyFields = true
                editLength.error = "Field ini tidak boleh kosong"
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                editWidth.error = "Field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                editHeight.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                binding.tvHasil.text = volume.toString()
            }
        }
    }
}

