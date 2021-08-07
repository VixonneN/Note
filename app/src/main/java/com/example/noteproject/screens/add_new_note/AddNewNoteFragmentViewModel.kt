package com.example.noteproject.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteproject.models.AppNote
import com.example.noteproject.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteFragmentViewModel(application: Application): AndroidViewModel(application) {
    fun insert(note:AppNote, onSuccess:() -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insert(note){
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }
}