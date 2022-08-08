package fastcampus.aop.part4.chapter05_subway.data

import androidx.room.*
import fastcampus.aop.part4.cchapter05_subway.data.db.entity.StationSubwayCrossRefEntity
import fastcampus.aop.part4.chapter05_subway.data.db.entity.StationEntity
import fastcampus.aop.part4.chapter05_subway.data.db.entity.StationWithSubwaysEntity
import fastcampus.aop.part4.chapter05_subway.data.db.entity.SubwayEntity
import kotlinx.coroutines.flow.Flow

/**
 * DAO(Data Access Object) 는 데이터베이스의 data에 접근하기 위한 객체입니다.
 * DataBase에 접근 하기 위한 로직 & 비지니스 로직을 분리하기 위해 사용합니다.
 */

/**
 * DTO(Data Transfer Object) 는 계층 간 데이터 교환을 하기 위해 사용하는 객체로,
 * DTO는 로직을 가지지 않는 순수한 데이터 객체(getter & setter 만 가진 클래스)입니다.
 * 유저가 입력한 데이터를 DB에 넣는 과정을 보겠습니다.
 * 유저가 자신의 브라우저에서 데이터를 입력하여 form에 있는 데이터를 DTO에 넣어서 전송합니다.
 * 해당 DTO를 받은 서버가 DAO를 이용하여 데이터베이스로 데이터를 집어넣습니다.
 */

@Dao
interface StationDao {

    /**
     * Flow<>란,
     * room에서 제공하는 코루틴을 이용한 observable read 기능.
     * rx는 Flowable<>, Jetpack Lifecycle은 liveData<>를 사용함
     */

    @Transaction
    @Query("SELECT * FROM StationEntity")
    fun getStationWithSubways(): Flow<List<StationWithSubwaysEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStations(station: List<StationEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubways(subways: List<SubwayEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrossReferences(reference: List<StationSubwayCrossRefEntity>)

    @Transaction
    suspend fun insertStationSubways(stationSubways: List<Pair<StationEntity, SubwayEntity>>) {
        insertStations(stationSubways.map { it.first })
        insertSubways(stationSubways.map { it.second })
        insertCrossReferences(
            stationSubways.map { (station, subway) ->
                StationSubwayCrossRefEntity(
                    station.stationName,
                    subway.subwayId
                )
            }
        )
    }

    @Update
    suspend fun updateStation(station: StationEntity)
}
