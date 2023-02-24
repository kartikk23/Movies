package com.kartik.myapplication.Room


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val Title: String,
    val Year: String,
    val Runtime: String,
    val Cast: String
)