package fastcampus.aop.part4.chapter05_subway.presentation

interface BaseView<PresenterT : BasePresenter> {

    val presenter: PresenterT
}