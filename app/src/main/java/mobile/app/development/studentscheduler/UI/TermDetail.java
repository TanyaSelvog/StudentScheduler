package mobile.app.development.studentscheduler.UI;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mobile.app.development.studentscheduler.DB.Repository;
import mobile.app.development.studentscheduler.Entity.Course;
import mobile.app.development.studentscheduler.Entity.Term;
import mobile.app.development.studentscheduler.R;

public class TermDetail extends AppCompatActivity {
    EditText editTitle;
    EditText editStartDate;
    EditText editEndDate;
    String title;
    String startDate;
    String endDate;
    Repository repo;
    int termID;
    int courseID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_detail);
        editTitle = findViewById(R.id.editTitle);
        editStartDate = findViewById(R.id.editStartDate);
        editEndDate = findViewById(R.id.editEndDate);
        termID = getIntent().getIntExtra("termID", -1);
        title = getIntent().getStringExtra("termName");
        startDate = getIntent().getStringExtra("startTermDate");
        endDate = getIntent().getStringExtra("endTermDate");
        editTitle.setText(title);
        editStartDate.setText(startDate);
        editEndDate.setText(endDate);
        RecyclerView recyclerView = findViewById(R.id.partrecyclerview);
        repo = new Repository(getApplication());
        final CourseAdapter courseAdapter = new CourseAdapter(this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Course> filteredParts= new ArrayList<>();
        for(Course p:repo.getAllCourses()){
            if(p.getTermID()==termID)filteredParts.add(p);
        }
        courseAdapter.setCourses(filteredParts);
    }
    public void saveButtonOnClick(View view) {
        Term term;
        if (termID == -1) {
            int newTermID = repo.getAllTerms().get(repo.getAllTerms().size() - 1).getTermID() + 1;
            term = new Term(newTermID, editTitle.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString());
            repo.insert(term);
        } else {
            term = new Term(termID, editTitle.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString());
            repo.update(term);

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_termlist, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        /**    case R.id.refreshTerm:
                RecyclerView recyclerView = findViewById(R.id.partrecyclerview);
                repository = new Repository(getApplication());
                final TermAdapter partAdapter = new Term(this);
                recyclerView.setAdapter(termAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                List<Part> filteredParts = new ArrayList<>();
                for (Part p : repository.getAllParts()) {
                    if (p.getProductID() == productID) filteredParts.add(p);
                }
                partAdapter.setParts(filteredParts);
                return true;
            case R.id.deleteTerm:
           // use partList.java for resource
        }
*/
        }
        return super .onOptionsItemSelected(item);
   // }

        }
    }





