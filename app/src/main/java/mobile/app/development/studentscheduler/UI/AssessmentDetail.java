package mobile.app.development.studentscheduler.UI;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.util.Date;

import mobile.app.development.studentscheduler.DB.Repository;
import mobile.app.development.studentscheduler.Entity.Assessment;
import mobile.app.development.studentscheduler.R;

public class AssessmentDetail extends AppCompatActivity {
    TextView editTitle;
    TextView editEndDate;
    String title;
    String date;
    int assessmentID;
    Assessment current;
    Repository repo;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_assessment_detail);
            editTitle=findViewById(R.id.tv8);
            title=getIntent().getStringExtra("assessmentName");
            editTitle.setText(title);
            assessmentID = getIntent().getIntExtra("assessmentID", -1);
            editEndDate=findViewById(R.id.editTD1);
            date = getIntent().getStringExtra("assessmentDate");
            editEndDate.setText(date);
            repo = new Repository(getApplication());

        }

    public void onRadioButtonClicked(View view) {
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


            case R.id.deleteAssessment:

                    repo.delete(current);
                    Toast.makeText(AssessmentDetail.this, "Course was deleted", Toast.LENGTH_LONG).show();
                }
        return super.onOptionsItemSelected(item);
    }


}

