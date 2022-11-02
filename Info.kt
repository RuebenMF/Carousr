package com.krullsoft.carousr

/**
 * This activity allows the user to view information about the developer and
 * also contains a link to donations to the Ko-Fi account.
 */

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_info.*

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val btnKofi: ImageButton = findViewById(R.id.btn_Kofi)
        val actionBar = supportActionBar

        txt_Thanks.setMovementMethod(ScrollingMovementMethod())

        btnKofi.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://ko-fi.com/carousr")
            startActivity(openURL)
        }

         actionBar!!.title = "Information"
         actionBar.setDisplayHomeAsUpEnabled(true)
        }

    }