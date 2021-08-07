package com.example.noteproject.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.noteproject.utilits.REPOSITORY

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes
}