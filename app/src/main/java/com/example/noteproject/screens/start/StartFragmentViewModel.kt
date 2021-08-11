package com.example.noteproject.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.noteproject.database.firebase.AppFirebaseRepository
import com.example.noteproject.database.room.AppRoomDatabase
import com.example.noteproject.database.room.AppRoomRepository
import com.example.noteproject.utilits.REPOSITORY
import com.example.noteproject.utilits.TYPE_FIREBASE
import com.example.noteproject.utilits.TYPE_ROOM
import com.example.noteproject.utilits.showToast

class StartFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type:String, onSuccess:() -> Unit){
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connentToDatabase({onSuccess()}, { showToast(it)})
            }
        }
    }
}