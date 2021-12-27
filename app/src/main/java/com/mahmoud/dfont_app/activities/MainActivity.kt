/*
 *
 * Created by mahmoud on 12/27/21, 11:33 PM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 12/22/21, 10:24 AM
 */

package com.mahmoud.dfont_app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.mahmoud.dfont.utils.DFontKeys.DFONT_TAG
import com.mahmoud.dfont_app.R
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

        val titleTypeface = binding.textTitle.typeface
        val latoTypeface = ResourcesCompat.getFont(this, R.font.lato)
        val montserratTypeface = ResourcesCompat.getFont(this, R.font.montserrat)

        val message = when (titleTypeface) {
            latoTypeface -> "onResume: title typeface is lato"
            montserratTypeface -> "onResume: title typeface is montserrate"
            else -> "onResume: title typeface is something"
        }

        Log.d(DFONT_TAG, message)
    }
}