package com.example.bala.servicecallsbasics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    private ArrayList<BasicModel> basicModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Recycler View
        recyclerView = findViewById(R.id.rv_image);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        customAdapter = new CustomAdapter(basicModels);
        recyclerView.setAdapter(customAdapter);

        // Sever Call
        ServiceClass.makeRequest(this, "http://5bc9d0eb57adaa001375b1c6.mockapi.io/sampleget",new ServiceClass.CustomParse() {
            @Override
            public void doCustomParsing(String response) {
                try {
                    JSONArray jArr = new JSONArray(response);

                    for (int count = 0; count < jArr.length(); count++) {
                        JSONObject obj = jArr.getJSONObject(count);
                        basicModels.add(new BasicModel(obj.getString("name"), obj.getString("avatar")));
                    }
                    customAdapter.addItemsToList(basicModels);

                } catch (Exception e) {

                }
            }
        });
    }

    public void toNextActivity(View view) {
        startActivity(new Intent(this,ImageViewingActivity.class));
        finish();
    }
}
