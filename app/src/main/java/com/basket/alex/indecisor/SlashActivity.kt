package com.basket.alex.indecisor

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SlashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slash)
        val WAIT_SECONDS: Long = 2500

        Handler().postDelayed({
            startActivity(Intent(this, InteractionActivity::class.java))
            finish()
        }, WAIT_SECONDS)

    }
}
