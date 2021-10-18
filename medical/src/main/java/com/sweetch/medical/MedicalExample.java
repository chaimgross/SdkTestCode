package com.sweetch.medical;

import android.content.Context;
import android.content.Intent;
import android.os.Message;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.sweetch.sdktestmodule.Injection;
import com.sweetch.sdktestmodule.User;

public class MedicalExample {

    public static int count = 0;

    public static void UseCore(Context context) {
        User user = new User("","4");
        Intent intent = new Intent("ACTIVITY_DETECTED");
        intent.putExtra("activityType", Message.obtain(null, 4, count));
        intent.setComponent(null);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        count++;
    }
}
