package com.example.projectakhirdicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectakhirdicoding.databinding.ActivityAllComicBinding
import com.example.projectakhirdicoding.databinding.ActivityMainBinding

class AllComic : AppCompatActivity() {
    private lateinit var binding: ActivityAllComicBinding
    private val list = ArrayList<Comic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllComicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvComic.setHasFixedSize(true)

        getListComic()
        showRecyclerComicList()

        binding.navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_satu -> {
                    val moveIntent = Intent(this, MainActivity::class.java)
                    startActivity(moveIntent)
                }
                else -> {
                    val moveIntent = Intent(this, About::class.java)
                    startActivity(moveIntent)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun getListComic() {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataType = resources.getStringArray(R.array.data_type)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataAuthor = resources.getStringArray(R.array.data_author)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        for (i in dataName.indices) {
            val comic = Comic(dataName[i], dataDescription[i], dataPhoto[i], dataType[i], dataAuthor[i], dataGenre[i])
            list.add(comic)
        }
    }
    private fun showRecyclerComicList() {
        binding.rvComic.layoutManager = LinearLayoutManager(this)
        val listComicAdapter = ListComicAdapter(list)
        binding.rvComic.adapter = listComicAdapter

        listComicAdapter.setOnItemClickCallback(object : ListComicAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Comic) {
                val moveIntent = Intent(this@AllComic, DetailComic::class.java)
                moveIntent.putExtra(DetailComic.EXTRA_NAME, sendDataSelectedComic(data).name)
                moveIntent.putExtra(DetailComic.EXTRA_DESC, sendDataSelectedComic(data).description)
                moveIntent.putExtra(DetailComic.EXTRA_PHOTO, sendDataSelectedComic(data).photo)
                moveIntent.putExtra(DetailComic.EXTRA_AUTHOR, sendDataSelectedComic(data).author)
                moveIntent.putExtra(DetailComic.EXTRA_GENRE, sendDataSelectedComic(data).genre)
                moveIntent.putExtra(DetailComic.EXTRA_TYPE, sendDataSelectedComic(data).type)
                startActivity(moveIntent)
            }
        })
    }
    private fun sendDataSelectedComic(comic: Comic): Comic {
        return comic
    }
}