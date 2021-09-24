package com.dicoding.iperpus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailBookActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_SPECIFICATION = "extra_specification"


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_book)

        val tvItemNameReceived: TextView = findViewById(R.id.tv_item_name)
        val tvItemDescriptionReceived: TextView = findViewById(R.id.tv_item_description)
        val imgItemPhotoReceived: ImageView = findViewById(R.id.img_item_photo)
        val tvItemSpecificationReceived: TextView = findViewById(R.id.tv_item_specification)

        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val specification = intent.getStringExtra(EXTRA_SPECIFICATION)

        tvItemNameReceived.text = name
        tvItemDescriptionReceived.text = detail
        tvItemSpecificationReceived.text = specification
        imgItemPhotoReceived.setImageResource(photo)



    }
}