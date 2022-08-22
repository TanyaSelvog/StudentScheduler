package mobile.app.development.studentscheduler.DB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import mobile.app.development.studentscheduler.DAO.AssessmentDAO;
import mobile.app.development.studentscheduler.DAO.CourseDAO;
import mobile.app.development.studentscheduler.DAO.TermDAO;
import mobile.app.development.studentscheduler.Entity.Assessment;
import mobile.app.development.studentscheduler.Entity.Course;
import mobile.app.development.studentscheduler.Entity.Term;
//everytime you change the database, increment DB version
//includes changing data types
@Database(entities = {Course.class, Assessment.class, Term.class}, version=14, exportSchema = false)
public abstract class  SchedulerDatabaseBuilder extends RoomDatabase {
    public abstract AssessmentDAO assessmentDAO();
    public abstract CourseDAO courseDAO();
    public abstract TermDAO termDAO();

    //build DB instance
    private static volatile SchedulerDatabaseBuilder INSTANCE;

    static SchedulerDatabaseBuilder getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SchedulerDatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SchedulerDatabaseBuilder.class, "mySchedulerDB.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
