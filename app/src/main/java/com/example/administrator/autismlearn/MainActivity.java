package com.example.administrator.autismlearn;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mpBgm;
    ToggleButton tbBGM;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        mpBgm = MediaPlayer.create(MainActivity.this, R.raw.at_the_fair);
        mpBgm.setLooping(true);
        mpBgm.start();

        tbBGM = (ToggleButton) findViewById(R.id.tbBGM);
        tbBGM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean arg1) {
                if (arg1)
                    mpBgm.start();
                else
                    mpBgm.pause();
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (tbBGM.isChecked())
            mpBgm.start();


    }

    public void onPause() {
        super.onPause();
        mpBgm.pause();


    }

    public void onDestroy() {
        super.onDestroy();
        mpBgm.stop();
        mpBgm.release();
        mpBgm = null;


        ImageButton butColor =(ImageButton)findViewById(R.id.but_Color);
        butColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BlackActivity.class);
                startActivity(intent);
            }
        });

        ImageButton butAbout = (ImageButton) findViewById(R.id.but_about);
        butAbout.setOnClickListener(this);

}

    public void onClick(View v) {

        MediaPlayer buootnPlayer = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_shut);
        buootnPlayer.start();
        buootnPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        AlertDialog aDlg = new AlertDialog.Builder(this).create();
        aDlg.setTitle("วิธีใช้งาน");
        aDlg.setMessage("เลือกหมวดคำศัพท์ที่ต้องการ แตะที่รูปภาพจะมีเสียงคำศัพท์ให้ฝึกออกเสียง");
        aDlg.show();


    }

         @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}




