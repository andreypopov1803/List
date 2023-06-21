package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemList: RecyclerView = findViewById(R.id.item_list)
        val items = arrayListOf<Item>()

        items.add(Item(1, "one", "Второй", "Третий", "Четвертый", 100))
        items.add(Item(2, "twodasda", "Втdasdорой", "Третfdfий", "Четdafsdfвертый", 100))
        items.add(Item(3, "threeadsd", "Второdasdй", "Третиbvxcй", "Четвеdffртый", 100))

        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = ItemsAdapter(items, this)

    }
}