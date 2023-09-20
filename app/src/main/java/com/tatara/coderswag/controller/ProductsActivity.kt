package com.tatara.coderswag.controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatara.coderswag.R
import com.tatara.coderswag.adapters.ProductsAdapter
import com.tatara.coderswag.model.Product
import com.tatara.coderswag.services.DataService
import com.tatara.coderswag.utilities.EXTRA_CATEGORY
import com.tatara.coderswag.utilities.EXTRA_PRODUCT_DETAILS

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter
    var product = Product("", "", "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType)) {
            val productDetailIntent = Intent(this, ProductDetailActivity::class.java)
            productDetailIntent.putExtra(EXTRA_PRODUCT_DETAILS, it)
            startActivity(productDetailIntent)
        }

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