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
import com.example.data.local.MyDao
import com.example.data.local.MyDatabase
import com.example.domain.model.Student
import com.example.presentation.adapter.CustomAdapter
import com.example.presentation.databinding.ActivityListBinding
import com.example.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {
    lateinit var binding : ActivityListBinding
    lateinit var adapter : CustomAdapter
    val viewModel : MainViewModel by viewModels()

    lateinit var myDao: MyDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        myDao = MyDatabase.getDatabase(this).myDao()
        var allStudents = myDao.getAllStudentList()

        adapter = CustomAdapter()
        binding.studentRv.adapter = adapter
        binding.studentRv.layoutManager = LinearLayoutManager(this)

        var a = viewModel.getAllUStudent()
        viewModel.students.observe(this){student->
            adapter.submitList(student)
        }
        binding.searchStudent.setOnClickListener {
            adapter.notifyDataSetChanged()
            Log.e("MainActivity","${allStudents.value?.size}")

        }

    }
}