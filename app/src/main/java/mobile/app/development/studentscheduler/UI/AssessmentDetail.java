package mobile.app.development.studentscheduler.UI;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import mobile.app.development.studentscheduler.R;

public class AssessmentDetail extends AppCompatActivity {
    TextView editTitle;
    TextView editEndDate;
    String title;
    String date;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_assessment_detail);
            editTitle=findViewById(R.id.tv8);
            title=getIntent().getStringExtra("assessmentName");
            editTitle.setText(title);

            editEndDate=findViewById(R.id.editTD1);
            date = getIntent().getStringExtra("assessmentDate");
            editEndDate.setText(date);


        }}

