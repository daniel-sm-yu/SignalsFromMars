package com.dsyu.signalsfrommars.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dsyu.signalsfrommars.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameField;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.nameEditText);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                startStory(name);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameField.setText("");
    }

    // This function navigates to the second activity and is called in the OnClickListener above
    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name); // key_name comes from strings.xml
        intent.putExtra(key, name); // adds the name variable to be passed to StoryActivity.java
        startActivity(intent);
    }
}
