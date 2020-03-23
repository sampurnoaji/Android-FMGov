package iot.android.fm.ui;

import android.content.Context;
import android.content.SharedPreferences;

import iot.android.fm.R;
import iot.android.fm.data.entity.UserProperties;

public class SharedPreferenceUtil {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public static final String IS_LOGIN = "IS_LOGIN";

    public static final String KEY_MEMBERCODE = "KEY_MEMBERCODE";
    public static final String KEY_ISADMIN = "KEY_ISADMIN";
    public static final String KEY_LEVELID = "KEY_LEVELID";
    public static final String KEY_DEPARTMENTID = "KEY_DEPARTMENTID";
    public static final String KEY_DESCRIPTION = "KEY_DESCRIPTION";
    public static final String KEY_USERID = "KEY_USERID";
    public static final String KEY_MEMBERNAME = "KEY_MEMBERNAME";
    public static final String KEY_EMAIL = "KEY_EMAIL";
    public static final String KEY_IMAGEADDRESS = "KEY_IMAGEADDRESS";
    public static final String KEY_USERNAME = "KEY_USERNAME";
    public static final String KEY_MEMBERID = "KEY_MEMBERID";

    public SharedPreferenceUtil(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void loginUser() {
        editor.putBoolean(IS_LOGIN, true);
        editor.apply();
    }

    public void logoutUser() {
        editor.clear();
        editor.apply();
    }

    public void registerUser(UserProperties user) {
        editor.putString(KEY_MEMBERCODE, user.getMembercode());
        editor.putBoolean(KEY_ISADMIN, user.getIsadmin());
        editor.putString(KEY_LEVELID, user.getLevelid());
        editor.putString(KEY_DEPARTMENTID, user.getDepartmentid());
        editor.putString(KEY_DESCRIPTION, user.getDescription());
        editor.putString(KEY_USERID, user.getUserid());
        editor.putString(KEY_MEMBERNAME, user.getMembername());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_IMAGEADDRESS, user.getImageaddress());
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putString(KEY_MEMBERID, user.getMemberid());
    }

    public boolean readLoginStatus() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }
}
