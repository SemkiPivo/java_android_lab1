package com.example.lab1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView mainTextView;
    Button mainButton, okButton, cncButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mainArrayAdapter;
    ArrayList mainArrayList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_textview), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Main code

        mainTextView = findViewById(R.id.main_textview);
        mainButton = findViewById(R.id.main_button);
        okButton = findViewById(R.id.ok_btn);
        cncButton = findViewById(R.id.cnc_btn);
        mainEditText = findViewById(R.id.main_edittext);
        mainListView = findViewById(R.id.main_listview);

        mainArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, mainArrayList);
        mainListView.setAdapter(mainArrayAdapter);


        mainTextView.setText("Set in Java!");

        mainButton.setOnClickListener(this);
        mainListView.setOnItemClickListener(this);
        okButton.setOnClickListener(oclBtn);
        cncButton.setOnClickListener(oclBtn);
    }

    @Override
    public void onClick(View view) {
        mainTextView.setText(mainEditText.getText().toString() + " is learning Android development!");
        mainArrayList.add(mainEditText.getText().toString());
        mainArrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Log.d("omg android", position+": " + mainArrayList.get(position));
        mainTextView.setText(mainArrayList.get(position).toString()+" is learning Android development!");
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.ok_btn:
                    String text = "Нажата кнопка OK";
                    mainTextView.setText(text);
                    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
                    break;
                case R.id.cnc_btn:
                    String cnc_text = "Нажата кнопка Cancel";
                    mainTextView.setText(cnc_text);
                    Toast.makeText(getApplicationContext(), cnc_text, Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };
}