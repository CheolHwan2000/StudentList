package com.example.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.model.Student
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
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
            }
            binding.editStudentId.text = null
            binding.editStudentName.text = null
            Toast.makeText(applicationContext,"등록되었습니다.",Toast.LENGTH_SHORT).show()
        }
        binding.listStudent.setOnClickListener {
            val intent = Intent(this,ListActivity::class.java)
            startActivity(intent)
        }
    }
}