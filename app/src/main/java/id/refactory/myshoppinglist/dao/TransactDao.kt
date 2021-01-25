package id.refactory.myshoppinglist.dao

import androidx.room.*
import id.refactory.myshoppinglist.entity.Transact

@Dao
interface TransactDao {
    @get:Query("SELECT * FROM transact")
    val all: List<Transact>

    @Query("SELECT * FROM transact WHERE uid = :transactId")
    fun detail(transactId: Int): Transact?

    @Insert
    fun insert(transact: Transact)

    //TODO
    @Update
    fun update(transact: Transact)

    @Delete
    fun delete(transact: Transact)
}