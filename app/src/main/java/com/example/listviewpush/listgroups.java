// listgroups.java
package com.example.listviewpush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class listgroups extends AppCompatActivity {

    private ListView listViewGroups;
    private String[] groups = {"РПО241", "РПО242", "РПО243"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewGroups = findViewById(R.id.listViewGroups);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                groups
        );
        listViewGroups.setAdapter(adapter);

        listViewGroups.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(listgroups.this, liststudent.class);
                intent.putExtra("group_name", groups[position]);
                intent.putExtra("group_position", position);
                startActivity(intent);
            }
        });
    }
}