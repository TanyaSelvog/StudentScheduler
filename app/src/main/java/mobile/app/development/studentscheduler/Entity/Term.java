package mobile.app.development.studentscheduler.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity(tableName = "term")
public class Term {
    @PrimaryKey (autoGenerate = true)
    private int termID;

    private String termName;
    private LocalDate startTermDate;
    private LocalDate endTermDate;

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

    public LocalDate getStartTermDate() {
        return startTermDate;
    }

    public void setStartTermDate(LocalDate startTermDate) {
        this.startTermDate = startTermDate;
    }

    public LocalDate getEndTermDate() {
        return endTermDate;
    }

    public void setEndTermDate(LocalDate endTermDate) {
        this.endTermDate = endTermDate;
    }

    public Term(int termID, String termName, LocalDate startTermDate, LocalDate endTermDate) {
        this.termID = termID;
        this.termName = termName;
        this.startTermDate = startTermDate;
        this.endTermDate = endTermDate;
    }
}