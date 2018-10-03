package com.example.user.sync_media_player

import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : YouTubeBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupYoutubePlayer()
    }

    private fun setupYoutubePlayer() {
        youtube_player_view.initialize(BuildConfig.YOUTUBE_PLAYER_API_KEY, object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
                // Google I/O 2018
                p1?.loadVideo("Hzv5-R9XLTc")
                p1?.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
            }
        })
    }
}
