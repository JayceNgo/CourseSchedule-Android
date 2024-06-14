package com.example.mocktest2

import android.app.Application
import com.example.mocktest2.database.AppDatabase

class CourseSchelduleApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }

}