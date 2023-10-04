package com.example.practiceebv3.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class], version =1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun productDao(): ProductDao
    companion object{
        fun getInstance(context: Context): AppDatabase{
            val db=
                Room.databaseBuilder(context, AppDatabase::class.java, "product_db")
                    .allowMainThreadQueries()
                    .build()
            return db

        }
    }
}