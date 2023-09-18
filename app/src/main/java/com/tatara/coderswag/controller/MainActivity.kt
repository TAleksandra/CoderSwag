package com.tatara.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.tatara.coderswag.R
import com.tatara.coderswag.adapters.CategoryAdapter
import com.tatara.coderswag.model.Category
import com.tatara.coderswag.services.DataService

class MainActivity : AppCompatActivity() {
    lateinit var adapter: CategoryAdapter
    lateinit var categoryListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories)
        categoryListView = findViewById(R.id.categoryListView)
        categoryListView.adapter = adapter
    }
}