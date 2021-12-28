/*
 *
 * Created by mahmoud on 12/27/21, 11:33 PM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 12/22/21, 10:24 AM
 */

package com.mahmoud.dfont_app.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mahmoud.dfont.extensions.notifyTypefaceChanged
import com.mahmoud.dfont_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonChangeFontActivity.setOnClickListener {
            val intent = Intent(this, ChangeFontActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.root.notifyTypefaceChanged()
    }
}