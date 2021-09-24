package com.dicoding.iperpus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.iperpus.BooksData.listData
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBook: RecyclerView
    private var list: ArrayList<Book> = arrayListOf()


//    list.addAll(BookData.listData)


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

        listBookAdapter.setOnItemClickCallback(object : ListBookAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Book) {
                showSelectedBook(data)
            }
        })

    }

    private fun showSelectedBook(book: Book) {
        val moveWithDataIntent = Intent(this@MainActivity, DetailBookActivity::class.java)
        moveWithDataIntent.putExtra(DetailBookActivity.EXTRA_NAME, book.name)
        moveWithDataIntent.putExtra(DetailBookActivity.EXTRA_DESCRIPTION, book.detail)
        moveWithDataIntent.putExtra(DetailBookActivity.EXTRA_SPECIFICATION, book.specification)
        moveWithDataIntent.putExtra(DetailBookActivity.EXTRA_PHOTO, book.photo)
        startActivity(moveWithDataIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean  {
        fun menuProfileCLicked(){
            val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(moveIntent)
        }
        return when (item.itemId) {
            R.id.profile -> {
                menuProfileCLicked()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        }

}

