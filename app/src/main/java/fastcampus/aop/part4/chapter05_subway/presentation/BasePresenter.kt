package fastcampus.aop.part4.chapter05_subway.presentation

import androidx.annotation.CallSuper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

interface BasePresenter {

    val scope: CoroutineScope
        get() = MainScope()

    fun onViewCreated()

    fun onDestroyView()

    @CallSuper
    fun onDestroy() {
        scope.cancel()
    }
}