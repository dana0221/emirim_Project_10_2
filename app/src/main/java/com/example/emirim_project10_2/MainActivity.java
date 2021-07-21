package com.example.emirim_project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
// Change ViewFlipper


public class MainActivity extends AppCompatActivity {
    String[] imgNames = {"BTS1", "BTS2", "JIN", "SUGA", "J-HOPE", "RM", "JIMIN", "V", "JUNGKOOK"};
    int[] imgId = {R.id.img01, R.id.img02, R.id.img03, R.id.img04, R.id.img05, R.id.img06, R.id.img07, R.id.img08, R.id.img09};
    int[] voteCount = new int[imgId.length];
    ImageView[] image = new ImageView[imgId.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.title);

        for(int i=0 ; i<imgId.length ; i++){
            final int index;
            index = i;
            image[index] = findViewById(imgId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
//                    Log.v("^^^", imgNames[index] + "총" + voteCount[index] + "표");
                    voteCount[index]++;

                    Toast.makeText(getApplicationContext(),imgNames[index]+"총 " + voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("voteCount", voteCount);
            intent.putExtra("imgNames", imgNames);
            startActivity(intent);
        }
    };
}