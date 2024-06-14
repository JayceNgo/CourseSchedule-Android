package com.example.mocktest2

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class DetailCourseFragmentArgs(
  public val courseName: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("courseName", this.courseName)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("courseName", this.courseName)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DetailCourseFragmentArgs {
      bundle.setClassLoader(DetailCourseFragmentArgs::class.java.classLoader)
      val __courseName : String?
      if (bundle.containsKey("courseName")) {
        __courseName = bundle.getString("courseName")
        if (__courseName == null) {
          throw IllegalArgumentException("Argument \"courseName\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"courseName\" is missing and does not have an android:defaultValue")
      }
      return DetailCourseFragmentArgs(__courseName)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailCourseFragmentArgs {
      val __courseName : String?
      if (savedStateHandle.contains("courseName")) {
        __courseName = savedStateHandle["courseName"]
        if (__courseName == null) {
          throw IllegalArgumentException("Argument \"courseName\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"courseName\" is missing and does not have an android:defaultValue")
      }
      return DetailCourseFragmentArgs(__courseName)
    }
  }
}
