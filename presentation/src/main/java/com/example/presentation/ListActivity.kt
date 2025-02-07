package com.example.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.adapter.CustomAdapter
import com.example.presentation.databinding.ActivityListBinding
import com.example.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {
    lateinit var binding : ActivityListBinding
    lateinit var adapter : CustomAdapter
    val viewModel : MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CustomAdapter()
        binding.studentRv.adapter = adapter
        binding.studentRv.layoutManager = LinearLayoutManager(this)

        viewModel.loadStudents()
        observe()
        binding.searchStudent.setOnClickListener {
            Log.e("ListActivity","searchButton")
            val searchStudent = binding.searchStudent.text.toString()
            if(searchStudent.isNotEmpty()){
            viewModel.searchStudent(searchStudent)
            }else{
                viewModel.loadStudents()
            }
            observe()
        }
    }

    private fun observe(){
        viewModel.students.observe(this) { studentList ->
            studentList?.let {
                adapter.submitList(it)
            } ?: Log.e("ListActivity", "No students found")
        }
    }
}