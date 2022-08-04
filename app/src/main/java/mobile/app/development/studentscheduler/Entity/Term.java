package mobile.app.development.studentscheduler.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity(tableName = "term")
public class Term {
    @PrimaryKey (autoGenerate = true)
    private int termID;
    private String termName;
    private String startTermDate;
    private String endTermDate;

    @Override
    public String toString() {
        return "Term{" +
                "termID=" + termID +
                ", termName='" + termName + '\'' +
                ", startTermDate=" + startTermDate +
                ", endTermDate=" + endTermDate +
                '}';
    }

    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }


    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getStartTermDate() {
        return startTermDate;
    }

    public void setStartTermDate(String startTermDate) {
        this.startTermDate = startTermDate;
    }

    public String getEndTermDate() {
        return endTermDate;
    }

    public void setEndTermDate(String endTermDate) {
        this.endTermDate = endTermDate;
    }

    public Term(int termID, String termName, String startTermDate, String endTermDate) {
        this.termID = termID;
        this.termName = termName;
        this.startTermDate = startTermDate;
        this.endTermDate = endTermDate;

    }

}