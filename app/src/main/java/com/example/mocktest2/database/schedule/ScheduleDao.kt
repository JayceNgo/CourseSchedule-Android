package com.example.mocktest2.database.schedule

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ScheduleDao {

    @Query("SELECT * FROM CourseSchedule ORDER BY CourseCode ASC")
    fun getAll(): Flow<List<CourseSchedule>>

    @Query("SELECT * FROM CourseSchedule WHERE CourseName = :courseName ORDER BY CourseCode ASC" )
    fun getByCourseName(courseName: String): Flow<List<CourseSchedule>>
}