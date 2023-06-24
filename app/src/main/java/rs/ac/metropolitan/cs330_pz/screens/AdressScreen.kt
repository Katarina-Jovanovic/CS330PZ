package rs.ac.metropolitan.cs330_pz.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import rs.ac.metropolitan.cs330_pz.ViewModeli.AdressViewModel
import rs.ac.metropolitan.cs330_pz.prikazAdresa.AdressList

@Composable
fun AdressScreen(adressViewModel: AdressViewModel = viewModel()) {
    AdressList(adressViewModel)
}