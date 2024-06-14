package com.example.mocktest2.database.schedule;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ScheduleDao_Impl implements ScheduleDao {
  private final RoomDatabase __db;

  public ScheduleDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public Flow<List<CourseSchedule>> getAll() {
    final String _sql = "SELECT * FROM CourseSchedule ORDER BY CourseCode ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"CourseSchedule"}, new Callable<List<CourseSchedule>>() {
      @Override
      @NonNull
      public List<CourseSchedule> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfCourseCode = CursorUtil.getColumnIndexOrThrow(_cursor, "CourseCode");
          final int _cursorIndexOfCourseName = CursorUtil.getColumnIndexOrThrow(_cursor, "CourseName");
          final int _cursorIndexOfNOCredit = CursorUtil.getColumnIndexOrThrow(_cursor, "NOCredit");
          final int _cursorIndexOfTOLecture = CursorUtil.getColumnIndexOrThrow(_cursor, "TOLecture");
          final List<CourseSchedule> _result = new ArrayList<CourseSchedule>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CourseSchedule _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCourseCode;
            if (_cursor.isNull(_cursorIndexOfCourseCode)) {
              _tmpCourseCode = null;
            } else {
              _tmpCourseCode = _cursor.getString(_cursorIndexOfCourseCode);
            }
            final String _tmpCourseName;
            if (_cursor.isNull(_cursorIndexOfCourseName)) {
              _tmpCourseName = null;
            } else {
              _tmpCourseName = _cursor.getString(_cursorIndexOfCourseName);
            }
            final int _tmpNOCredit;
            _tmpNOCredit = _cursor.getInt(_cursorIndexOfNOCredit);
            final int _tmpTOLecture;
            _tmpTOLecture = _cursor.getInt(_cursorIndexOfTOLecture);
            _item = new CourseSchedule(_tmpId,_tmpCourseCode,_tmpCourseName,_tmpNOCredit,_tmpTOLecture);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<CourseSchedule>> getByCourseName(final String courseName) {
    final String _sql = "SELECT * FROM CourseSchedule WHERE CourseName = ? ORDER BY CourseCode ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (courseName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, courseName);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"CourseSchedule"}, new Callable<List<CourseSchedule>>() {
      @Override
      @NonNull
      public List<CourseSchedule> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfCourseCode = CursorUtil.getColumnIndexOrThrow(_cursor, "CourseCode");
          final int _cursorIndexOfCourseName = CursorUtil.getColumnIndexOrThrow(_cursor, "CourseName");
          final int _cursorIndexOfNOCredit = CursorUtil.getColumnIndexOrThrow(_cursor, "NOCredit");
          final int _cursorIndexOfTOLecture = CursorUtil.getColumnIndexOrThrow(_cursor, "TOLecture");
          final List<CourseSchedule> _result = new ArrayList<CourseSchedule>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CourseSchedule _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCourseCode;
            if (_cursor.isNull(_cursorIndexOfCourseCode)) {
              _tmpCourseCode = null;
            } else {
              _tmpCourseCode = _cursor.getString(_cursorIndexOfCourseCode);
            }
            final String _tmpCourseName;
            if (_cursor.isNull(_cursorIndexOfCourseName)) {
              _tmpCourseName = null;
            } else {
              _tmpCourseName = _cursor.getString(_cursorIndexOfCourseName);
            }
            final int _tmpNOCredit;
            _tmpNOCredit = _cursor.getInt(_cursorIndexOfNOCredit);
            final int _tmpTOLecture;
            _tmpTOLecture = _cursor.getInt(_cursorIndexOfTOLecture);
            _item = new CourseSchedule(_tmpId,_tmpCourseCode,_tmpCourseName,_tmpNOCredit,_tmpTOLecture);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
