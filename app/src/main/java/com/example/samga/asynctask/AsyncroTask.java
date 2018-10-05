package com.example.samga.asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AsyncroTask extends AsyncTask<String, Integer, String> {
    private ProgressBar pb_main_progressionAS;
    private Button bt_main_startAS;
    private View vi_main_ui;

    public AsyncroTask(View v, Button b, ProgressBar p) {
        vi_main_ui = v;
        bt_main_startAS = b;
        pb_main_progressionAS = p;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        bt_main_startAS.setVisibility(View.GONE);
        pb_main_progressionAS.setVisibility(View.VISIBLE);
        Toast.makeText(vi_main_ui.getContext(), "Démarrage de la tâche de fond AsyncTask", Toast.LENGTH_LONG).show();
    }

    @Override
    protected String doInBackground(String... params) {
        String uri = params[0];
        Log.i("Paramètre : ", params[0].toString());
        String result = "";
        for (int i = 1; i <= 20; ++i) {
            publishProgress(i * 5);
            result += String.valueOf(i);
            SystemClock.sleep(500);
        }
        return result;
    }
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
        pb_main_progressionAS.setProgress(progress[0]);
    }
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Toast.makeText(vi_main_ui.getContext(),
                "Fin de l’exécution de la tâche de fond AsyncTask" + result ,
                Toast.LENGTH_LONG).show();
        bt_main_startAS.setVisibility(View.VISIBLE);
        pb_main_progressionAS.setVisibility(View.GONE);
    }
}
