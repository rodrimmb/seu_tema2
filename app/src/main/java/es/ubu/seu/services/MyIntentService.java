package es.ubu.seu.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import es.ubu.seu.MainActivity;
import es.ubu.seu.seut2.R;

public class MyIntentService extends IntentService {

    private static final String LOG_SERVICE = "MY_SERVICE";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            int numberOfPetition = bundle.getInt(MainActivity.PETITION);
            //Para mostrar el toast necesitamos acceder al hilo principal
            showToastOnMainThread(numberOfPetition);
            SystemClock.sleep(4000);
            Log.i(LOG_SERVICE, "Han pasado 4 segundos.");
        }
    }

    private void showToastOnMainThread(final int numberOfPetition){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.i(LOG_SERVICE, "Peticion "+numberOfPetition);
                String textOfPetition = getString(R.string.toast_petition);
                Toast.makeText(getApplicationContext(),
                        textOfPetition+" "+numberOfPetition,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
