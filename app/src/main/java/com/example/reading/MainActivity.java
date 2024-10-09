package com.example.reading;

import static com.example.reading.FileReadWrite.write2File;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvSelected;
    RecyclerView recyclerView;
    MyViewAdapter adapter;
    ArrayList<Person> artists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views and set the adapter
        initViews();

        // Initialize the adapter with an empty list
        artists = new ArrayList<>();
        adapter = new MyViewAdapter(this, artists);

        // Set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    // Initialize views method
    private void initViews() {
        tvSelected = findViewById(R.id.tvSelected);
        recyclerView = findViewById(R.id.list);

        findViewById(R.id.btnReadRsc).setOnClickListener(this::initialize);
        findViewById(R.id.btnWriteFile).setOnClickListener(this::writeFile);
        findViewById(R.id.btnReadFile).setOnClickListener(this::readFile);
      //  findViewById(R.id.btnWriteJson).setOnClickListener(this::writeJson);
     //   findViewById(R.id.btnReadJson).setOnClickListener(this::readJson);//
    }

    // Initialize the list from resources
    public void initialize(View v) {
        FileReadWrite.readFileFromResources(artists, this);
        adapter.notifyDataSetChanged();  // Notify the adapter of the data change
    }

//    // Read data from a file
    public void readFile(View v) {
        FileReadWrite.readFile(artists, this);
        adapter.notifyDataSetChanged();  // Notify the adapter of the data change
    }

    // Write data to a file
    public void writeFile(View v) {
        FileReadWrite.writeFile(artists, this);
    }

    // Write data to a JSON file
//    public void writeJson(View v) {
//        JsonReadWrite<Person> jsonReadWrite = new JsonReadWrite<>();
//        if (!jsonReadWrite.writeJsonArrayList(artists, "artists.json", this)) {
//            Toast.makeText(this, "Failed Writing JSON", Toast.LENGTH_LONG).show();
//        }
//    }

    // Read data from a JSON file
//    public void readJson(View v) {
//        JsonReadWrite<Person> jsonReadWrite = new JsonReadWrite<>();
//        ArrayList<Person> artists2 = jsonReadWrite.readJsonArrayList("artists.json", this, Person.class);
//        if (artists2 != null) {
//            artists.clear();
//            artists.addAll(artists2);  // Update the list with the new data
//            adapter.notifyDataSetChanged();  // Notify the adapter of the data change
//        } else {
//            Toast.makeText(this, "Failed reading JSON", Toast.LENGTH_LONG).show();
//        }
//    }
}

