package com.tatara.coderswag.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatara.coderswag.R
import com.tatara.coderswag.adapters.CategoryAdapter
import com.tatara.coderswag.adapters.CategoryRecycleAdapter
import com.tatara.coderswag.model.Category
import com.tatara.coderswag.services.DataService
import com.tatara.coderswag.utilities.EXTRA_CATEGORY

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter
    lateinit var categoryListView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) {category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categoryListView = findViewById(R.id.categoryListView)
        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)

        //dodanie listenera do listview
//        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
//            val category = DataService.categories[i]
//            Toast.makeText(this, "You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()
//        }
    }
}