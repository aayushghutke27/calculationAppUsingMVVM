package com.example.learnmvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.learnmvvm.R
import com.example.learnmvvm.databinding.ActivityMainBinding
import com.example.learnmvvm.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        calculatorViewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)


        binding.calculateBtn.setOnClickListener {
            val num1 = binding.editText1.text.toString().toIntOrNull() ?: 0
            val num2 = binding.editText2.text.toString().toIntOrNull() ?: 0

            val result = calculatorViewModel.calculateSum(num1, num2)

            binding.showResult.text = "${result.sum}"

        }
    }
}