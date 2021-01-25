package id.refactory.myshoppinglist.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import id.refactory.myshoppinglist.entity.Product

interface ProductDao {
    @Query("SELECT * FROM product WHERE transact_id = :transactId")
    fun allByTransact(transactId: Int): List<Product>

    @Insert
    fun insert(product: Product)

    @Delete
    fun delete(product: Product)
}