package mobile.app.development.studentscheduler.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "courses")
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int courseID;

    private String courseName;
}
