package com.sweetch.core.db.dao

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.sweetch.core.db.entity.BaseEntity

abstract class BaseDao<T : BaseEntity>(
    private val tableName: String) {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(entity: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(entities: List<T>): LongArray

    @Update
    abstract fun update(entity: T)

    @Update
    abstract fun update(entities: List<T>)

    @Delete
    abstract fun delete(entity: T)

    @Delete
    abstract fun delete(entities: List<T>)

    @RawQuery
    protected abstract fun deleteAll(query: SupportSQLiteQuery): Int

    fun deleteAll() {
        val query = SimpleSQLiteQuery("DELETE FROM $tableName")
        deleteAll(query)
    }

//    @RawQuery
//    protected abstract fun getAll(query: SupportSQLiteQuery): Flowable<List<T>>? // TODO switch to livedata
//
//    fun getAll(): Flowable<List<T>>? {
//        val query = SimpleSQLiteQuery("SELECT * FROM $tableName")
//        return getAll(query)
//    }

    @RawQuery
    protected abstract fun getAllSync(query: SupportSQLiteQuery): List<T>?

    fun getAllSync(): List<T>? {
        val query = SimpleSQLiteQuery("SELECT * FROM $tableName")
        return getAllSync(query)
    }

    @RawQuery
    protected abstract fun get(query: SupportSQLiteQuery): List<T>?

    fun get(id: Int): T? {
        return get(listOf(id))?.firstOrNull()
    }

    fun get(ids: List<Int>): List<T>? {
        val result = StringBuilder()
        for (index in ids.indices) {
            if (index != 0) {
                result.append(",")
            }
            result.append("'").append(ids[index]).append("'")
        }
        val query = SimpleSQLiteQuery("SELECT * FROM $tableName WHERE id IN ($result);")
        return get(query)
    }
    // TODO Add Livedata get (async)
}

