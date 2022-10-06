package mobile.app.development.studentscheduler.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mobile.app.development.studentscheduler.DB.Repository;
import mobile.app.development.studentscheduler.Entity.Assessment;
import mobile.app.development.studentscheduler.Entity.Course;
import mobile.app.development.studentscheduler.Entity.Term;
import mobile.app.development.studentscheduler.R;

public class MainActivity extends AppCompatActivity {
    public static int numAlert;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Repository repo = new Repository(getApplication());
            Course c = new Course(4, 1,"Logic 101", "Lovelace", "05/01/2022", "10/31/2022", "608-100-1000", "Lovelace@WGU.edu", "In progress", "Exam is a project");
        //    Course d = new Course(2,  1,"Cats 101", "Garfield", "09/01/2022", "10/31/2022", "206-101-0033", "ProfGarfield@Cats.edu", "Plan to take", "This is a note");
            Course e = new Course(3,  2,"Doggos 301", "Milan", "10/01/2022", "1/31/2023", "206-309-4457", "Doggos4Life@yahoo.com", "In progress", "Great teacher");
            repo.insert(c);
            Term termTest = new Term(1, "Spring 2022", "05/01/2022", "10/31/2022");
            Term termTest2 = new Term(2, "Fall 2022", "10/01/2022", "1/31/2023");
            Term test3 = new Term(3, "Spring 2023", "04/01/2023", "06/01/2023");
      //      repo.insert(test3);
        }

  /**  public void onTermsClick(View view) {
        Intent intentTerms = new Intent(MainActivity.this, TermsList. );
       // view.setAction(Intent.ACTION_VIEW);
        //view.setData(Uri.parse());
        startActivity(intentTerms);
    }
*/
    public void onAssessmentsClick(View view) {
        Intent intentAssessments = new Intent(MainActivity.this, AssessmentList.class);
        startActivity(intentAssessments);


    }

   // public void onCoursesClick(View view) {
     //   Intent intentCourses = new Intent(MainActivity.this, CourseList.class);
       // startActivity(intentCourses);
    //}

    public void onCoursesClick(View view){
        Intent intent=new Intent(MainActivity.this,CourseList.class);
        startActivity(intent);
        //Repository repo=new Repository(getApplication());
    //    Course c = new Course(1, 1,"Logic 101", "Lovelace", "05/01/2022", "10/31/2022", "608-100-1000", "Lovelace@WGU.edu", 1, "Exam is a project");
      //  Course d = new Course(2,  1,"Cats 101", "Garfield", "09/01/2022", "10/31/2022", "206-101-0033", "ProfGarfield@Cats.edu", 2, "This is a note");
        //repo.insert(c);
    }


    public void onTermsClick(View view){
        Intent intent=new Intent(MainActivity.this,TermsList.class);
        startActivity(intent);
    }
}