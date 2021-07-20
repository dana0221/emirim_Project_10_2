package com.example.emirim_project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.LogManager;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] imgNames = intent.getStringArrayExtra("imgNames");

        int max = 0;
        int index = 0;

        for(int i=0 ; i<voteCount.length ; i++){
            if(voteCount[i] > max){
                max = voteCount[i];
                index = i;
            }
        }

        TextView[] tv = new TextView[imgNames.length];
        RatingBar[] rb = new RatingBar[imgNames.length];

        int[] tvIds = {R.id.text1, R.id.text2, R.id.text3, R.id.text4, R.id.text5, R.id.text6, R.id.text7, R.id.text8, R.id.text9};
        int[] rbIds = {R.id.rating1, R.id.rating2, R.id.rating3, R.id.rating4, R.id.rating5, R.id.rating6, R.id.rating7, R.id.rating8, R.id.rating9};
        int[] imgScrIds = {R.drawable.bts1, R.drawable.bts2, R.drawable.jin, R.drawable.suga, R.drawable.jh, R.drawable.rm, R.drawable.jm, R.drawable.v, R.drawable.jk};

        for(int i=0 ; i<tv.length ; i++){
            tv[i] = findViewById(tvIds[i]);
            rb[i] = findViewById(rbIds[i]);

            tv[i].setText(imgNames[i]);
            rb[i].setRating(voteCount[i]);
        }

        TextView textTitle = findViewById(R.id.text_title);
        ImageView imgV = findViewById(R.id.imgv);
        textTitle.setText(imgNames[index]);
        imgV.setImageResource(imgScrIds[index]);

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}