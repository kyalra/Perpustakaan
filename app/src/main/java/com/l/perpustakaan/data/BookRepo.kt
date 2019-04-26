package com.l.perpustakaan.data

import android.app.Application
import android.arch.lifecycle.LiveData
import com.l.perpustakaan.data.data_model.Book
import com.l.perpustakaan.data.db_only.BookDAO
import com.l.perpustakaan.data.db_only.BookDb

class BookRepo(application: Application) {
    private val bookDao: BookDAO

init {
    val bookDatabase=BookDb.getInstance(application)
    bookDao=bookDatabase.bookDAO()
}
//    menampulkan data tapi secara discencing]

    fun geAllBook():LiveData<List<Book>>{
        return bookDao.getAll()
    }

    fun insertBook(book: Book){
        bookDao.insert(book)
    }

    fun findBook(id: Int ):LiveData<Book>{
        return bookDao.find(id)
    }
}