package rs.ac.metropolitan.cs330_pz.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ShoppingCart
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
import rs.ac.metropolitan.cs330_pz.animacija.ImageSlider
import rs.ac.metropolitan.cs330_pz.R
import rs.ac.metropolitan.cs330_pz.ViewModeli.AppViewModel
import rs.ac.metropolitan.cs330_pz.animacija.Bee

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PocetniScreen(vm: AppViewModel, paddingValues: PaddingValues){
    Column {

        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Companion.hsv(18.040f,0.77f,0.89f)),
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
            }
        )

        val images= listOf(
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image7,
            R.drawable.image8
        )


        ImageSlider(images = images)

    }
    Box(modifier = Modifier
        .fillMaxSize()
        .offset(x = (-16).dp, y = 16.dp)
        .padding(10.dp, 250.dp)){
        Bee()
        LazyColumn (modifier = Modifier.fillMaxWidth().padding(55.dp)){

            var longText="\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod est ac justo pretium, vitae eleifend est convallis. Sed fringilla mauris id orci finibus interdum. Aliquam gravida laoreet eros non dignissim. In ac tincidunt lacus. Mauris tincidunt vulputate lacus, ac ultrices lectus faucibus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed eu risus ac orci lobortis pulvinar. Vivamus eu quam vitae ligula bibendum aliquam. Ut hendrerit tellus eget lacinia iaculis. Aliquam interdum posuere lorem, id finibus elit accumsan ut. Sed sed ex lobortis, venenatis est vitae, fermentum leo. Morbi vitae pharetra urna. Nam vel mi nulla. Maecenas vel lectus augue.\"sgdahsudsadjsaidjsaiodhsaudzhsuaidhsauidhsoaiudhsaidhsuiadhasudhsuiahdsuadhsuaihdsuiadhusiahdusiahduisahdusiahduisahduisadhuisahduisahduisahduisahdusahdushduashdusahdusadhusadhusadhusadhsuahduisadhiasudhsiau"
            item {
                Text(text = longText)
            }
        }

    }
}
@Preview
@Composable
fun PocetniScreenPreview() {
    val vm = AppViewModel()
    PocetniScreen(vm, PaddingValues(0.dp))
}