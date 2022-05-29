package mobile.app.development.studentscheduler.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mobile.app.development.studentscheduler.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTermsClick(View view) {
        Intent intentTerms = new Intent(MainActivity.this, TermsList.class);
       // view.setAction(Intent.ACTION_VIEW);
        //view.setData(Uri.parse());
        startActivity(intentTerms);
    }

    public void onAssessmentsClick(View view) {
        Intent intentAssessments = new Intent(MainActivity.this, AssessmentList.class);
        startActivity(intentAssessments);
    }

    public void onCoursesClick(View view) {
        Intent intentCourses = new Intent(MainActivity.this, CourseList.class);
        startActivity(intentCourses);
    }
}