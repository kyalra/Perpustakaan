package com.l.perpustakaan.data.db_only

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.os.AsyncTask
import com.l.perpustakaan.data.data_model.Book
import com.l.perpustakaan.data.data_net.BookListInfo
import java.util.concurrent.locks.Lock

@Database(entities = [Book::class],version = 1)
abstract class BookDb:RoomDatabase() {
    abstract fun bookDAO():BookDAO

    companion object{
        private  val lock=Any()
        private const val DB_NAME="book.db"
        private var INSTANCE:BookDb?=null

        fun getInstance(application: Application):BookDb{
            synchronized(lock) {
                if (BookDb.INSTANCE == null) {
                    BookDb.INSTANCE =
                        Room.databaseBuilder(
                            application,
                            BookDb::class.java, BookDb.DB_NAME
                        )
                            .allowMainThreadQueries()
                            .addCallback(object : RoomDatabase.Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    BookDb.INSTANCE?.let {
                                        BookDb.prePopulated(it, BookListInfo.bookList)
                                    }
                                }
                            })
                            .build()
                }
                return INSTANCE!!
            }

        }
        fun prePopulated(database:BookDb,bookList:List<Book>){
            for (book in bookList){
                AsyncTask.execute { database.bookDAO().insert(book) }
            }
        }
    }
}