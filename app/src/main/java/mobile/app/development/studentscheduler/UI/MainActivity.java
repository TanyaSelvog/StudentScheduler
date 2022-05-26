package mobile.app.development.studentscheduler.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
}