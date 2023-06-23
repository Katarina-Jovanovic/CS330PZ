package rs.ac.metropolitan.cs330_pz.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(vm: AppViewModel, paddingValues: PaddingValues) {

    var text by remember{
        mutableStateOf("")
    }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    lateinit var navController: NavHostController

    navController= rememberNavController()
    Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
    ) {
        Text(
            text = "Login",
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            color =  Color.Companion.hsv(14.040f,0.77f,0.89f),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(25.dp))
            Text("Unesite username")
        Spacer(modifier = Modifier.height(5.dp))
            TextField(
                value = text, onValueChange = {
                    text = it
                }, modifier = Modifier.fillMaxWidth(),
                label = { Text("Username") }
            )
        Spacer(modifier = Modifier.height(45.dp))
            Text("Unesite lozinku")
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            placeholder = { Text("Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()

        )

            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { vm.navigateToPocetni()},
                modifier= Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(containerColor = Color.hsv(14.040f,0.77f,0.89f))
            ) {
                Text(text = "Login")
            }
        Spacer(modifier = Modifier.height(25.dp))
        Text("Nemate nalog?   Registujte se")
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {vm.navigateToRegistration()},
            modifier= Modifier.align(Alignment.End),
            colors = ButtonDefaults.buttonColors(containerColor = Color.hsv(14.040f,0.77f,0.89f))
        ) {
            Text(text = "Registracija")
        }
    }

}
@Preview
@Composable
fun HomeScreenPreview() {
    val vm = AppViewModel()
    HomeScreen(vm, PaddingValues(0.dp))
}
