package com.example.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.domain.model.Student
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addStudent.setOnClickListener {
            val id = binding.editStudentId.text.toString().toInt()
            val name = binding.editStudentName.text.toString()
            CoroutineScope(Dispatchers.IO).launch {
            viewModel.insertStudent(Student(id,name))
                Toast.makeText(applicationContext,"성공",Toast.LENGTH_SHORT).show()
            }
        }

    }
}