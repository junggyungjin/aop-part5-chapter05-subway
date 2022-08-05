package fastcampus.aop.part4.chapter05_subway.data.repository

import fastcampus.aop.part5.chapter05.domain.Station
import kotlinx.coroutines.flow.Flow

interface StationRepository {

    val stations: Flow<List<Station>>

    suspend fun refreshStations()
}