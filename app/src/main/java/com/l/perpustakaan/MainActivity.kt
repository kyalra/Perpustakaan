package com.l.perpustakaan

import android.app.Application
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.l.perpustakaan.data.BookRepo

class MainActivity : Application() {
    fun getPerpusRepo()= BookRepo(this)

}
