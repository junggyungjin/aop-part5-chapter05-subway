package fastcampus.aop.part4.chapter05_subway.di

import android.app.Activity
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import fastcampus.aop.part4.chapter05_subway.data.AppDatabase
import fastcampus.aop.part4.chapter05_subway.data.repository.StationRepository
import fastcampus.aop.part4.chapter05_subway.data.repository.StationRepositoryImpl
import fastcampus.aop.part5.chapter05.data.api.StationApi
import fastcampus.aop.part5.chapter05.data.api.StationStorageApi
import fastcampus.aop.part5.chapter05.data.preference.PreferenceManager
import fastcampus.aop.part5.chapter05.data.preference.SharedPreferenceManager
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    /**
     * 하지만 Koin은 리플렉션을 이용해 런타임에 오브젝트 그래프를 그려주다보니(=의존성 주입을 하다보니) 앱 성능이 저하된다는 단점이 있다.
     * 따라서, 큰 규모의 프로젝트에서 Koin을 사용할 경우 Application이 시작될 때 의존성 그래프가 그려지다 보니 화면이 멈춘것처럼 될 수 있다.
     * 따라서 큰 규모의 프로젝트에서는 컴파일 타임에 의존성 그래프를 그려주는 Dagger-Hilt을 이용해 의존성 주입을 하는 것이 좋다.
     * 물론 annotation processor을 사용하는 Dagger-Hilt도 문제가 없는 것은 아니다.
     * 대규모 프로젝트가 의존성이 컴파일 타임에 주입될 경우 컴파일 타임이 길어진다. 하지만, 런타임에 주입되어 사용자의 UX(User Experience)를 해치는 것보다는 컴파일 타임에 개발자가 조금 더 고생하는 것이 낫다.
     * Koin을 도입하기 추천하는 대상은 작은 규모의 프로젝트에 의존성 주입을 빠르게 적용시켜보고 싶은 개발자이다. 자 이제 어떻게 Koin을 사용하기 위한 환경을 세팅하는지 살펴보자.
     */

    single { Dispatchers.IO}

    // Database
    single { AppDatabase.build(androidApplication()) }
    single { get<AppDatabase>().stationDao() }

    // Preference
    single {androidContext().getSharedPreferences("preference", Activity.MODE_PRIVATE)}
    single<PreferenceManager> {SharedPreferenceManager(get())}

    // Api
    single<StationApi> {StationStorageApi(Firebase.storage)}

    // Repository
    single<StationRepository> {StationRepositoryImpl(get(), get(), get(), get())}

}