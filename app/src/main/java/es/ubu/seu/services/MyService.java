package es.ubu.seu.services;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import es.ubu.seu.MainActivity;
import es.ubu.seu.seut2.R;

/**
 * Created by rodrigo on 02/05/17.
 */

public class MyService extends Service {

    private static final String LOG_SERVICE = "MY_SERVICE";
    private static final int MYTHREADS = 2;
    ExecutorService executor;

    @Override
    public void onCreate() {
        executor = Executors.newFixedThreadPool(MYTHREADS);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        int numberOfPetition = bundle.getInt(MainActivity.PETITION);
        Log.i(LOG_SERVICE, "El servicio recibe la llamada "+numberOfPetition);

        executor.execute(new MakeWork(numberOfPetition));

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        executor.shutdown();
        Log.i(LOG_SERVICE, "Servicio destruido");
    }

    private void showToastOnMainThread(final int numberOfPetition){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.i(LOG_SERVICE, "Hilo "+numberOfPetition);
                String textOfPetition = getString(R.string.toast_petition_service);
                Toast.makeText(getApplicationContext(),
                        textOfPetition+" "+numberOfPetition,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MakeWork implements Runnable {

        private int petitionNumber;

        public MakeWork(int petitionNumber){
            this.petitionNumber = petitionNumber;
        }

        @Override
        public void run() {
            try {
                Log.i(LOG_SERVICE, "Creada tarea para ejecutar peticion "+petitionNumber+" en el hilo "+Thread.currentThread().toString());
                showToastOnMainThread(petitionNumber);
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
