package fastcampus.aop.part4.chapter05_subway.presentation.stationarrivals

import fastcampus.aop.part4.chapter05_subway.domain.ArrivalInformation
import fastcampus.aop.part4.chapter05_subway.presentation.BasePresenter
import fastcampus.aop.part4.chapter05_subway.presentation.BaseView

interface StationArrivalsContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showErrorDescription(message: String)

        fun showStationArrivals(arrivalInformation: List<ArrivalInformation>)
    }

    interface Presenter : BasePresenter {

        fun fetchStationArrivals()

        fun toggleStationFavorite()
    }
}
