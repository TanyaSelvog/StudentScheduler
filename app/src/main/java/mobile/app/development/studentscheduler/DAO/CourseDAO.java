package mobile.app.development.studentscheduler.DAO;


import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import mobile.app.development.studentscheduler.Entity.Course;

@Dao
public interface CourseDAO {
    @Insert(onConflict =OnConflictStrategy. IGNORE)
    void insert(Course course);

}
