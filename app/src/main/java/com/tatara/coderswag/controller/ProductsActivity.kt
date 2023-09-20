package com.tatara.coderswag.controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatara.coderswag.R
import com.tatara.coderswag.adapters.ProductsAdapter
import com.tatara.coderswag.services.DataService
import com.tatara.coderswag.utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE)
            spanCount = 3

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720)
            spanCount = 4

        val layoutManager = GridLayoutManager(this, spanCount)
        val productsListView = findViewById<RecyclerView>(R.id.productsListView)
        productsListView.layoutManager = layoutManager
        productsListView.adapter = adapter
    }
}