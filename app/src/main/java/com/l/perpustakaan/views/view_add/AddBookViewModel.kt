package com.l.perpustakaan.views.view_add

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.l.perpustakaan.MainActivity
import com.l.perpustakaan.R
import com.l.perpustakaan.data.data_model.Book

class AddBookViewModel(application: Application):AndroidViewModel(application){
    private val bookRepository=getApplication<MainActivity>().getPerpusRepo()

    fun addBook(book: Book){
        bookRepository.insertBook(book)
    }
}