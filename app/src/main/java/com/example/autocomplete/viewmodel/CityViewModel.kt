package com.example.autocomplete.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.autocomplete.model.interfaces.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class CityViewModel:ViewModel() {
    private var result:ArrayList<String> = ArrayList()
    val data = MutableLiveData<ArrayList<String>>()

    fun getDataFromApi(pattern:String){
        val key = "fKzVotCk8CmC2teZ3QEn0f9XoL_sZAV585wgTMKFoao"
        var endPoint = "autocomplete?q=$pattern&apiKey=$key"

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val apiData = RetrofitHelper.api.getCity(endPoint)
                apiData?.body()?.let {
                    val items = apiData.body()?.items
                    items?.let {
                        val labels:ArrayList<String> = ArrayList()
                        for (i in items){
                            labels.add(i.address.label)
                        }
                        result = labels
                        Log.d("API Response",result.toString())
                        data.postValue(result)
                    }
                }
            }
            catch (e:Exception){
                Log.d("error",e.toString())
            }
        }
    }
}