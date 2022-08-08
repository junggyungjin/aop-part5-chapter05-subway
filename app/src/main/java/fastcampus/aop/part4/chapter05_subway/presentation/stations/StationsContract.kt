package fastcampus.aop.part4.chapter05_subway.presentation.stations

import fastcampus.aop.part4.chapter05_subway.domain.Station
import fastcampus.aop.part4.chapter05_subway.presentation.BasePresenter
import fastcampus.aop.part4.chapter05_subway.presentation.BaseView

interface StationsContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showStations(stations: List<Station>)
    }

    interface Presenter : BasePresenter {

        fun filterStations(query: String)

        fun toggleStationFavorite(station: Station)
    }
}
