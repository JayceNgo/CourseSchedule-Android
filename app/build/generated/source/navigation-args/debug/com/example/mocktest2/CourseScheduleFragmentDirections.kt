package com.example.mocktest2

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class CourseScheduleFragmentDirections private constructor() {
  private data class ActionCourseScheduleFragmentToDetailCourseFragment(
    public val courseName: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_courseScheduleFragment_to_detailCourseFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("courseName", this.courseName)
        return result
      }
  }

  public companion object {
    public fun actionCourseScheduleFragmentToDetailCourseFragment(courseName: String): NavDirections
        = ActionCourseScheduleFragmentToDetailCourseFragment(courseName)
  }
}
