package rs.ac.metropolitan.cs330_pz.Repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import rs.ac.metropolitan.cs330_pz.adressData.RetrofitHelper
import rs.ac.metropolitan.cs330_pz.adressesCommon.AdressItem
import rs.ac.metropolitan.data.ApiService



class RepositoryAdress {

    var adressFlow: Flow<List<AdressItem>> = flowOf(listOf())

    suspend fun getAdress() {
        val apiSerice = RetrofitHelper.getInstance().create(ApiService::class.java)
        val result = apiSerice.getAdress()
        if (result != null)
            adressFlow = flowOf(result)
    }
}
