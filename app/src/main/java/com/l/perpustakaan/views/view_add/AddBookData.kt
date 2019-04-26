package com.l.perpustakaan.views.view_add

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.l.perpustakaan.MainActivity
import com.l.perpustakaan.data.data_model.Book

class AddBookData(application: Application):AndroidViewModel(application) {
    private val bookRepository = getApplication<MainActivity>().getPerpusRepo()

    fun addBooks(book: Book) {
        bookRepository.insertBook(book)

    }
}