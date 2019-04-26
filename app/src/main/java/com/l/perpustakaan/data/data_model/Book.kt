package com.l.perpustakaan.data.data_model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Book(
    var judul : String = "",
    var penerbit : String = "",
    var penulis : String = "",

    @PrimaryKey(autoGenerate = true) var id : Int = 0
)