package com.example.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView

class BatteryReceiver(private val tv : TextView) : BroadcastReceiver(){

    private var textView : TextView = tv

    override fun onReceive(context: Context?, intent: Intent?) {

        val percentage = intent?.getIntExtra("level",0)
        if(percentage != 0)
        {
            textView.text = (percentage.toString()).plus("%")
        }
    }

}