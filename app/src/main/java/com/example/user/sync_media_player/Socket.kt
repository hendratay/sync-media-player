package com.example.user.sync_media_player

import android.util.Log
import io.socket.client.IO
import io.socket.client.Socket

object Socket {

    private const val TAG = "Socket"
    private val socket = IO.socket(BuildConfig.SOCKET_URL)

    //region Listener
    //--------------------------------------------------------------------------------
    fun onConnect() {
        socket.on(Socket.EVENT_CONNECT) { _ -> Log.d(TAG, "Connected") }
    }

    fun onDisconnect() {
        socket.on(Socket.EVENT_DISCONNECT) { _ -> Log.d(TAG, "Disconnected") }
    }

    fun onPlay(listener: (String) -> Unit) {
        socket.on("play") { param -> listener(param[0].toString()) }
    }

    fun onPause(listener: (String) -> Unit) {
        socket.on("pause") { param -> listener(param[0].toString()) }
    }

    fun onStop(listener: (String) -> Unit) {
        socket.on("stop") { param -> listener(param[0].toString()) }
    }

    fun onRewind(listener: (String) -> Unit) {
        socket.on("rewind") { param -> listener(param[0].toString()) }
    }

    fun onFastForward(listener: (String) -> Unit) {
        socket.on("fast_forward") { param -> listener(param[0].toString()) }
    }
    //--------------------------------------------------------------------------------
    //endregion

    //region Emitter
    //--------------------------------------------------------------------------------
    fun connect() {
        socket.connect()
    }

    fun play() {
        socket.emit("play")
    }

    fun pause() {
        socket.emit("pause")
    }

    fun stop() {
        socket.emit("stop")
    }

    fun rewind() {
        socket.emit("rewind")
    }

    fun fastForward() {
        socket.emit("fast_forward")
    }
    //--------------------------------------------------------------------------------
    //endregion

}