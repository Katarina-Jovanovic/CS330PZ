package rs.ac.metropolitan.cs330_pz.data

import retrofit2.http.GET
import rs.ac.metropolitan.cs330_pz.common.PcelarItem

interface ApiService {

    @GET(Constants.PCELAR_URL)
    suspend fun getPcelari(): List<PcelarItem>


}