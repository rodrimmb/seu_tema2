package es.ubu.seu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.ubu.seu.services.MyService;
import es.ubu.seu.seut2.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String LOG_ACTIVITY = "MAIN_ACTIVITY";
    public final static String PETITION = "PETITION";
    private int numberOfPetition = 0;

    @BindView(R.id.btn_launch_service) Button btnLaunchService;
    @BindView(R.id.btn_stop_service) Button btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnLaunchService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_launch_service){
            makeServicePetition();
        }
        if(view.getId() == R.id.btn_stop_service){
            stopMyService();
        }
    }

    private void makeServicePetition() {
        numberOfPetition++;
        Intent intentService = new Intent(getApplicationContext(), MyService.class);
        intentService.putExtra(PETITION, numberOfPetition);
        startService(intentService);
    }

    private void stopMyService(){
        numberOfPetition = 0;
        Intent intentService = new Intent(getApplicationContext(), MyService.class);
        stopService(intentService);
        Log.i(LOG_ACTIVITY, "Servicio detenido");
    }
}
