package com.example.noteproject.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteproject.models.AppNote

@Dao
interface AppRoomDao {

    @Query("Select * from note_tables")
    fun getAllNotes():LiveData<List<AppNote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: AppNote)

    @Delete
    suspend fun delete(note: AppNote)
}