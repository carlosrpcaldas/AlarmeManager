package com.example.logonrm.alarmemanager

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import android.widget.Toast

/**
 * Created by logonrm on 17/02/2018.
 */
class MeuServico : Service() {
    lateinit var mp: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        if (intent?.extras !=null)
            Log.i("MEUSERVICO", intent?.getStringExtra("parametro1"))

        mp = MediaPlayer.create(this, R.raw.alarm_clock)
        mp.start()

        // Remover o Toast se tiver som no dispositivo
        Toast.makeText(this, "Alarm....", Toast.LENGTH_LONG).show()

        return START_REDELIVER_INTENT
    }

    override fun onBind(intent: Intent?): IBinder ? {
        return null
    }
}