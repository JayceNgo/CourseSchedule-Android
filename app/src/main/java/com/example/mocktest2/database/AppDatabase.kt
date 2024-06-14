package com.example.mocktest2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mocktest2.database.schedule.CourseSchedule
import com.example.mocktest2.database.schedule.ScheduleDao

@Database(entities = [CourseSchedule::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun scheduleDao():ScheduleDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase?=null

        fun getDatabase(context:Context): AppDatabase{
            return  INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("database/course_schedule.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}