package com.example.carryme.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.carryme.data.db.entities.ShoppingItem


@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase:RoomDatabase(){

    abstract fun getShoppingDao(): ShoppingDao

    companion object{
       @Volatile
       private var instance: ShoppingDatabase?=null
        private val LOCK=Any()

        // This invoke function will check weather the instance of data base is created or not
        // and if not it will call create data base

        operator fun invoke(context:Context)= instance ?: synchronized(LOCK){
          instance ?: createDatabase(context).also { instance =it }
        }

        private fun createDatabase(context:Context)=
            Room.databaseBuilder(context.applicationContext,
            ShoppingDatabase::class.java,"ShoppingDB.db").build()



    }
}