package com.sakebook.android.sample.cornercasetestsample

import org.joda.time.DateTime

/**
 * Created by sakemotoshinya on 2017/08/09.
 */
abstract class Ticket {
    abstract var memo: String // メモ用
    abstract internal val type: Type // チケットの種類
    abstract val purchaseDateTime: DateTime // 購入日
    abstract val eventDateTime: DateTime? // 開催日時
    abstract val periodDateTime: PeriodDateTime? // 開催期間
    abstract protected val price: Int // 値段
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