package rs.ac.metropolitan.cs330_pz.ViewModeli

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import rs.ac.metropolitan.cs330_pz.navigacija.NavigationRoutes

class AppViewModel : ViewModel() {
    lateinit var navController: NavHostController

    var granted = mutableStateOf(false)

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

}