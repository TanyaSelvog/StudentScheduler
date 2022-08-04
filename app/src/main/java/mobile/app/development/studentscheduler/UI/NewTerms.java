package mobile.app.development.studentscheduler.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import mobile.app.development.studentscheduler.DB.Repository;
import mobile.app.development.studentscheduler.Entity.Term;
import mobile.app.development.studentscheduler.R;

public class NewTerms extends AppCompatActivity {
    EditText editTitle;
    EditText editStartDateText;
    EditText editEndDateText;
    String title;
    String startDate;
    String endDate;
    Repository repo;
    int termID;
    int courseID;

    //C&P over term_detail and modifying it (will need to edit/change later 6.27
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_terms);
            editTitle=findViewById(R.id.newTerm);
            editStartDateText=findViewById(R.id.startDateText);
            editEndDateText=findViewById(R.id.endDateText);
            termID=getIntent().getIntExtra("termID", -1);
            title=getIntent().getStringExtra("termName");
            startDate=getIntent().getStringExtra("startTermDate");
            endDate=getIntent().getStringExtra("endTermDate");
            editTitle.setText(title);
            editStartDateText.setText(startDate);
            editEndDateText.setText(endDate);
            repo = new Repository(getApplication());




        }

    public void saveButton(View view) {
            Term term;
            if (termID == -1) {
                int newTermID = repo.getAllTerms().get(repo.getAllTerms().size() - 1).getTermID() + 1;
                term = new Term(newTermID, editTitle.getText().toString(), editStartDateText.getText().toString(), editEndDateText.getText().toString());
                repo.insert(term);
            }else{
                term = new Term(termID, editTitle.getText().toString(), editStartDateText.getText().toString(), editEndDateText.getText().toString());
                repo.update(term);

            }
        }}

