package com.example.mocktest2.database.schedule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CourseSchedule(
    @PrimaryKey @ColumnInfo(name = "Id") val id:Int,
    @ColumnInfo(name = "CourseCode") val courseCode:String,
    @ColumnInfo(name = "CourseName") val courseName:String,
    @ColumnInfo(name = "NOCredit") val nOCredit:Int,
    @ColumnInfo(name = "TOLecture") val tOLecture:Int,
)
