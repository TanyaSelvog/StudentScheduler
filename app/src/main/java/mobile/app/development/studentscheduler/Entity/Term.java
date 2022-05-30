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

}