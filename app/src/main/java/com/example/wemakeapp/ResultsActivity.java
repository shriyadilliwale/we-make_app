package com.example.wemakeapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity {

    @BindView(R.id.results_list)
    ListView resultsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ButterKnife.bind(this);

        ArrayList<String> blocks = getIntent().getExtras().getStringArrayList("BLOCKS");
//        Toast.makeText(this, Arrays.toString(blocks.toArray()), Toast.LENGTH_LONG).show();

        List<com.example.wemakeapp.ResultItem> results = new ArrayList<>();
        for (String block: blocks) {
            results.add(new com.example.wemakeapp.ResultItem(block));
        }

        com.example.wemakeapp.ResultItemAdapter resultItemAdapter = new com.example.wemakeapp.ResultItemAdapter(getApplicationContext(),results);
        resultsListView.setAdapter(resultItemAdapter);
    }
}
