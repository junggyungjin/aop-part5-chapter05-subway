package fastcampus.aop.part4.chapter05_subway.data.repository

import fastcampus.aop.part4.chapter05_subway.domain.ArrivalInformation
import fastcampus.aop.part4.chapter05_subway.domain.Station
import kotlinx.coroutines.flow.Flow

interface StationRepository {

    val stations: Flow<List<Station>>

    suspend fun refreshStations()

    suspend fun getStationArrivals(stationName: String): List<ArrivalInformation>

    suspend fun updateStation(station: Station)
}