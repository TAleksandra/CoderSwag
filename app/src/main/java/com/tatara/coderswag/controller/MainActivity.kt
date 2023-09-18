package com.tatara.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.tatara.coderswag.R
import com.tatara.coderswag.model.Category
import com.tatara.coderswag.services.DataService

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ArrayAdapter<Category>
    lateinit var categoryListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            DataService.categories)
        categoryListView = findViewById(R.id.categoryListView)
        categoryListView.adapter = adapter
    }
}