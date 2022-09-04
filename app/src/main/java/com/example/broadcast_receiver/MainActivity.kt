package com.example.broadcast_receiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/* There are 2 types of BroadCastReciever which are static and dynamic receiver
   Static reciever are declared in the manifest and work even if your app is closed but since API level 26 most
   broadcast can only be caught by dynamic receiver which will only work if your app is active or minimised
   */


class MainActivity : AppCompatActivity() {

    lateinit var receiver : AirplaneModeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = AirplaneModeChangeReceiver()

        /*  here we need to register our reciever
            system knows we want to receive broadcastEvent in case if airplane mode changes

            Useful to system to determine which app wants to recieve which intents
            we tell the system hey we want to respond to airplanemode changes */


        // we declare this dynamic reciever here because we declare intentFilter directly in our code
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also{
            // pass BroadCastReciever and IntentFilter
            // instance of an AirplaneModeChangeReciever
            registerReceiver(receiver , it)
        }
    }

    // to avoid memory leak
    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}