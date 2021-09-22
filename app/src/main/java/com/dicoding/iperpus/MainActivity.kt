package com.dicoding.iperpus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBook: RecyclerView
    private var list: ArrayList<Book> = arrayListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Daftar Buku"

        rvBook = findViewById(R.id.rv_books)
        rvBook.setHasFixedSize(true)

        list.addAll(BooksData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvBook.layoutManager = LinearLayoutManager(this)
        val listBookAdapter = ListBookAdapter(list)
        rvBook.adapter = listBookAdapter
    }
}