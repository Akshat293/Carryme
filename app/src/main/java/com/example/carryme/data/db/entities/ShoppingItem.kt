package com.example.carryme.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items") // Table
data class ShoppingItem(
    // Column name should be mentioned
    @ColumnInfo(name="item_name")
    var name:String,
    @ColumnInfo(name="item_amount")
    var amount:Int


){
    // A primary key is needed which is unique for each and every column
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null

}
