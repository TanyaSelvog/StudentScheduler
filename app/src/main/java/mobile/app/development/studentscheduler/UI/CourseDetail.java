package mobile.app.development.studentscheduler.UI;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import mobile.app.development.studentscheduler.DB.Repository;
import mobile.app.development.studentscheduler.Entity.Assessment;
import mobile.app.development.studentscheduler.Entity.Term;
import mobile.app.development.studentscheduler.R;
import mobile.app.development.studentscheduler.Entity.Course;

public class CourseDetail extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText editTextPhone;
    EditText editStartDate;
    EditText editEndDate;
    EditText editInstructor;
    EditText editEmail;
    EditText title_edit;
    EditText textStat;
    EditText editNote;
    String note;
    Spinner status;
    String statusCourse;
    String title;
    String phone;
    String startDate;
    String endDate;
    String instructor;
    String email;
    Repository repo;
    int courseID;
    DatePickerDialog.OnDateSetListener sDate;
    final Calendar myCalendarStart = Calendar.getInstance();
    String myFormat;
    SimpleDateFormat sdf;
    Course currentCourse;
    int assessmentCount;
    int termID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        courseID = getIntent().getIntExtra("courseID", -1);

        //@TODO TEST BEFORE editing 10.4
        termID = getIntent().getIntExtra("termID", termID);

        editTextPhone = findViewById(R.id.editTextPhone);
        title_edit = findViewById(R.id.courseTitle);
        editStartDate = findViewById(R.id.editStartDate);
        myFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        editStartDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Date date;
                String info = editStartDate.getText().toString();
                if (info.equals("")) info = "02/10/22";
                try {
                    myCalendarStart.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(CourseDetail.this, sDate, myCalendarStart
                        .get(Calendar.YEAR), myCalendarStart.get(Calendar.MONTH),
                        myCalendarStart.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        sDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalendarStart.set(Calendar.YEAR, year);
                myCalendarStart.set(Calendar.MONTH, monthOfYear);
                myCalendarStart.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelStart();
            }
        };

        editEndDate = findViewById(R.id.editEndDate);
        editInstructor = findViewById(R.id.editInstructor);
        editEmail = findViewById(R.id.editEmail);
        editNote = findViewById(R.id.editNote);
        textStat=findViewById(R.id.textStat);

        phone = getIntent().getStringExtra("phone");
        editTextPhone.setText(phone);

        note = getIntent().getStringExtra("courseNote");
        editNote.setText(note);

        title = getIntent().getStringExtra("courseTitle");
        title_edit.setText(title);

        startDate = getIntent().getStringExtra("startCourseDate");
        editStartDate.setText(startDate);

        endDate = getIntent().getStringExtra("endCourseDate");
        editEndDate.setText(endDate);


        statusCourse = getIntent().getStringExtra("status");
        textStat.setText(statusCourse);

        instructor = getIntent().getStringExtra("instructorName");
        editInstructor.setText(instructor);

        email = getIntent().getStringExtra("email");
        editEmail.setText(email);

        repo = new Repository(getApplication());
        List<Assessment> attachedAssessments = new ArrayList<>();
        for (Assessment a: repo.getAllAssessments()) {
            if (a.getCourseID() == courseID){
                attachedAssessments.add(a);
            }
        }
        assessmentCount = attachedAssessments.size();
        for (Course co : repo.getAllCourses()) {
            if (co.getCourseID() == courseID) {
                currentCourse = co;
            }
        }


        status = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.status_array, android.R.layout.simple_spinner_item);
        status.setAdapter(adapter);
        //  status.setSelection(status);


        //    Spinner spinner = findViewById(R.id.spinner);
        //  spinner.setOnItemSelectedListener(this);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter.getDropDownView(int position, View convertView, ViewGroup parent);

