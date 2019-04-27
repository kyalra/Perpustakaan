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

    //mengambil semua db
    fun getAllBook(): LiveData<List<Book>>{
        return bookDao.getAll()
    }

    //inserbook
    fun insertBook(book: Book){
        bookDao.insert(book)
    }

    //find by id
    fun findBook(id : Int): LiveData<Book>{
        return bookDao.find(id)
    }

}