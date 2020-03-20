package iot.android.fm.ui;

import android.content.Context;
import android.content.SharedPreferences;

import iot.android.fm.R;

public class SharedPreference {
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPreference(Context context) {
        this.context = context;
        sharedPreferences = (SharedPreferences) context.getSharedPreferences(context.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference), status);
        editor.commit();
    }

    public boolean readLoginStatus() {

        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference), false);
        return status;
    }
}
