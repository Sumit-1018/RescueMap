package com.example.rescuemap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper
import android.content.Intent

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set your splash screen layout
        setContentView(R.layout.activity_splash_screen)

        // Optional: Add a delay using Handler or Coroutine (simple way shown below)
        Handler(Looper.getMainLooper()).postDelayed({
            // Start your main activity after delay
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // close splash activity
        }, 500) // 2 seconds delay
    }
}
