package com.sakebook.android.sample.cornercasetestsample

import android.content.Context
import org.joda.time.DateTime

/**
 * Created by sakemotoshinya on 2017/08/09.
 */
class MovieTicket(override val purchaseDateTime: DateTime = DateTime(), override val type: Type = Type.COUPON) : Ticket() {
    override var memo: String = "memo"
    override val eventDateTime: DateTime = purchaseDateTime.dayOfMonth().roundFloorCopy()
    override val periodDateTime: PeriodDateTime? = null
    override val price: Int = dateTimePrice(purchaseDateTime)

    override fun dateTimePrice(dateTime: DateTime): Int {
        if (dateTime.dayOfMonth == 1) {
            return 1100
        }
        return when(dateTime.hourOfDay) {
            in 0 until 2 ,
            in 20 until 24 -> 1300
            else -> 1800
        }
    }

    fun purchasePrice(context: Context): Int {
        return when(Device.enabledAutoTime(context)) {
            true -> price
            false -> 2000
        }
    }
}