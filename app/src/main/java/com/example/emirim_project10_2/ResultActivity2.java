package com.example.emirim_project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.Arrays;
import java.util.Collections;

public class ResultActivity2 extends AppCompatActivity {
    int[] imgId = {R.id.img01, R.id.img02, R.id.img03, R.id.img04, R.id.img05, R.id.img06, R.id.img07, R.id.img08, R.id.img09};
    ImageView[] imgv = new ImageView[imgId.length];
    ViewFlipper viewFlip;
    int[] imgScrIds = {R.drawable.bts1, R.drawable.bts2, R.drawable.jin, R.drawable.suga, R.drawable.jh, R.drawable.rm, R.drawable.jm, R.drawable.v, R.drawable.jk};
    int[] voteCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);

        Intent intent = getIntent();
        voteCount = intent.getIntArrayExtra("voteCount");

        viewFlip = findViewById(R.id.view_flip);
        viewFlip.setFlipInterval(1000);

        sortDescImgSrc();

        for(int i=0 ; i<imgv.length ; i++){
            imgv[i] = findViewById(imgId[i]);
            imgv[i].setImageResource(imgScrIds[i]);
        }

        Button btnStart = findViewById(R.id.btn_start);
        Button btnStop = findViewById(R.id.btn_stop);

        btnStart.setOnClickListener(btnListener);
        btnStop.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_start:
                    viewFlip.startFlipping();
                    break;
                case R.id.btn_stop:
                    viewFlip.stopFlipping();
                    break;
            }
        }
    };

    protected void sortDescImgSrc(){
        for(int i=0 ; i<voteCount.length ; i++){
            for(int j=i+1 ; j<voteCount.length ; j++){
                if(voteCount[i] < voteCount[j]){
                    int tmpv = voteCount[i];
                    int tmps = imgScrIds[i];
                    voteCount[i] = voteCount[j];
                    imgScrIds[i] = imgScrIds[j];
                    voteCount[j] = tmpv;
                    imgScrIds[j] = tmps;
                }
            }
        }

        for(int i=0 ; i<voteCount.length ; i++){
            Log.i("Sorting 결과 : ", voteCount[i] + "");
        }
    }
}