package rs.ac.metropolitan.cs330_pz.navigacija

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import rs.ac.metropolitan.cs330_pz.ViewModeli.AppViewModel
import rs.ac.metropolitan.cs330_pz.screens.HomeScreen
import rs.ac.metropolitan.cs330_pz.screens.KontaktScreen
import rs.ac.metropolitan.cs330_pz.screens.NarucivanjeScreen
import rs.ac.metropolitan.cs330_pz.screens.PcelarDetailScreen
import rs.ac.metropolitan.cs330_pz.screens.PcelarListPage
import rs.ac.metropolitan.cs330_pz.screens.PocetniScreen
import rs.ac.metropolitan.cs330_pz.screens.ProizvodiScreen
import rs.ac.metropolitan.cs330_pz.screens.RegistrationScreen

@Composable
fun NavSetup(navController: NavHostController) {
    val vm: AppViewModel = viewModel()

    var paddingValues = PaddingValues()
    vm.navController = navController

    NavHost(navController = navController, startDestination = NavigationRoutes.Home.route) {
        composable(route = NavigationRoutes.Home.route) {
            HomeScreen(vm, paddingValues)
        }
        composable(route = NavigationRoutes.PocetniScreen.route) {
                PocetniScreen(vm,paddingValues)
            }
        composable(route=NavigationRoutes.RegistrationScreen.route){
            RegistrationScreen(vm ,paddingValues)
        }
        composable(route=NavigationRoutes.KontaktScreen.route){
            KontaktScreen(vm,paddingValues)
        }
        composable(route=NavigationRoutes.ProizvodiScreen.route){
            ProizvodiScreen(vm,paddingValues)
        }
        composable(route=NavigationRoutes.NarucivanjeScreen.route){
            NarucivanjeScreen(vm, paddingValues)
        }
        composable(route = NavigationRoutes.PcelarDetailScreen.route) {
                navBackStackEntry ->
            val elementId = navBackStackEntry.arguments?.getString("elementId")
            if (elementId != null) {
                PcelarDetailScreen(vm, elementId, paddingValues)
            }else{
                Toast.makeText(navController.context, "Error, elementId is required!", Toast.LENGTH_SHORT).show()
            }
        }
        composable(route=NavigationRoutes.PcelarListPage.route){
            PcelarListPage(vm,paddingValues)
        }

        }
    }
