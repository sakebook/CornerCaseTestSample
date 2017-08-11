package com.sakebook.android.sample.cornercasetestsample

import org.joda.time.DateTime

/**
 * Created by sakemotoshinya on 2017/08/09.
 */
abstract class Ticket {
    abstract internal var memo: String
    abstract internal val type: Type // チケットの種類
    abstract val purchaseDateTime: DateTime // 購入日
    abstract val eventDateTime: DateTime? //
    abstract val periodDateTime: PeriodDateTime? //
    abstract protected val price: Int
    abstract internal fun dateTimePrice(dateTime: DateTime): Int
}

enum class Type {
    COUPON, // 一度きり
    COMMUTATION, // 期間使える
    ;
}

data class PeriodDateTime(val startDateTime: DateTime, val endDateTime: DateTime) {
    init {
        require(startDateTime < endDateTime) { "endDateTimeはstartDatetimeより新しい時刻にしてください" }
    }
}