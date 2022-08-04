package mobile.app.development.studentscheduler.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(tableName = "courses")
public class Course {
    public Course(int courseID, int termID, String courseTitle, String instructorName, String startCourseDate, String endCourseDate, String phone, String email, int status, String courseNote) {
        this.courseID = courseID;
        this.termID=termID;
        this.courseTitle = courseTitle;
        this.instructorName = instructorName;
        this.startCourseDate = startCourseDate;
        this.endCourseDate = endCourseDate;
        this.phone = phone;
        this.email=email;
        this.status=status;
        this.courseNote=courseNote;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                "termID=" + termID +
                ", courseTitle='" + courseTitle + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", startCourseDate=" + startCourseDate +
                ", endCourseDate=" + endCourseDate +
                ",phone=" + phone +
                ",email=" + email +
                ",status=" + status +
                ",courseNote=" + courseNote +
                '}';
    }

    @PrimaryKey(autoGenerate = true)
    private int courseID;
    private int termID;
    private String courseTitle;
    private String instructorName;
    private String phone;
    private String email;
    private String startCourseDate;
    private String endCourseDate;
    private int status;
    private String courseNote;
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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

    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourseNote() {
        return courseNote;
    }

    public void setCourseNote(String courseNote){
        this.courseNote=courseNote;
    }
}
