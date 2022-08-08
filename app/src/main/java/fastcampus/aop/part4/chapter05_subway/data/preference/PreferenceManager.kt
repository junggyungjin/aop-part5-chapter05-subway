package fastcampus.aop.part4.chapter05_subway.data.preference

interface PreferenceManager {

    fun getLong(key: String): Long?

    fun putLong(key: String, value: Long)
}
