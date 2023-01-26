package com.example.sharedpref;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * saves information in a shared preference file
 * @author Inbar Menahem
 * @version 1.0
 * @since 24/1/23
 */
public class MainActivity extends AppCompatActivity {
    TextView tvCount;
    EditText etName;
    Intent si;
    int counter;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        tvCount = (TextView) findViewById(R.id.tvCount);

        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        counter = settings.getInt("Count", 0);
        name = settings.getString("Name", "");
        etName.setText(name);
        tvCount.setText("" + counter);
    }

    /**
     * Count.
     * adds one to the counter and shows it on the text view.
     *
     * @param view the view
     */
    public void count(View view) {
        counter += 1;
        tvCount.setText("" + counter);
    }

    /**
     * Reset.
     * resets the counter and updates in on the text view.
     *
     * @param view the view
     */
    public void reset(View view) {
        counter = 0;
        tvCount.setText("" + counter);
    }

    /**
     * Exit.
     * closes the app.
     *
     * @param view the view
     */
    public void exit(View view) {
        finish();
    }

    @Override
    protected void onResume() {
        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        counter = settings.getInt("Count", 0);
        name = settings.getString("Name", "");
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings = getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        name = etName.getText().toString();
        editor.putString("Name", name);
        editor.putInt("Count", counter);
        editor.commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.credits) {
            si = new Intent(this, credits.class);
            startActivity(si);
        }
        return super.onOptionsItemSelected(item);
    }
}