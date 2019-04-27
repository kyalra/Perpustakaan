package com.l.perpustakaan.data.data_net

import com.l.perpustakaan.data.data_model.Book

class BookListInfo {
    companion object{
        val bookList=initBookList()

//        add dummy data

        private fun initBookList():MutableList<Book>{
            var po_books= mutableListOf<Book>()
            po_books.add(
                Book(
                    "Terlahir",
                    "Kyalra",
                    "Rizky",
                    1))
            po_books.add(
                Book(
                    "CyberPunk",
                    "Kyalra",
                    "Rizky",
                    2))
            po_books.add(
                Book(
                    "CodeWorld",
                    "Kyalra",
                    "Rizky",
                    3))
            return po_books
        }
    }
}