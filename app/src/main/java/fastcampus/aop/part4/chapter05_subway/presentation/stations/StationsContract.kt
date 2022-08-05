package fastcampus.aop.part4.chapter05_subway.presentation.stations

import fastcampus.aop.part4.chapter05_subway.presentation.BasePresenter
import fastcampus.aop.part4.chapter05_subway.presentation.BaseView
import fastcampus.aop.part5.chapter05.domain.Station

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
