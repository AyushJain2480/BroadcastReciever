package com.example.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/* when a broadcast(always send with an intent) is send by the system when the airplane mode
   changes than the system will look which app want to be notified about that change than
   the system will send intent to apps and these intent also contain information about that airplane
   mode is enabled or not */

class AirplaneModeChangeReceiver : BroadcastReceiver(){
    override fun onReceive(context : Context?, intent : Intent?) {

        /* choose default value in case extra doesn't exist...
           if this value is null ?: than it will return from there not even execute the below code
           if it is not null than AirPlaneMode will recieve the value from booleanExtra */

        val isAirplaneModeEnabled = intent?.getBooleanExtra("state",false) ?: return
        if(isAirplaneModeEnabled){ // if airplane mode is enabled than show toast
            Toast.makeText(context ,"Airplane mode enabled",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context ,"Airplane mode disabled",Toast.LENGTH_LONG).show()
        }
    }
}