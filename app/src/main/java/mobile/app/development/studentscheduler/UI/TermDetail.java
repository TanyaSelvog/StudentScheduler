package mobile.app.development.studentscheduler.UI;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import mobile.app.development.studentscheduler.R;

public class TermDetail extends AppCompatActivity {
    EditText editTitle;
    EditText editStartDate;
    EditText editEndDate;
    String title;
    String startDate;
    String endDate;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_term_detail);
            editTitle=findViewById(R.id.editTitle);
            editStartDate=findViewById(R.id.editStartDate);
            editEndDate=findViewById(R.id.editEndDate);
            title=getIntent().getStringExtra("termName");
            startDate=getIntent().getStringExtra("startTermDate");
            endDate=getIntent().getStringExtra("endTermDate");
            editTitle.setText(title);
            editStartDate.setText(startDate);
            editEndDate.setText(endDate);




        }
}
