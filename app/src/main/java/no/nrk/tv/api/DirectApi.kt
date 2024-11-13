package no.nrk.tv.api

import no.nrk.tv.data.network.model.DirectNetworkModel
import retrofit2.http.GET

interface DirectApi {
    @GET("/direkte/response.json")
    suspend fun getDirectFeed(): DirectNetworkModel
}