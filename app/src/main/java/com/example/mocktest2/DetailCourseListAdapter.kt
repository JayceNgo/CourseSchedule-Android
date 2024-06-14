package com.example.mocktest2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mocktest2.database.schedule.CourseSchedule
import com.example.mocktest2.databinding.CourseItemBinding
import com.example.mocktest2.databinding.DetailCourseItemBinding
import java.text.SimpleDateFormat
import java.util.Date


class DetailCourseListAdapter(
    private val  onItemClicked:(CourseSchedule) ->Unit
) :ListAdapter<CourseSchedule, DetailCourseListAdapter.DetailCourseViewHolder>(DiffCallBack){

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailCourseViewHolder {

        val  viewHolder = DetailCourseViewHolder(
            DetailCourseItemBinding.inflate(
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
    override fun onBindViewHolder(holder: DetailCourseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DetailCourseViewHolder(
        private var binding: DetailCourseItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        fun bind(courseSchedule: CourseSchedule){
            binding.courseNameTextView.text = courseSchedule.courseName
            binding.tolTextview.text = SimpleDateFormat(
                "h:mm a MM/dd/yyyy")
                .format(Date(courseSchedule.tOLecture.toLong() * 1000))
        }

    }

}