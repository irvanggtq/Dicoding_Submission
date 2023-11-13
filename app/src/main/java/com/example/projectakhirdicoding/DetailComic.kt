package com.example.projectakhirdicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.projectakhirdicoding.databinding.ActivityDetailComicBinding

class DetailComic : AppCompatActivity() {
    private lateinit var binding:ActivityDetailComicBinding
    companion object {
        const val EXTRA_NAME = "extra_age"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_AUTHOR = "extra_author"
        const val EXTRA_GENRE = "extra_genre"
        const val EXTRA_TYPE = "extra_TYPE"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailComicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val desc = intent.getStringExtra(EXTRA_DESC)
        val photo = intent.getStringExtra(EXTRA_PHOTO)
        val author = intent.getStringExtra(EXTRA_AUTHOR)
        val genre = intent.getStringExtra(EXTRA_GENRE)
        val type = intent.getStringExtra(EXTRA_TYPE)

        binding.tvItemName.text = name
        binding.tvItemDescription.text = desc
        binding.tvItemAuthor.text = author
        binding.tvItemGenre.text = genre
        binding.tvItemType.text = type
        Glide.with(this).load(photo).into(binding.imgItemPhoto)

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
}