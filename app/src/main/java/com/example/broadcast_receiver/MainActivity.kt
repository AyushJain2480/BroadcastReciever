package com.example.broadcast_receiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

/*         There are 2 types of BroadCastReciever which are static and dynamic receiver
           Static reciever are declared in the manifest and work even if your app is closed but since API level 26 most
           broadcast can only be caught by dynamic receiver which will only work if your app is active or minimised
           kyuki static vale background me boht battery kha jate the

            here we need to register our reciever
            system knows we want to receive broadcastEvent in case if airplane mode changes

            Useful to system to determine which app wants to recieve which intents
            we tell the system hey we want to respond to airplanemode changes

            registerReceiver()  pass BroadCastReciever and IntentFilter

            we declare this dynamic reciever here because we declare intentFilter directly in our code
   */


class MainActivity : AppCompatActivity() {

    lateinit var receiver : AirplaneModeChangeReceiver
    lateinit var receiver1 : BatteryReceiver
    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.battery_text)

        receiver = AirplaneModeChangeReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also{
            registerReceiver(receiver , it)
        }

        receiver1 = BatteryReceiver(textView)
        IntentFilter(Intent.ACTION_BATTERY_CHANGED).also {
            registerReceiver(receiver1,it)
        }
    }
    // to avoid memory leak
    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}