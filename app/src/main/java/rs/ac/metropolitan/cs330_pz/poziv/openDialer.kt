package rs.ac.metropolitan.cs330_pz.poziv

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

@Composable
fun openDialer() {

    val phoneNumber = "+38123456789" // Broj telefona koji želite da prikažete

    val showDialog = remember { mutableStateOf(false) }

    Column {
        Text(text = "Ukoliko vas nesto zanima: Kontaktirajte nas")
        Button(onClick = { showDialog.value = true }) {
            Text(text = "Call centar")
        }
    }

    if (showDialog.value) {
        val currentContext = LocalContext.current
        val launcher = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                // Dozvola je odobrena, možete sada pozvati broj telefona
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:$phoneNumber")
                currentContext.startActivity(callIntent)
            } else {
                // Dozvola nije odobrena, možete prikazati poruku ili preduzeti odgovarajuće akcije
                Toast.makeText(
                    currentContext,
                    "Dozvola za telefoniranje nije odobrena",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Potvrda poziva") },
            text = { Text(text = "Da li želite da pozovete $phoneNumber?") },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog.value = false
                        launcher.launch(Manifest.permission.CALL_PHONE)
                    }
                ) {
                    Text(text = "Pozovi")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(text = "Otkaži")
                }
            }
        )
    }
}

