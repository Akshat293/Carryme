package com.example.carryme.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.carryme.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {
    // To replace if the item with id is already is present
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT*FROM shopping_items")
    fun getAllShoppingItems():LiveData<List<ShoppingItem>>
    


}