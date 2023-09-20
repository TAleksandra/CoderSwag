package com.tatara.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.tatara.coderswag.R
import com.tatara.coderswag.model.Product
import com.tatara.coderswag.utilities.EXTRA_PRODUCT_DETAILS

class ProductDetailActivity : AppCompatActivity() {
    lateinit var product: Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        product = intent.getParcelableExtra(EXTRA_PRODUCT_DETAILS)!!

        val productDetailImage = findViewById<ImageView>(R.id.productDetailImage)
        val productDetailName = findViewById<TextView>(R.id.productDetailName)
        val productDetailPrice = findViewById<TextView>(R.id.productDetailPrice)

        val resourceId = this.resources.getIdentifier(product.image, "drawable", this.packageName)

        productDetailImage?.setImageResource(resourceId)
        productDetailName?.text = product.title
        productDetailPrice?.text = product.price

        println("PRODUCT: ${product.image.toString()}, ${product.title}, ${product.price}")
    }

    fun cartClicked(view: View) {
        Toast.makeText(this, "Product ${product.title} successfully added to cart!", Toast.LENGTH_SHORT).show()
    }
}