package com.example.noteproject.database

import androidx.lifecycle.LiveData
import com.example.noteproject.models.AppNote
import io.reactivex.internal.operators.single.SingleDoOnSuccess

interface DatabaseRepository {
    val allNotes:LiveData<List<AppNote>>
    suspend fun insert(note: AppNote, onSuccess:() -> Unit)
    suspend fun delete(note: AppNote, onSuccess:() -> Unit)

    fun connentToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit){}

    fun signOut(){}
}