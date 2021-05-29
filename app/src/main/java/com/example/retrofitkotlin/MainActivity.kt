package com.example.retrofitkotlin

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitkotlin.`interface`.RetrofitServices
import com.example.retrofitkotlin.adapter.MyMovieAdapter
import com.example.retrofitkotlin.common.Common
import com.example.retrofitkotlin.model.Movie
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var mLinearLayoutManager: LinearLayoutManager
    lateinit var mMyMovieAdapter: MyMovieAdapter
    lateinit var mAlertDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitServices!!

        recyclerMovieList.setHasFixedSize(true)

        mLinearLayoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = mLinearLayoutManager

        mAlertDialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        mAlertDialog.show()
        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                mMyMovieAdapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movie>)
                mMyMovieAdapter.notifyDataSetChanged()
                recyclerMovieList.adapter = mMyMovieAdapter

                mAlertDialog.dismiss()
            }

            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {

            }

        })
    }
}