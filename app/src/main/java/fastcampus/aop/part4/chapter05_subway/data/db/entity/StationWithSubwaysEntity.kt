package fastcampus.aop.part4.chapter05_subway.data.db.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import fastcampus.aop.part4.cchapter05_subway.data.db.entity.StationSubwayCrossRefEntity

data class StationWithSubwaysEntity(
    @Embedded val station: StationEntity,
    @Relation(
        parentColumn = "stationName",
        entityColumn = "subwayId",
        associateBy = Junction(StationSubwayCrossRefEntity::class)
    )
    val subways: List<SubwayEntity>
)
