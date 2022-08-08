package fastcampus.aop.part4.chapter05_subway.data.db.entity.mapper

import fastcampus.aop.part4.chapter05_subway.data.db.entity.StationEntity
import fastcampus.aop.part4.chapter05_subway.data.db.entity.StationWithSubwaysEntity
import fastcampus.aop.part4.chapter05_subway.data.db.entity.SubwayEntity
import fastcampus.aop.part4.chapter05_subway.domain.Station
import fastcampus.aop.part4.chapter05_subway.domain.Subway


fun StationWithSubwaysEntity.toStation() =
    Station(
        name = station.stationName,
        isFavorited = station.isFavorited,
        connectedSubways = subways.toSubways()
    )

fun Station.toStationEntity() =
    StationEntity(
        stationName = name,
        isFavorited = isFavorited,
    )


fun List<StationWithSubwaysEntity>.toStations() = map { it.toStation() }

fun List<SubwayEntity>.toSubways(): List<Subway> = map { Subway.findById(it.subwayId) }
