package mobile.app.development.studentscheduler.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import mobile.app.development.studentscheduler.DB.Repository;
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

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_term_detail);
            editTitle=findViewById(R.id.editTitle);
            editStartDate=findViewById(R.id.editStartDate);
            editEndDate=findViewById(R.id.editEndDate);
            termID=getIntent().getIntExtra("termID", -1);
            title=getIntent().getStringExtra("termName");
            startDate=getIntent().getStringExtra("startTermDate");
            endDate=getIntent().getStringExtra("endTermDate");
            editTitle.setText(title);
            editStartDate.setText(startDate);
            editEndDate.setText(endDate);
            repo = new Repository(getApplication());




        }

    public void saveButtonOnClick(View view) {
            Term term;
            if (termID == -1) {
                int newTermID = repo.getAllTerms().get(repo.getAllTerms().size() - 1).getTermID() + 1;
                        term = new Term(newTermID, editTitle.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString());
                repo.insert(term);
            }else{
                term = new Term(termID, editTitle.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString());
                        repo.update(term);

    }
}}
