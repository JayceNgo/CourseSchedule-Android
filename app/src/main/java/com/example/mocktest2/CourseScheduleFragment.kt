package com.example.mocktest2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mocktest2.databinding.FragmentCourseScheduleBinding
import com.example.mocktest2.viewmodels.CourseSheduleListViewModel
import com.example.mocktest2.viewmodels.CourseSheduleListViewModelFactory
import kotlinx.coroutines.launch

class CourseScheduleFragment : Fragment() {
    private var _binding: FragmentCourseScheduleBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private val viewModel: CourseSheduleListViewModel by activityViewModels {
        CourseSheduleListViewModelFactory(
            (activity?.application as CourseSchelduleApplication).database.scheduleDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCourseScheduleBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val courseListAdapter = CourseListAdapter {
            val action = CourseScheduleFragmentDirections
                .actionCourseScheduleFragmentToDetailCourseFragment(
                    courseName = it.courseName
                )
            view.findNavController().navigate(action)
        }
        recyclerView.adapter = courseListAdapter
        lifecycle.coroutineScope.launch {
            viewModel.fullSchedule().collect() {
                courseListAdapter.submitList(it)
            }
        }
    }
}