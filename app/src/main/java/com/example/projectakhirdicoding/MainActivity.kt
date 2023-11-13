package com.example.projectakhirdicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectakhirdicoding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Comic>()
    private val listManhwa = ArrayList<Comic>()
    private val listManhua = ArrayList<Comic>()
    private val listManga = ArrayList<Comic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvComic.setHasFixedSize(true)
        binding.rvManhwa.setHasFixedSize(true)
        binding.rvManhua.setHasFixedSize(true)
        binding.rvManga.setHasFixedSize(true)

        binding.tvComic.setOnClickListener(this)
        binding.tvManhwa.setOnClickListener(this)
        binding.tvManhua.setOnClickListener(this)
        binding.tvManga.setOnClickListener(this)

        binding.navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_satu -> {
                    val moveIntent = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(moveIntent)
                }
                else -> {
                    val moveIntent = Intent(this@MainActivity, About::class.java)
                    startActivity(moveIntent)
                }
            }
            return@setOnItemSelectedListener true
        }

        getListComic()
        showRecyclerComicList()
        showRecyclerManhwaList()
        showRecyclerManhuaList()
        showRecyclerMangaList()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.tv_comic -> {
                val moveIntent = Intent(this@MainActivity, AllComic::class.java)
                startActivity(moveIntent)
            }
            R.id.tv_manhwa -> {
                val moveIntent = Intent(this@MainActivity, Manhwa::class.java)
                startActivity(moveIntent)
            }
            R.id.tv_manhua -> {
                val moveIntent = Intent(this@MainActivity, Manhua::class.java)
                startActivity(moveIntent)
            }
            R.id.tv_manga -> {
                val moveIntent = Intent(this@MainActivity, Manga::class.java)
                startActivity(moveIntent)
            }
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
            if(dataType[i].equals("Manhwa")){
                val manhwa = Comic(dataName[i], dataDescription[i], dataPhoto[i], dataType[i], dataAuthor[i], dataGenre[i])
                listManhwa.add(manhwa)
            }else if (dataType[i].equals("Manhua")){
                val manhua = Comic(dataName[i], dataDescription[i], dataPhoto[i], dataType[i], dataAuthor[i], dataGenre[i])
                listManhua.add(manhua)
            }else{
                val manga = Comic(dataName[i], dataDescription[i], dataPhoto[i], dataType[i], dataAuthor[i], dataGenre[i])
                listManga.add(manga)
            }
        }
    }

    private fun showRecyclerComicList() {
        binding.rvComic.layoutManager = LinearLayoutManager(this,  RecyclerView.HORIZONTAL, false)
        val listComicAdapter = ListComicAdapter(list)
        binding.rvComic.adapter = listComicAdapter

        listComicAdapter.setOnItemClickCallback(object : ListComicAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Comic) {
                val moveIntent = Intent(this@MainActivity, DetailComic::class.java)
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

    private fun showRecyclerManhwaList() {
        binding.rvManhwa.layoutManager = LinearLayoutManager(this,  RecyclerView.HORIZONTAL, false)
        val listComicAdapter = ListComicAdapter(listManhwa)
        binding.rvManhwa.adapter = listComicAdapter

        listComicAdapter.setOnItemClickCallback(object : ListComicAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Comic) {
                val moveIntent = Intent(this@MainActivity, DetailComic::class.java)
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

    private fun showRecyclerManhuaList() {
        binding.rvManhua.layoutManager = LinearLayoutManager(this,  RecyclerView.HORIZONTAL, false)
        val listComicAdapter = ListComicAdapter(listManhua)
        binding.rvManhua.adapter = listComicAdapter

        listComicAdapter.setOnItemClickCallback(object : ListComicAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Comic) {
                val moveIntent = Intent(this@MainActivity, DetailComic::class.java)
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

    private fun showRecyclerMangaList() {
        binding.rvManga.layoutManager = LinearLayoutManager(this,  RecyclerView.HORIZONTAL, false)
        val listComicAdapter = ListComicAdapter(listManga)
        binding.rvManga.adapter = listComicAdapter

        listComicAdapter.setOnItemClickCallback(object : ListComicAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Comic) {
                val moveIntent = Intent(this@MainActivity, DetailComic::class.java)
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