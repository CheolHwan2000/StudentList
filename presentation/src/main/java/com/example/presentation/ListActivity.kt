package com.example.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
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

        val a = viewModel.getAllUStudent()
        viewModel.students.observe(this){student->
            adapter.submitList(student)
        }
        binding.searchStudent.setOnClickListener {
            adapter.notifyDataSetChanged()
            Log.e("MainActivity","${adapter.itemCount}")

        }

    }
}