package mobile.app.development.studentscheduler.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(tableName = "courses")
public class Course {
    public Course(int courseID, String courseTitle, String instructorName, LocalDate startCourseDate, LocalDate endCourseDate) {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.instructorName = instructorName;
        this.startCourseDate = startCourseDate;
        this.endCourseDate = endCourseDate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseTitle='" + courseTitle + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", startCourseDate=" + startCourseDate +
                ", endCourseDate=" + endCourseDate +
                '}';
    }

    @PrimaryKey(autoGenerate = true)
    private int courseID;

    private String courseTitle;
    private String instructorName;

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public LocalDate getStartCourseDate() {
        return startCourseDate;
    }

    public void setStartCourseDate(LocalDate startCourseDate) {
        this.startCourseDate = startCourseDate;
    }

    public LocalDate getEndCourseDate() {
        return endCourseDate;
    }

    public void setEndCourseDate(LocalDate endCourseDate) {
        this.endCourseDate = endCourseDate;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getCourseID() {
        return courseID;
    }

    private LocalDate startCourseDate;
    private LocalDate endCourseDate;

}
