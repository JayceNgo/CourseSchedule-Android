package com.example.mocktest2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mocktest2.databinding.FragmentDetailCourseBinding
import com.example.mocktest2.viewmodels.CourseSheduleListViewModel
import com.example.mocktest2.viewmodels.CourseSheduleListViewModelFactory
import kotlinx.coroutines.launch


class DetailCourseFragment : Fragment() {
    companion object {
        var Course_Name = "courseName"
    }

    private var _binding: FragmentDetailCourseBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private lateinit var courseName: String

    private val viewModel: CourseSheduleListViewModel by activityViewModels {
        CourseSheduleListViewModelFactory(
            (activity?.application as CourseSchelduleApplication).database.scheduleDao()
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            courseName = it.getString(Course_Name).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailCourseBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val airlineAdapter = DetailCourseListAdapter{}
        // by passing in the stop name, filtered results are returned,
        // and tapping rows won't trigger navigation
        recyclerView.adapter = airlineAdapter
        lifecycle.coroutineScope.launch {
            viewModel.scheduleForCourseDetail(courseName).collect() {
                airlineAdapter.submitList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}