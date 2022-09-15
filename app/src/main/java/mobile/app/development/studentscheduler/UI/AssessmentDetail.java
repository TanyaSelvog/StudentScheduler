package mobile.app.development.studentscheduler.UI;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.util.Date;

import mobile.app.development.studentscheduler.DB.Repository;
import mobile.app.development.studentscheduler.Entity.Assessment;
import mobile.app.development.studentscheduler.Entity.Course;
import mobile.app.development.studentscheduler.R;

public class AssessmentDetail extends AppCompatActivity {
    TextView editTitle;
    TextView editEndDate;
    String title;
    String date;
    String testType;
    int assessmentID;
    Assessment currentAssessment;
    Repository repo;
    int courseID;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    String test;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_assessment_detail);
            editTitle = findViewById(R.id.tv8);
            title = getIntent().getStringExtra("assessmentName");
            editTitle.setText(title);
            assessmentID = getIntent().getIntExtra("assessmentID", -1);
            editEndDate = findViewById(R.id.editTD1);
            date = getIntent().getStringExtra("assessmentDate");
            editEndDate.setText(date);
            courseID = getIntent().getIntExtra("courseID", courseID);
            repo = new Repository(getApplication());

            for (Assessment co : repo.getAllAssessments()) {
                if (co.getAssessmentID() == assessmentID) {
                    currentAssessment = co;
                }
            }
        }
    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        //String test;
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.obj_btn:
                if (checked)
                    test = "Objective";
                    break;
            case R.id.perf_btn:
                if (checked)
                    test = "Performance";
                    // Ninjas rule
                    break;
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_assessments, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R. id.saveAssessment:
                radioGroup = (RadioGroup) findViewById(R.id.radio_group);
                int radioID=radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(radioID);
                String radioTest=radioButton.getText().toString();
                Assessment assessment;

                if (assessmentID == -1) {
                 int newID = repo.getAllAssessments().size();
                //9.14.2022 test
                 //   int newID = repo.getAllAssessments().get(repo.getAllAssessments().size() - 1).getAssessmentID() + 1;
                    assessment = new Assessment(newID, editTitle.getText().toString(), radioTest, editEndDate.getText().toString(), courseID);
                    Toast.makeText(getApplicationContext(), test+ " "+ newID+ "  has been saved" , Toast.LENGTH_LONG).show();
                    repo.insert(assessment);
                // delete (pending further review) 9/7/2022
          //      }else {
            //        assessment = new Assessment(assessmentID, editTitle.getText().toString(), radioTest, editEndDate.getText().toString(), courseID);
              //      Toast.makeText(AssessmentDetail.this, assessment.getAssessmentName() + " was updated.", Toast.LENGTH_LONG).show();
                //    repo.update(assessment);
                }
               finish();
    //            Intent intent=new Intent(AssessmentDetail.this,CourseDetail.class);
      //          startActivity(intent);
                return true;

            case R.id.deleteAssessment:

                for (Assessment co : repo.getAllAssessments()) {
                    if (co.getAssessmentID() == assessmentID) {
                        currentAssessment = co;
                    }
                    repo.delete(currentAssessment);
                    Toast.makeText(AssessmentDetail.this, "Assessment was deleted", Toast.LENGTH_LONG).show();

                }}
        return super.onOptionsItemSelected(item);
        }

    public void saveButtonOnClick(View view) {
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        int radioID=radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(radioID);
        String radioTest=radioButton.getText().toString();
        Assessment assessment;

            if (assessmentID == -1) {
                int newID = repo.getAllAssessments().size();
                assessment = new Assessment(newID, editTitle.getText().toString(), radioTest, editEndDate.getText().toString(), courseID);
                Toast.makeText(getApplicationContext(), assessment.getAssessmentName()+ "  has been saved" , Toast.LENGTH_LONG).show();
                repo.insert(assessment);

            }else {
                assessment = new Assessment(assessmentID, editTitle.getText().toString(), radioTest, editEndDate.getText().toString(), courseID);
                Toast.makeText(AssessmentDetail.this, assessment.getAssessmentName() + " was updated.", Toast.LENGTH_LONG).show();
                repo.update(assessment);
            }
        Intent intent=new Intent(AssessmentDetail.this,AssessmentList.class);
        startActivity(intent);
        }
    }



