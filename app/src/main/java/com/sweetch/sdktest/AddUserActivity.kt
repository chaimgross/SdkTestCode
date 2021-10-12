package com.sweetch.sdktest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.sweetch.medical.MedicalExample


class AddUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        setSupportActionBar(findViewById(R.id.toolbar))
        LocalBroadcastManager.getInstance(this).registerReceiver(
            mMessageReceiver,
            IntentFilter("ACTIVITY_DETECTED")
        );
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

            test()
        }
    }

    private val mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            // Get extra data included in the Intent
            val message = intent.getParcelableExtra<Message>("activityType")
            Snackbar.make(findViewById<FloatingActionButton>(R.id.fab), "Check ${message?.obj}", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun test() {
        MedicalExample.UseCore(this)
    }
}