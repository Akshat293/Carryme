package com.example.carryme.data.repositories

import com.example.carryme.data.db.ShoppingDatabase
import com.example.carryme.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db:ShoppingDatabase
) {
    suspend fun upsert(item:ShoppingItem)=db.getShoppingDao().upsert(item)

    suspend fun  delete(item:ShoppingItem)=db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()


}