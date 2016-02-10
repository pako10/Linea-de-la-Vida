package com.example.pakoandrade.lineadevida;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView vida1;
    TextView vida2;
    TextView vida3;
    TextView vida4;
    TextView vida5;
    Runnable r;
    Thread iniReloj;
    LinearLayout ly;
    LinearLayout ly2;
    LinearLayout ly3;
    LinearLayout ly4;
    LinearLayout ly5;
    LinearLayout ly6;


    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        vida1 = (TextView) findViewById(R.id.textView2);
        vida2 = (TextView) findViewById(R.id.textView3);
        vida3 = (TextView) findViewById(R.id.textView4);
        vida4 = (TextView) findViewById(R.id.textView5);
        vida5 = (TextView) findViewById(R.id.textView6);

        ly = (LinearLayout) findViewById(R.id.linearLayout);
        ly2 = (LinearLayout) findViewById(R.id.linearLayout2);
        ly3 = (LinearLayout) findViewById(R.id.linearLayout3);
        ly4 = (LinearLayout) findViewById(R.id.linearLayout4);
        ly5 = (LinearLayout) findViewById(R.id.linearLayout5);



        runnable.run();

       /* setTime();
        r = new RefreshClock();
        iniReloj = new Thread(r);
        iniReloj.start();
          */

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

        public void setTime(){
            Time today = new Time(Time.getCurrentTimezone());
            today.setToNow();

            if(today.minute < 20) {
                vida1.setText(today.hour + ":" + today.minute + ":" + today.second + "");
                vida2.setText(today.hour + ":" + 20 + ":" + today.second + "");
                vida3.setText(today.hour + ":" + 40 + ":" + today.second + "");
                vida4.setText((today.hour + 1) + ":" + 0+0 + ":" + today.second + "");
                vida5.setText((today.hour +1) + ":" + 20 + ":" + today.second + "");
                return;
            }
            if(today.minute >= 20 && today.minute < 40){
                vida1.setText(today.hour + ":" + today.minute + ":" + today.second + "");
                vida2.setText(today.hour + ":" + 40 + ":" + today.second + "");
                vida3.setText((today.hour +1) + ":" + 0+0 + ":" + today.second + "");
                vida4.setText((today.hour + 1) + ":" + 20 + ":" + today.second + "");
                vida5.setText((today.hour + 1) + ":" + 40 + ":" + today.second + "");
                ly.setBackgroundColor(getResources().getColor(R.color.linea2));
                ly2.setBackgroundColor(getResources().getColor(R.color.linea3));
                ly3.setBackgroundColor(getResources().getColor(R.color.linea4));
                ly4.setBackgroundColor(getResources().getColor(R.color.linea5));
                ly5.setBackgroundColor(getResources().getColor(R.color.linea1));
                return;
            }
            if(today.minute >= 40 && today.minute < 60){
                vida1.setText(today.hour + ":" + today.minute + ":" + today.second + "");
                vida2.setText((today.hour + 1) + ":" + 0+0 + ":" + today.second + "");
                vida3.setText((today.hour +1) + ":" + 20 + ":" + today.second + "");
                vida4.setText((today.hour + 1) + ":" + 40 + ":" + today.second + "");
                vida5.setText((today.hour +2) + ":" + 0+0 + ":" + today.second + "");
                ly.setBackgroundColor(getResources().getColor(R.color.linea3));
                ly2.setBackgroundColor(getResources().getColor(R.color.linea4));
                ly3.setBackgroundColor(getResources().getColor(R.color.linea5));
                ly4.setBackgroundColor(getResources().getColor(R.color.linea1));
                ly5.setBackgroundColor(getResources().getColor(R.color.linea2));
                return;
            }
            return;
        }

    class RefreshClock implements Runnable{
        @SuppressWarnings("unused")
        @Override
        public void run(){
            while(Thread.currentThread().isInterrupted()){
                try{
                    setTime();
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }catch (Exception e){
                }
            }
        }

    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            setTime();
            handler.postDelayed(runnable, 1000);
        }
    };
}
