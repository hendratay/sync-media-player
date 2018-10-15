package com.example.user.sync_media_player

import android.util.Log
import io.socket.client.IO
import io.socket.client.Socket

object Socket {

    private val socket = IO.socket(BuildConfig.SOCKET_URL)

    fun connect() {
        socket.connect()
    }

    fun onConnect() {
        socket.on(Socket.EVENT_CONNECT) {
            Log.d("SOCKET", "CONNECTED")
        }
    }

    fun onDisconnect() {
        socket.on(Socket.EVENT_DISCONNECT) {
            Log.d("SOCKET", "DISCONNECT")
        }
    }

}