package rs.ac.metropolitan.cs330_pz.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rs.ac.metropolitan.cs330_pz.ViewModeli.AppViewModel
import rs.ac.metropolitan.cs330_pz.poziv.openDialer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KontaktScreen(vm: AppViewModel, paddingValues: PaddingValues){
    Column {
        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.hsv(18.040f,0.77f,0.89f)),
            title = {
                Text("Dobrodosli")

            },
            navigationIcon = {
                IconButton(onClick = {vm.navigateToPocetni() }) {
                    Icon(Icons.Filled.ArrowBack, null)

                }
            }, actions = {
                IconButton(onClick = {vm.navigateToPocetni() }) {
                    Icon(Icons.Filled.Home, "Home")
                    Spacer(modifier = Modifier.height(45.dp))

                }
                IconButton(onClick = {vm.navigateToKontakt() }) {
                    Icon(Icons.Filled.Phone, "Kontakt")
                }
                IconButton(onClick = {vm.navigateToNarucivanje() }) {
                    Icon(Icons.Filled.ShoppingCart, "Narucivanje")
                }
                IconButton(onClick = {vm.navigateToProizvodi() }) {
                    Icon(Icons.Filled.Info, "Proizvodi")
                }
            })



        openDialer()

        Button(onClick = { vm.navigateToPcelarList() }) {
            Text("Lista zaposlenih:")
        }
    }
}

@Preview
@Composable
fun KontaktiScreenPreview() {
    val vm = AppViewModel()
    KontaktScreen(vm, PaddingValues(0.dp))
}
