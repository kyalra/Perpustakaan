package com.l.perpustakaan.views.view_add

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.l.perpustakaan.R
import com.l.perpustakaan.data.data_model.Book
import kotlinx.android.synthetic.main.fragment_add_book.*

class FragmentAddBook:Fragment(){
    lateinit var btn_ : Button
    private lateinit var viewModel: AddBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddBookViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(R.layout.fragment_add_book, container, false)
        btn_ = view.findViewById(R.id.btn_book)
        return view
    }

    private fun saveBookInfo(){
        val book = Book(
            textInputJudul.editText?.text.toString(),
            textInputPenerbit.editText?.text.toString(),
            textInputpenulis.editText?.text.toString()
        )
        viewModel.addBook(book)
        Navigation.findNavController(view!!).navigateUp()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_.setOnClickListener {
            saveBookInfo()
        }
    }
}