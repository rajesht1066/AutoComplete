package com.example.autocomplete

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.autocomplete.databinding.ActivityMainBinding
import com.example.autocomplete.view.adapters.RecyclerAdapter
import com.example.autocomplete.viewmodel.CityViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(CityViewModel::class.java)

        viewModel.data.observe(this, Observer {
            prepareRecyclerView(it)
        })

        binding.editText.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    if(p0.toString().length>=3){
                        Log.d("check","gwied")
                        viewModel.getDataFromApi(p0.toString())
                    }
                }
            }

        })
    }

    fun prepareRecyclerView(data:ArrayList<String>){
        Log.d("recycle",data.toString())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerAdapter(data)
        binding.recyclerView.adapter = adapter
    }
}