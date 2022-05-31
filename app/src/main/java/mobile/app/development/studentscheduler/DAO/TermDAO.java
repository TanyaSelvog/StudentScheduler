package mobile.app.development.studentscheduler.DAO;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import mobile.app.development.studentscheduler.Entity.Term;

@Dao
public interface TermDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert (Term term);
}
