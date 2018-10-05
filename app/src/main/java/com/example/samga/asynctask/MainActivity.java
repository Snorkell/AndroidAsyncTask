package com.example.samga.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pb_main_progressionTh;
    private Button bt_main_startTh;
    private TextView tv_main_texte;
    private ThreadTest monThread;
    private Button bt_main_startAS;
    private ProgressBar pb_main_progressionAS;
    private ProgressBar pb_main_progressionTrHa1;
    private ProgressBar pb_main_progressionTrHa2;
    private Button bt_main_startTrHa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb_main_progressionTh = (ProgressBar)findViewById(R.id.pb_main_progressionTH);
        bt_main_startTh = (Button) findViewById(R.id.bt_main_startTh);
        tv_main_texte = (TextView)findViewById(R.id.tv_main_text);
        bt_main_startAS = (Button)findViewById(R.id.bt_main_startAS);
        pb_main_progressionAS = (ProgressBar)findViewById(R.id.pb_main_progressionAS);
        pb_main_progressionTrHa1 = (ProgressBar)findViewById(R.id.pb_main_progressionTrHa1);
        pb_main_progressionTrHa2 = (ProgressBar)findViewById(R.id.pb_main_progressionTrHa2);
        bt_main_startTrHa = (Button)findViewById(R.id.bt_main_startTrHa);
    }

    public void onMainClickManager(View v){
        switch(v.getId()){
            case R.id.bt_main_txtchange:
                if(tv_main_texte.getText().equals("Hello World"))tv_main_texte.setText("Hey Android !");
                else tv_main_texte.setText("Hello World");
                break;
            case R.id.bt_main_startTh:
                if(bt_main_startTh.getText().equals("Thread Go")){
                    monThread = new ThreadTest(pb_main_progressionTh);
                    monThread.Go();
                    bt_main_startTh.setText("Thread STOP");
                    Toast.makeText(this, "Activation du thread", Toast.LENGTH_SHORT).show();
                }else{
                    monThread.Stop();
                    Toast.makeText(this, "Desactivation du Thread", Toast.LENGTH_SHORT).show();
                    bt_main_startTh.setText("Thread GO");
                }
                break;
            case R.id.bt_main_startAS :
                AsyncroTask asyncrotask = new AsyncroTask(v, bt_main_startAS, pb_main_progressionAS);
                asyncrotask.execute("paramètre(s) de traitement");
                break;
            case R.id.bt_main_startTrHa:
                BackgroundTask backgroundtask1 = new BackgroundTask(v,bt_main_startTrHa,pb_main_progressionTrHa1);
                backgroundtask1.Start();
                BackgroundTask backgroundtask2 = new BackgroundTask(v,bt_main_startTrHa,pb_main_progressionTrHa2);
                backgroundtask1.Start();
        }
    }
}
