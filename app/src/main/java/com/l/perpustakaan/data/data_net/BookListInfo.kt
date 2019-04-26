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
                    "2009",
                    "300",
                    1))
            po_books.add(
                Book(
                    "CyberPunk",
                    "Kyalra",
                    "Rizky",
                    "2077",
                    "3000",
                    2))
            po_books.add(
                Book(
                    "CodeWorld",
                    "Kyalra",
                    "Rizky",
                    "2019",
                    "459",
                    3))
            return po_books
        }
    }
}