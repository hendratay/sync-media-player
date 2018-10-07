package com.example.user.sync_media_player

import android.net.Uri
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class MainActivity : YouTubeBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupYoutubePlayer()
        setupExoPlayer()
    }

    private fun setupYoutubePlayer() {
/*        youtube_player_view.initialize(BuildConfig.YOUTUBE_PLAYER_API_KEY, object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
                // Google I/O 2018
                p1?.loadVideo("Hzv5-R9XLTc")
                p1?.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
            }
        })*/
    }

    private fun setupExoPlayer() {
        val player = ExoPlayerFactory.newSimpleInstance(this)
        exo_player_view.player = player
        val dataSourceFactory = DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "sync-media-player"))
        val googleIO = Uri.parse("https://www.youtube.com/watch?v=Hzv5-R9XLTc")
        val videoSource = ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(googleIO)
        player.prepare(videoSource)
    }

}
