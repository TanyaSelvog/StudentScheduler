package mobile.app.development.studentscheduler.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import mobile.app.development.studentscheduler.DB.Repository;
import mobile.app.development.studentscheduler.R;
import mobile.app.development.studentscheduler.Entity.Course;

public class CourseDetail extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText editTextPhone;
    EditText editStartDate;
    EditText editEndDate;
    EditText editInstructor;
    EditText editEmail;
    EditText title_edit;
    EditText editNote;
    String note;
    Spinner status;
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
       editEmail=findViewById(R.id.editEmail);
       editNote =findViewById(R.id.editNote);

        phone = getIntent().getStringExtra("phone");
        editTextPhone.setText(phone);

        note = getIntent().getStringExtra("courseNote");
        editNote.setText(note);

        title = getIntent().getStringExtra("courseTitle");
        title_edit.setText(title);

        startDate = getIntent().getStringExtra("startCourseDate");
        editStartDate.setText(startDate);

        endDate=getIntent().getStringExtra("endCourseDate");
        editEndDate.setText(endDate);

        instructor=getIntent().getStringExtra("instructorName");
        editInstructor.setText(instructor);

        email=getIntent().getStringExtra("email");
        editEmail.setText(email);

        repo=new Repository(getApplication());

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.status_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter.getDropDownView(int position, View convertView, ViewGroup parent);

// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    //Course Menu
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_course_notes, menu);
        return true;
    }
public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.shareNote:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent .putExtra(Intent.EXTRA_TEXT, editNote.getText().toString());
                sendIntent.putExtra(Intent.EXTRA_TITLE, "Message title");
                sendIntent.setType("text/plain");
                Intent shareIntent=Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
                return true;
            case R.id.notify:
                return true;
        }
        return super.onOptionsItemSelected(item);
}


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        parent.getItemAtPosition(pos);
        //used for getting item and then to display it on screen with code below (but in final project - dont need)
        String item = parent.getItemAtPosition(pos).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
