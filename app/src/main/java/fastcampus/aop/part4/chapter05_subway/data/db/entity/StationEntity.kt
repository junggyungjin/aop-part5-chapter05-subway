package fastcampus.aop.part4.chapter05_subway.data.db.entity

import androidx.room.*

/**
 * 데이터 베이스의 개념 중에서도 데이터 모델에 대해 공부를 시작할 때 제일 먼저 나오는 개념이 '엔터티(Entity)' 이다.
 * 엔터티는 쉽게 말해 실체, 객체라고 생각할 수 있다.일반적으로 엔터티를 정의하는 개념들을 정리하여 나타내면 다음과 같이 볼 수 있다.
 * 엔터티는 사람, 장소, 물건, 사건, 개념 등과 같은 명사에 해당된다.
 * 엔터티는 업무상 관리가 필요한 것에 해당된다.
 * 엔터티는 저장 되기 위한 어떤 것(Thing)에 해당된다.
 */
@Entity
data class StationEntity(
    @PrimaryKey val stationName: String,
    val isFavorited: Boolean = false
)
