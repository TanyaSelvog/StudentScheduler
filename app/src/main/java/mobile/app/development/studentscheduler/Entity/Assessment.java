package mobile.app.development.studentscheduler.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "assessments")
public class Assessment {
    @PrimaryKey (autoGenerate = true)
    private int assessmentID;

    private String assessmentName;


}
