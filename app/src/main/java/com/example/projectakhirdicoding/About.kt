package com.example.projectakhirdicoding

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.projectakhirdicoding.databinding.ActivityAboutBinding


class About : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGithub.setOnClickListener(this)
        binding.buttonInstagram.setOnClickListener(this)

        binding.navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_satu -> {
                    val moveIntent = Intent(this, MainActivity::class.java)
                    startActivity(moveIntent)
                    true
                }
                else -> {
                    val moveIntent = Intent(this, About::class.java)
                    startActivity(moveIntent)
                    true
                }
            }
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.button_github -> {
                val uri = Uri.parse("https://github.com/irvanggtq")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            R.id.button_instagram -> {
                val uri = Uri.parse("https://www.instagram.com/irvanggtq/")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }
    }
}