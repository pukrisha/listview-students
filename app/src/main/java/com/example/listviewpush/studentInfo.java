// studentInfo.java
package com.example.listviewpush;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class studentInfo extends AppCompatActivity {

    private ImageView photoImageView;
    private TextView fullNameTextView;
    private TextView groupTextView;
    private TextView averageGradeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        photoImageView = findViewById(R.id.photoImageView);
        fullNameTextView = findViewById(R.id.fullNameTextView);
        groupTextView = findViewById(R.id.groupTextView);
        averageGradeTextView = findViewById(R.id.averageGradeTextView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("student_name");
        double grade = intent.getDoubleExtra("student_grade", 0.0);
        int photo = intent.getIntExtra("student_photo", 0);
        String group = intent.getStringExtra("student_group");

        fullNameTextView.setText(name);
        groupTextView.setText("Группа: " + group);
        averageGradeTextView.setText("Средний балл: " + grade);
        photoImageView.setImageResource(photo);
    }
}