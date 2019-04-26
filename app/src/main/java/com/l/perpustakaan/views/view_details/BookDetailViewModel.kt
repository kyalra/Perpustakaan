package com.l.perpustakaan.views.view_details

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.l.perpustakaan.MainActivity
import com.l.perpustakaan.data.data_model.Book

class BookDetailViewModel(application: Application): AndroidViewModel(application){
    private val bookRepository = getApplication<MainActivity>().getPerpusRepo()
    private val bookId = MutableLiveData<Int>()

    fun getBookDetails(id: Int): LiveData<Book> {
        bookId.value = id
        val bookDetail = Transformations.switchMap<Int, Book>(bookId){
                id->
            bookRepository.findBook(id)
        }
        return bookDetail
    }
}