package rs.ac.metropolitan.cs330_pz.ViewModeli

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import rs.ac.metropolitan.cs330_pz.common.PcelarItem
import rs.ac.metropolitan.cs330_pz.navigacija.NavigationRoutes
import rs.ac.metropolitan.cs330_pz.repository.Repository

class AppViewModel : ViewModel() {
    lateinit var navController: NavHostController
    val repository= Repository()
    var granted = mutableStateOf(false)

    private val _pcelar=MutableLiveData<List<PcelarItem>>()
    val pcelar: LiveData<List<PcelarItem>>
        get()= _pcelar

    fun loadPcelari(){
        GlobalScope.launch {
            repository.loadPcelari()
            MainScope().launch {
                repository.pcelarFlow.collect{
                    _pcelar.value=it
                }
            }
        }
    }

    fun getPcelar(id: String): PcelarItem? {
        return _pcelar.value?.find { it.id == id }
    }

    fun navigateToHome(){
        navController.navigate(NavigationRoutes.Home.route)
    }

    fun navigateToPocetni() {
        navController.navigate(NavigationRoutes.PocetniScreen.route)
    }

    fun navigateToRegistration(){
        navController.navigate(NavigationRoutes.RegistrationScreen.route)
    }
    fun navigateToProizvodi(){
        navController.navigate(NavigationRoutes.ProizvodiScreen.route)

    }
    fun navigateToNarucivanje(){
        navController.navigate(NavigationRoutes.NarucivanjeScreen.route)
    }
    fun navigateToKontakt(){
        navController.navigate(NavigationRoutes.KontaktScreen.route)
    }

    fun navigateToPcelarList(){
        navController.navigate(NavigationRoutes.PcelarListPage.route)
    }
    fun goBack() {
        navController.popBackStack()
    }
    fun navigateToPcelarDetails(id:String){
        navController.navigate(NavigationRoutes.PcelarDetailScreen.createRoute(id))
    }
}