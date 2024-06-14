package com.example.mocktest2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mocktest2.database.schedule.CourseSchedule
import com.example.mocktest2.databinding.CourseItemBinding
import java.text.SimpleDateFormat
import java.util.Date


class CourseListAdapter(
    private val  onItemClicked:(CourseSchedule) ->Unit
) :ListAdapter<CourseSchedule, CourseListAdapter.CourseViewHolder>(DiffCallBack){

    companion object{
        private val DiffCallBack = object : DiffUtil.ItemCallback<CourseSchedule>() {
            override fun areItemsTheSame(oldItem: CourseSchedule, newItem: CourseSchedule): Boolean {

                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CourseSchedule, newItem: CourseSchedule): Boolean {

                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {

        val  viewHolder = CourseViewHolder(
            CourseItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return viewHolder
    }
    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CourseViewHolder(
        private var binding: CourseItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        fun bind(courseSchedule: CourseSchedule){
            binding.courseNameTextView.text = courseSchedule.courseName
            binding.courseCodeTextView.text = courseSchedule.courseCode
            binding.nocTextview.text = courseSchedule.nOCredit.toString()
        }

    }

}