package es.ubu.seu.seut2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by rodrigo on 29/04/17.
 */

public class SecondActivity extends Activity {

    private final String LOG_MSG = "ACTIVITY_2";
    public static final String DATE_RESPONSE = "DATE_RESPONSE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_MSG, "Lanzada Activity 2");

        String data = obtainDate();

        Intent response = new Intent();
        response.putExtra(DATE_RESPONSE, data);
        setResult(Activity.RESULT_OK, response);
        finish();
    }

    private String obtainDate() {
        Calendar date = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd,MMMM,YYYY hh,mm,a", Locale.getDefault());

        return sdf.format(date.getTime());
    }
}
