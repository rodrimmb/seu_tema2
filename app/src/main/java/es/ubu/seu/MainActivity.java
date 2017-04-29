package es.ubu.seu;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by rodrigo on 29/04/17.
 */

public class MainActivity extends Activity {

    private final int PICK_CONTACT_REQUEST = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pickContact();
    }

    private void pickContact(){
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, PICK_CONTACT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_CONTACT_REQUEST) {
            Cursor cursor = getContentResolver()
                    .query(
                        data.getData(),
                        new String[] {ContactsContract.Contacts.DISPLAY_NAME},
                        null,
                        null,
                        null
                    );
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                Log.i("DATOS_CONTACTO", cursor.getString(columnIndex));
            }
        }
    }

}
