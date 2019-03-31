package com.mysoftsource.androi_youtube

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {
    private var youtubePlayer: YouTubePlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        setupPlayer()
    }

    override fun onDestroy() {
        youtube_player_view.release()
        super.onDestroy()
    }

    private fun setupPlayer() {
        youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youtubePlayer = youTubePlayer
                youTubePlayer.loadOrCueVideo(this@PlayerActivity.lifecycle, "gcj2RUWQZ60", 5 * 60f)
            }

            override fun onStateChange(
                youTubePlayer: YouTubePlayer,
                state: PlayerConstants.PlayerState
            ) {
            }

            override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) {
            }

            override fun onVideoDuration(youTubePlayer: YouTubePlayer, duration: Float) {
            }

            override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {
            }
        })
    }
}
