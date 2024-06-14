package com.example.mocktest2.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mocktest2.database.schedule.CourseSchedule
import com.example.mocktest2.database.schedule.ScheduleDao
import kotlinx.coroutines.flow.Flow

class CourseSheduleListViewModel(private val scheduleDao: ScheduleDao):ViewModel() {
    fun fullSchedule(): Flow<List<CourseSchedule>> = scheduleDao.getAll()

    fun scheduleForCourseDetail(name: String): Flow<List<CourseSchedule>> = scheduleDao.getByCourseName(name)
}

class CourseSheduleListViewModelFactory(
    private val scheduleDao: ScheduleDao
) : ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>, extras: CreationExtras) :T{
        if (modelClass.isAssignableFrom(CourseSheduleListViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CourseSheduleListViewModel(scheduleDao) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}