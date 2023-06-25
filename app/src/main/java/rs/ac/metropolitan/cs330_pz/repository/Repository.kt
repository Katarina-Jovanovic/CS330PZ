package rs.ac.metropolitan.cs330_pz.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import rs.ac.metropolitan.cs330_pz.common.PcelarItem
import rs.ac.metropolitan.cs330_pz.data.ApiService
import rs.ac.metropolitan.cs330_pz.data.RetrofitHelper

class Repository {

    var pcelarFlow: Flow<List<PcelarItem>>  = flowOf(listOf())

    suspend fun loadPcelari(){
        val apiService=RetrofitHelper.getInstance().create(ApiService::class.java)
        val result=apiService.getPcelari()
        if (result!=null)
            pcelarFlow= flowOf(result)
    }
}