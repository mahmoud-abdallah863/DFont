package com.mahmoud.dfont_app.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mahmoud.dfont.extensions.notifyTypefaceChanged
import com.mahmoud.dfont.services.DFontSharedPreferences
import com.mahmoud.dfont_app.R
import com.mahmoud.dfont_app.databinding.ActivityChangeFontBinding


class ChangeFontActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangeFontBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangeFontBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLatoFont.setOnClickListener {
            DFontSharedPreferences.saveFont(R.font.lato)
            binding.root.notifyTypefaceChanged()
        }

        binding.buttonMontserrateFont.setOnClickListener {
            DFontSharedPreferences.saveFont(R.font.montserrat)
            binding.root.notifyTypefaceChanged()
        }
    }
}