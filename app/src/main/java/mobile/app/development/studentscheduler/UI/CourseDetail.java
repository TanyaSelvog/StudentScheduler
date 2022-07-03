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

public class CourseDetail extends AppCompatActivity {
    EditText editTextPhone;
    EditText title_edit;
    String title;
    String phone;
    Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        editTextPhone = findViewById(R.id.editTextPhone);
        title_edit = findViewById(R.id.title_edit);
        phone = getIntent().getStringExtra("phone");
        title = getIntent().getStringExtra("courseTitle");
        editTextPhone.setText(phone);
        title_edit.setText(title);
        repo=new Repository(getApplication());

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_course_notes, menu);
        return true;
    }




}
