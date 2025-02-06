package com.example.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Student
import com.example.presentation.databinding.ItemUserBinding

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    private var students: List<Student> = emptyList()

    fun submitList(newStudents: List<Student>) {
        students = newStudents
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int = students.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.binding.tvNo.text = students.get(position).id.toString()
        holder.binding.tvName.text = students.get(position).name
    }
    class CustomViewHolder(val binding : ItemUserBinding):RecyclerView.ViewHolder(binding.root)
}