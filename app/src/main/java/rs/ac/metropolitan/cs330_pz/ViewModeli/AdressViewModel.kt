package rs.ac.metropolitan.cs330_pz.ViewModeli

import android.app.appsearch.ReportSystemUsageRequest
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import rs.ac.metropolitan.cs330_pz.Repository.RepositoryAdress
import rs.ac.metropolitan.cs330_pz.adressData.RetrofitHelper
import rs.ac.metropolitan.cs330_pz.adressesCommon.AdressItem
import rs.ac.metropolitan.data.ApiService

class AdressViewModel : ViewModel() {

    lateinit var navController: NavHostController
    val repository= RepositoryAdress()
    var granted= mutableStateOf(false)
    private val _adress=MutableLiveData<List<AdressItem>>()
    val adress: LiveData<List<AdressItem>>
        get() = _adress

    fun getAdress(){
        GlobalScope.launch {
            repository.getAdress()
            MainScope().launch {
                repository.adressFlow.collect{
                    _adress.value=it
                }
            }
        }
    }
}