package fastcampus.aop.part4.chapter05_subway.data.api

import fastcampus.aop.part4.chapter05_subway.data.db.entity.StationEntity
import fastcampus.aop.part4.chapter05_subway.data.db.entity.SubwayEntity

interface StationApi {

    suspend fun getStationDataUpdatedTimeMillis(): Long

    suspend fun getStationSubways(): List<Pair<StationEntity, SubwayEntity>>
}
