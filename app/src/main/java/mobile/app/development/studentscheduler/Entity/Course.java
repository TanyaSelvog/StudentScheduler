package mobile.app.development.studentscheduler.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(tableName = "courses")
public class Course {
    public Course(int courseID, String courseTitle, String instructorName, String startCourseDate, String endCourseDate, String phone) {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.instructorName = instructorName;
        this.startCourseDate = startCourseDate;
        this.endCourseDate = endCourseDate;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseTitle='" + courseTitle + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", startCourseDate=" + startCourseDate +
                ", endCourseDate=" + endCourseDate +
                ",phone=" + phone +
                '}';
    }

    @PrimaryKey(autoGenerate = true)
    private int courseID;

    private String courseTitle;
    private String instructorName;
    private String phone;


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

    public String getStartCourseDate() {
        return startCourseDate;
    }

    public void setStartCourseDate(String startCourseDate) {
        this.startCourseDate = startCourseDate;
    }

    public String getEndCourseDate() {
        return endCourseDate;
    }

    public void setEndCourseDate(String endCourseDate) {
        this.endCourseDate = endCourseDate;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getCourseID() {
        return courseID;
    }

    private String startCourseDate;
    private String endCourseDate;



    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

}