// Apply the adapter to the spinner
        //   spinner.setAdapter(adapter);

        //Course Menu
    }
    private void updateLabelStart(){
        editStartDate.setText(sdf.format(myCalendarStart.getTime()));
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_course_notes, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
/**
 *
 *
 *
 * case R.id.saveCourse:
 *               Course course;
 *                 if (courseID == -1) {
 *                     int newID = repo.getAllCourses().size();
 *                     course = new Course(newID, termID, title_edit.getText().toString(), editInstructor.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString(),
 *                             editTextPhone.getText().toString(), editEmail.getText().toString(), status.getSelectedItem().toString(), editNote.getText().toString());
 *
 *                     repo.insert(course);
 *                     Toast.makeText(getApplicationContext(), "Course has been saved.", Toast.LENGTH_LONG).show();
 *                 } else {
 *                     course = new Course(courseID,termID, title_edit.getText().toString(), editInstructor.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString(),
 *                             editTextPhone.getText().toString(), editEmail.getText().toString(), status.getSelectedItem().toString(), editNote.getText().toString());
 *                     repo.update(course);
 *                     Toast.makeText(getApplicationContext(), "Course has been updated.", Toast.LENGTH_LONG).show();
 *                     return true;
 */


            case R.id.shareNote:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, editNote.getText().toString());
                sendIntent.putExtra(Intent.EXTRA_TITLE, "Message title");
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
                return true;

            case R.id.startDateAlert:
                String dateFromScreen = editStartDate.getText().toString();
                Date myDate=null;
                try {
                    myDate = sdf.parse(dateFromScreen);
                }catch (ParseException e){
                    e.printStackTrace();
                }
                Long trigger = myDate.getTime();
                Intent intent = new Intent(CourseDetail.this, MyReceiver.class);
                intent.putExtra("key", "The course: " + title + " starts on: " + dateFromScreen);
                PendingIntent sender=PendingIntent.getBroadcast(CourseDetail.this,MainActivity.numAlert++, intent, 0);
                AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,trigger, sender);
                return true;
            case R.id.endDateAlert:
                String dateScreen = editEndDate.getText().toString();
                Date dateMine=null;
                try {
                    dateMine = sdf.parse(dateScreen);
                }catch (ParseException e){
                    e.printStackTrace();
                }
                Long triggerLong = dateMine.getTime();
                Intent in = new Intent(CourseDetail.this, MyReceiver.class);
                in.putExtra("key", "The course: " + title + " ends on: " + dateScreen);
                PendingIntent senderIntent=PendingIntent.getBroadcast(CourseDetail.this,MainActivity.numAlert++, in, 0);
                AlarmManager a=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
                a.set(AlarmManager.RTC_WAKEUP,triggerLong, senderIntent);
                return true;

            case R.id.addAssessment:

                Intent intentAssessment = new Intent(CourseDetail.this, AssessmentDetail.class);
                intentAssessment.putExtra("courseID", courseID);
                startActivity(intentAssessment);
                return true;

            case R.id.deleteCourse:
                if (assessmentCount != 0){
                    Toast.makeText(getApplicationContext(), "Course has an associated assessment. Course can't be deleted.", Toast.LENGTH_LONG).show();
                }else {
                    repo.delete(currentCourse);
                    Toast.makeText(CourseDetail.this, "Course was deleted", Toast.LENGTH_LONG).show();
                }}
        return super.onOptionsItemSelected(item);
    }

    public void saveButtonOnClick(View view) {

        Course course;
        if (courseID == -1) {
            int newID = repo.getAllCourses().size();
            course = new Course(++newID, termID, title_edit.getText().toString(), editInstructor.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString(),
                    editTextPhone.getText().toString(), editEmail.getText().toString(), status.getSelectedItem().toString(), editNote.getText().toString());

            repo.insert(course);
            Toast.makeText(CourseDetail.this, "Course was added.", Toast.LENGTH_LONG).show();

        }else {
            course = new Course(courseID, termID, title_edit.getText().toString(),editInstructor.getText().toString(),editStartDate.getText().toString(), editEndDate.getText().toString(),
                    editTextPhone.getText().toString(),editEmail.getText().toString(),  status.getSelectedItem().toString(),editNote.getText().toString());


            repo.update(course);
            Toast.makeText(CourseDetail.this, "Course was edited.", Toast.LENGTH_LONG).show();

        }
        Intent intent=new Intent(CourseDetail.this,CourseList.class);
        startActivity(intent);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        parent.getItemAtPosition(pos);
        //used for getting item and then to display it on screen with code below (but in final project - dont need)
        String item = parent.getItemAtPosition(pos).toString();
        //   textStat.setText(item);
        // Showing selected spinner item
        //   Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}