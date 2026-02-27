// liststudent.java
package com.example.listviewpush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class liststudent extends AppCompatActivity {

    private ListView listViewStudents;
    private ArrayList<student> studentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liststudent);

        listViewStudents = findViewById(R.id.listViewStudents);

        Intent intent = getIntent();
        String groupName = intent.getStringExtra("group_name");
        int groupPosition = intent.getIntExtra("group_position", 0);

        setTitle("Группа " + groupName);

        studentsList = getStudentsByGroup(groupPosition);

        ArrayAdapter<student> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                studentsList
        );
        listViewStudents.setAdapter(adapter);

        listViewStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent studentIntent = new Intent(liststudent.this, studentInfo.class);
                student student = studentsList.get(position);

                studentIntent.putExtra("student_name", student.getFullName());
                studentIntent.putExtra("student_grade", student.getGrade());
                studentIntent.putExtra("student_photo", student.getPhoto());
                studentIntent.putExtra("student_group", student.getGroup());

                startActivity(studentIntent);
            }
        });
    }

    private ArrayList<student> getStudentsByGroup(int groupPosition) {
        ArrayList<student> students = new ArrayList<>();

        switch (groupPosition) {
            case 0: // РПО241
                students.add(new student("Иванов Илья", 4.8, R.drawable.firstphoto, "РПО241"));
                students.add(new student("Петров Петр", 4.2, R.drawable.firstphoto, "РПО241"));
                students.add(new student("Сидорова Анна", 4.9, R.drawable.second, "РПО241"));
                students.add(new student("Козлов Дмитрий", 4.3, R.drawable.firstphoto, "РПО241"));
                students.add(new student("Морозова Ольга", 4.6, R.drawable.second, "РПО241"));
                break;

            case 1: // РПО242
                students.add(new student("Петрова Ксения", 4.5, R.drawable.second, "РПО242"));
                students.add(new student("Смирнов Алексей", 4.3, R.drawable.firstphoto, "РПО242"));
                students.add(new student("Козлова Мария", 4.7, R.drawable.second, "РПО242"));
                students.add(new student("Васильев Игорь", 4.1, R.drawable.firstphoto, "РПО242"));
                students.add(new student("Новикова Анна", 4.8, R.drawable.second, "РПО242"));
                break;

            case 2: // РПО243
                students.add(new student("Сираева Алия", 4.9, R.drawable.second, "РПО243"));
                students.add(new student("Васильев Дмитрий", 4.1, R.drawable.firstphoto, "РПО243"));
                students.add(new student("Николаева Елена", 4.6, R.drawable.second, "РПО243"));
                students.add(new student("Морозов Антон", 4.4, R.drawable.firstphoto, "РПО243"));
                students.add(new student("Соколова Ирина", 4.7, R.drawable.second, "РПО243"));
                break;
        }
        return students;
    }
}