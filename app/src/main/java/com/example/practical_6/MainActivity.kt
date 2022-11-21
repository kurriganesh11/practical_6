package com.example.practical_6

import android.content.Intent
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import android.net.Uri
import android.os.Bundle
import androidx.core.view.WindowCompat
import com.example.practical_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window,false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        initvideoPlayer()
        binding.btnSwitch.setOnClickListener {
            Intent(this,YoutubeActivity::class.java).also{
                startActivity(it)
            }
        }
    }
    private fun initvideoPlayer() {
        val mediaController = MediaController(this)
        val uri = Uri.parse("android.resourse://" + packageName + "/" + R.raw.thestoryoflight)
        binding.myvideoview.setMediaController(mediaController)
        mediaController.setAnchorView(binding.myvideoview)
        binding.myvideoview.setVideoURI(uri)
        binding.myvideoview.requestFocus()
        binding.myvideoview.start()
    }

}