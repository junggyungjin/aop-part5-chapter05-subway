package fastcampus.aop.part4.chapter05_subway.data.api

import fastcampus.aop.part4.chapter05_subway.BuildConfig
import fastcampus.aop.part4.chapter05_subway.BuildConfig.SEOUL_API_ACCESS_KEY
import fastcampus.aop.part4.chapter05_subway.data.api.response.RealtimeStationArrivals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StationArrivalsApi {

//    @GET("api/subway/${fastcampus.aop.part4.chapter05_subway.BuildConfig.SEOUL_API_ACCESS_KEY}/json/realtimeStationArrival/0/100/{stationName}")
//    suspend fun getRealtimeStationArrivals(@Path("stationName") stationName: String): Response<RealtimeStationArrivals>

    @GET("api/subway/${BuildConfig.SEOUL_API_ACCESS_KEY}/json/realtimeStationArrival/0/100/{stationName}")
    suspend fun getRealtimeStationArrivals(@Path("stationName") stationName: String): Response<RealtimeStationArrivals>
}
