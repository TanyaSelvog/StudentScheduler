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

    public String toString() {
        return "Assessment{" +
                "assessmentID=" + assessmentID +
                ", assessmentName='" + assessmentName + '\'' +
                ", assessmentType='" + assessmentType + '\'' +
                ", assessmentDate='" + assessmentDate + '\'' +
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
    public Assessment(int assessmentID, String assessmentName, String assessmentType, String assessmentDate) {
        this.assessmentID = assessmentID;
        this.assessmentName = assessmentName;
        this.assessmentType = assessmentType;
        this.assessmentDate = assessmentDate;
    }





}
