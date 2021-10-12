package com.sweetch.core.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
abstract class BaseEntity {
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

    @JvmName("getId1")
    fun getId(): Int {
        return id;
    }

    fun setId(id: Int) {

    }
}