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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import mobile.app.development.studentscheduler.DB.Repository;
import mobile.app.development.studentscheduler.Entity.Assessment;
import mobile.app.development.studentscheduler.Entity.Course;
import mobile.app.development.studentscheduler.R;

public class AssessmentDetail extends AppCompatActivity {
    EditText editTitle;
    EditText editEndDate;
    String title;
    String date;
    String testType;
    int assessmentID;
    Assessment currentAssessment;
    Repository repo;
    int courseID;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    SimpleDateFormat sdf;
    SimpleDateFormat endDateSDF;
    String test;
    String myFormat1;
    String startDateTest;
    EditText startDateTV;

    DatePickerDialog.OnDateSetListener sDate;
    final Calendar myCalendarStart = Calendar.getInstance();
    String myFormat;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_assessment_detail);
            editTitle = findViewById(R.id.tv8);
            title = getIntent().getStringExtra("assessmentName");
            editTitle.setText(title);
            assessmentID = getIntent().getIntExtra("assessmentID", -1);

            startDateTV= findViewById(R.id.startDateTV);
            startDateTest = getIntent().getStringExtra("assessmentStart");
            startDateTV.setText(startDateTest);

            myFormat = "MM/dd/yy";
            sdf = new SimpleDateFormat(myFormat, Locale.US);
            startDateTV.setOnClickListener(v -> {
                Date date;
                String info = startDateTV.getText().toString();
                if (info.equals("")) info = "02/10/22";
                try {
                    myCalendarStart.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(AssessmentDetail.this, sDate, myCalendarStart
                        .get(Calendar.YEAR), myCalendarStart.get(Calendar.MONTH),
                        myCalendarStart.get(Calendar.DAY_OF_MONTH)).show();
            });
            sDate = (datePicker, year, monthOfYear, dayOfMonth) -> {
                myCalendarStart.set(Calendar.YEAR, year);
                myCalendarStart.set(Calendar.MONTH, monthOfYear);
                myCalendarStart.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelStart();
            };

            editEndDate = findViewById(R.id.endDateTV);
            date = getIntent().getStringExtra("assessmentDate");
            editEndDate.setText(date);
            myFormat1 = "MM/dd/yy";
            sdf = new SimpleDateFormat(myFormat1, Locale.US);
            editEndDate.setOnClickListener(v -> {
                Date date;
                String info1 = editEndDate.getText().toString();
                if (info1.equals("")) info1 = "02/10/22";
                try {
                    myCalendarStart.setTime(sdf.parse(info1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(AssessmentDetail.this, sDate, myCalendarStart
                        .get(Calendar.YEAR), myCalendarStart.get(Calendar.MONTH),
                        myCalendarStart.get(Calendar.DAY_OF_MONTH)).show();
            });
            sDate = (datePicker, year, monthOfYear, dayOfMonth) -> {
                myCalendarStart.set(Calendar.YEAR, year);
                myCalendarStart.set(Calendar.MONTH, monthOfYear);
                myCalendarStart.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelStart();
            };

            courseID = getIntent().getIntExtra("courseID", courseID);
            repo = new Repository(getApplication());

            //      Info for assessment if already exists
            for (Assessment co : repo.getAllAssessments()) {
                if (co.getAssessmentID() == assessmentID) {
                    currentAssessment = co;
                    // Info for assessment if already exists
                    String typeRadio = getIntent().getStringExtra("assessmentType");
                    RadioGroup rb1 = (RadioGroup)findViewById(R.id.radio_group);
                    RadioButton rbu1 =(RadioButton)findViewById(R.id.obj_btn);
                    RadioButton rbu2 =(RadioButton)findViewById(R.id.perf_btn);
                        if(typeRadio.equalsIgnoreCase("Objective")) {
                            rbu1.setChecked(true);
                        }
                        else if(typeRadio.equalsIgnoreCase("Performance")){
                            rbu2.setChecked(true);
                        }
                }

            }


        }
    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        //String test;
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.obj_btn:
                if (checked)
                    test = "Objective";
                    break;
            case R.id.perf_btn:
                if (checked)
                    test = "Performance";
                    // Ninjas rule
                    break;
        }
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
            case R. id.saveAssessment:
                radioGroup = (RadioGroup) findViewById(R.id.radio_group);
                int radioID=radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(radioID);
                String radioTest=radioButton.getText().toString();
                Assessment assessment;

                if (assessmentID == -1) {
                 int newID = repo.getAllAssessments().size();
                //9.14.2022 test
                 //   int newID = repo.getAllAssessments().get(repo.getAllAssessments().size() - 1).getAssessmentID() + 1;
                    assessment = new Assessment(newID, editTitle.getText().toString(), radioTest, startDateTV.getText().toString(),
                            editEndDate.getText().toString(), courseID);
                    Toast.makeText(getApplicationContext(), test+ " "+ newID+ "  has been saved" , Toast.LENGTH_LONG).show();
                    repo.insert(assessment);
                // delete (pending further review) 9/7/2022
          //      }else {
            //        assessment = new Assessment(assessmentID, editTitle.getText().toString(), radioTest, editEndDate.getText().toString(), courseID);
              //      Toast.makeText(AssessmentDetail.this, assessment.getAssessmentName() + " was updated.", Toast.LENGTH_LONG).show();
                //    repo.update(assessment);
                }
               finish();
    //            Intent intent=new Intent(AssessmentDetail.this,CourseDetail.class);
      //          startActivity(intent);
                return true;

            case R.id.alertStart:
                String dateFromScreen = startDateTV.getText().toString();
                Date startDateAlert=null;
                try {
                    startDateAlert = sdf.parse(dateFromScreen);
                }catch (ParseException e){
                    e.printStackTrace();
                }
                Long trigger = startDateAlert.getTime();
                Intent intent = new Intent(AssessmentDetail.this, MyReceiver.class);
                intent.putExtra("key", "The assessment: " + title + " has a start date of: " + dateFromScreen);
                PendingIntent sender=PendingIntent.getBroadcast(AssessmentDetail.this,MainActivity.numAlert++, intent, 0);
                AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,trigger, sender);
                return true;
            case R.id.alertEnd:
                String dfs = editEndDate.getText().toString();
                Date endDateAlert=null;
                try {
                    endDateAlert= sdf.parse(dfs);
                }catch (ParseException e){
                    e.printStackTrace();
                }
                Long longTrigger = endDateAlert.getTime();
                Intent in = new Intent(AssessmentDetail.this, MyReceiver.class);
                in.putExtra("key", "The assessment: " + title + " has an end date of: " + dfs);
                PendingIntent senderI=PendingIntent.getBroadcast(AssessmentDetail.this,MainActivity.numAlert++, in, 0);
                AlarmManager aM=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
                aM.set(AlarmManager.RTC_WAKEUP,longTrigger, senderI);
                return true;


            case R.id.deleteAssessment:

                for (Assessment co : repo.getAllAssessments()) {
                    if (co.getAssessmentID() == assessmentID) {
                        currentAssessment = co;
                    }
                    repo.delete(currentAssessment);
                    Toast.makeText(AssessmentDetail.this, "Assessment was deleted", Toast.LENGTH_LONG).show();

                }
                Intent intent1=new Intent(AssessmentDetail.this,AssessmentList.class);
                startActivity(intent1);
                return true;

        }

        return super.onOptionsItemSelected(item);
        }

    public void saveButtonOnClick(View view) {
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        int radioID=radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(radioID);
        String radioTest=radioButton.getText().toString();
        Assessment assessment;

            if (assessmentID == -1) {
                int newID = repo.getAllAssessments().size();
                assessment = new Assessment(newID, editTitle.getText().toString(), radioTest, startDateTV.getText().toString(),
                        editEndDate.getText().toString(), courseID);
                Toast.makeText(getApplicationContext(), assessment.getAssessmentName()+ "  has been saved" , Toast.LENGTH_LONG).show();
                repo.insert(assessment);

            }else {
                assessment = new Assessment(assessmentID, editTitle.getText().toString(), radioTest, startDateTV.getText().toString(),
                        editEndDate.getText().toString(), courseID);
                Toast.makeText(AssessmentDetail.this, assessment.getAssessmentName() + " was updated.", Toast.LENGTH_LONG).show();
                repo.update(assessment);
            }
        Intent intent=new Intent(AssessmentDetail.this,AssessmentList.class);
        startActivity(intent);
        }

    private void updateLabelStart(){
        startDateTV.setText(sdf.format(myCalendarStart.getTime()));
    }
    }



