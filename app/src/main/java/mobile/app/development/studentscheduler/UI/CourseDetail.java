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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
    int courseID;
    DatePickerDialog.OnDateSetListener sDate;
    final Calendar myCalendarStart = Calendar.getInstance();
    String myFormat;
    SimpleDateFormat sdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

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

        instructor = getIntent().getStringExtra("instructorName");
        editInstructor.setText(instructor);

        email = getIntent().getStringExtra("email");
        editEmail.setText(email);

        repo = new Repository(getApplication());

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
            case R.id.shareNote:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, editNote.getText().toString());
                sendIntent.putExtra(Intent.EXTRA_TITLE, "Message title");
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
                return true;
            case R.id.notify:
                String dateFromScreen = editStartDate.getText().toString();
                Date myDate=null;
                try {
                    myDate = sdf.parse(dateFromScreen);
                }catch (ParseException e){
                    e.printStackTrace();
                }
                Long trigger = myDate.getTime();
                Intent intent = new Intent(CourseDetail.this, MyReceiver.class);
                intent.putExtra("key", "messageIWantToSend");
                PendingIntent sender=PendingIntent.getBroadcast(CourseDetail.this,MainActivity.numAlert++, intent, 0);
                AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,trigger, sender);
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