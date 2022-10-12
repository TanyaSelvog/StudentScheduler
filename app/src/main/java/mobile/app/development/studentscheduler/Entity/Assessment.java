package mobile.app.development.studentscheduler.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "assessments")
public class Assessment {
    @PrimaryKey(autoGenerate = true)
    private int assessmentID;
    private String assessmentName;
    private String assessmentType;
    private String assessmentDate;
    private String startAssessment;
    private int courseID;

    public String toString() {
        return "Assessment{" +
                "assessmentID=" + assessmentID +
                ", assessmentName='" + assessmentName + '\'' +
                ", assessmentType='" + assessmentType + '\'' +
                ", startAssessment='" + startAssessment + '\'' +
                ", assessmentDate='" + assessmentDate + '\'' +
                ", courseID='" + courseID + '\'' +
                '}';
    }


    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public String getAssessmentDate(){
        return assessmentDate;
    }



    public void setAssessmentDate(String assessmentDate){
        this.assessmentDate = assessmentDate;
    }

    public String getStartAssessment(){
        return startAssessment;
    }



    public void setStartAssessment(String startAssessment){
        this.startAssessment = startAssessment;
    }

    public int getCourseID(){
        return courseID;
    }

    public void setCourseID(int courseID){
        this.courseID = courseID;
    }
    public Assessment(int assessmentID, String assessmentName, String assessmentType, String startAssessment, String assessmentDate, int courseID) {
        this.assessmentID = assessmentID;
        this.assessmentName = assessmentName;
        this.assessmentType = assessmentType;
        this.startAssessment = startAssessment;
        this.assessmentDate = assessmentDate;
        this.courseID = courseID;
    }





}
