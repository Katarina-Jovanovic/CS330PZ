package rs.ac.metropolitan.data

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import rs.ac.metropolitan.cs330_pz.adressesCommon.AdressItem

interface ApiService {
        @GET(Constants.ADRESE_URL)
        suspend fun getAdress(): List<AdressItem>

}