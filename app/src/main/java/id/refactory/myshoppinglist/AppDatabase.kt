package id.refactory.myshoppinglist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.refactory.myshoppinglist.dao.ProductDao
import id.refactory.myshoppinglist.dao.TransactDao
import id.refactory.myshoppinglist.entity.Product
import id.refactory.myshoppinglist.entity.Transact

@Database(entities = [(Transact::class), (Product::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun transactDao(): TransactDao

    abstract fun productDao(): ProductDao

    companion object {

        private var sInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "shopping"
                    )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return sInstance!!
        }
    }

}
