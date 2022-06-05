package mobile.app.development.studentscheduler.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mobile.app.development.studentscheduler.DB.Repository;
import mobile.app.development.studentscheduler.Entity.Assessment;
import mobile.app.development.studentscheduler.Entity.Course;
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
        Repository repo = new Repository(getApplication());

    }

    public void onCoursesClick(View view) {
        Intent intentCourses = new Intent(MainActivity.this, CourseList.class);
        startActivity(intentCourses);
    }

    public void EnterHere(View view){
        Intent intent=new Intent(MainActivity.this,CourseList.class);
        startActivity(intent);
        Repository repo=new Repository(getApplication());
        Course c = new Course(1, "Logic 101", "Loveelace", "05/01/2022", "10/31/2022");
        repo.insert(c);
    }
}