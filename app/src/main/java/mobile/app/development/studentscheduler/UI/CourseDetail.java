package mobile.app.development.studentscheduler.UI;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import mobile.app.development.studentscheduler.DB.Repository;
import mobile.app.development.studentscheduler.R;
import mobile.app.development.studentscheduler.Entity.Course;

public class CourseDetail extends AppCompatActivity {
    EditText editTextPhone;
    EditText editStartDate;
    EditText editEndDate;
    EditText editInstructor;
    EditText editEmail;
    EditText title_edit;
    String title;
    String phone;
    String startDate;
    String endDate;
    String instructor;
    String email;
    Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        editTextPhone = findViewById(R.id.editTextPhone);
        title_edit = findViewById(R.id.courseTitle);
        editStartDate=findViewById(R.id.editStartDate);
        editEndDate=findViewById(R.id.editEndDate);
        editInstructor=findViewById(R.id.editInstructor);
       // editEmail=findViewById(R.id.editEmail);

        phone = getIntent().getStringExtra("phone");
        editTextPhone.setText(phone);

        title = getIntent().getStringExtra("courseTitle");
        title_edit.setText(title);

        startDate = getIntent().getStringExtra("startCourseDate");
        editStartDate.setText(startDate);

        endDate=getIntent().getStringExtra("endCourseDate");
        editEndDate.setText(endDate);

        instructor=getIntent().getStringExtra("instructorName");
        editInstructor.setText(instructor);

    //    email=getIntent().getStringExtra()

        repo=new Repository(getApplication());

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_course_notes, menu);
        return true;
    }




}
