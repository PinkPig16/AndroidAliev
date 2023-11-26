package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.utils.NetworkUtil
import java.net.URL


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCLick(view: View) {
        val searchField: EditText = findViewById(R.id.et_search_field)
        val result : TextView =  findViewById(R.id.search_result);
        val network = NetworkUtil(this)
        var generateURL: URL = network.generateURL(searchField.toString())
        var resultRespons  = network.getResponsFromURL(generateURL)
        result.setText(resultRespons)


    }
}


