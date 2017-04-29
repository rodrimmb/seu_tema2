package es.ubu.seu.seut2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by rodrigo on 29/04/17.
 */

public class FirstActivity extends Activity {

    private final String LOG_MSG = "ACTIVITY_1";
    private final int RQST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_MSG, "Lanzada Activity 1");
        launchActivityForResoult();
    }

    private void launchActivityForResoult() {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivityForResult(intent, RQST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(LOG_MSG, "Entramos en el método onActivityResult de FirstActivity");
        if (resultCode == Activity.RESULT_OK && requestCode == RQST_CODE) {
            String strResponse = data.getStringExtra(SecondActivity.DATE_RESPONSE);
            Log.i("FECHA", strResponse);
        }
    }
}
