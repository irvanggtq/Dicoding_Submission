package com.example.projectakhirdicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectakhirdicoding.databinding.ActivityMangaBinding

class Manga : AppCompatActivity() {
    private lateinit var binding: ActivityMangaBinding
    private val listManga = ArrayList<Comic>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMangaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvManga.setHasFixedSize(true)

        getListManga()
        showRecyclerMangaList()

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
    private fun getListManga() {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataType = resources.getStringArray(R.array.data_type)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataAuthor = resources.getStringArray(R.array.data_author)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        for (i in dataName.indices) {
            if(dataType[i].equals("Manga")){
                val manga = Comic(dataName[i], dataDescription[i], dataPhoto[i], dataType[i], dataAuthor[i], dataGenre[i])
                listManga.add(manga)
            }
        }
    }

    private fun showRecyclerMangaList() {
        binding.rvManga.layoutManager = LinearLayoutManager(this)
        val listComicAdapter = ListComicAdapter(listManga)
        binding.rvManga.adapter = listComicAdapter

        listComicAdapter.setOnItemClickCallback(object : ListComicAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Comic) {
                val moveIntent = Intent(this@Manga, DetailComic::class.java)
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