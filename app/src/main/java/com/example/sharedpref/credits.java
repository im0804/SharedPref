package com.example.sharedpref;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class credits extends AppCompatActivity {
    TextView tvCredits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        tvCredits = (TextView) findViewById(R.id.tvCredits);
        tvCredits.setText("thanks to albert and my parents i'm here today."+'\n'+'\n'+"to go back press on the 3 dots." + '\n'+ "thank you albert for helping me :)");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainAct){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}