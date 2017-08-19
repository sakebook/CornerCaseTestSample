package com.sakebook.android.sample.cornercasetestsample;

import android.content.Context;

import org.joda.time.DateTime;

/**
 * Created by sakemotoshinya on 2017/08/11.
 */

public class JMovieTicket extends JTicket {

    JMovieTicket(DateTime purchaseDateTime, Type type) {
        this.purchaseDateTime = purchaseDateTime;
        this.type = type;
        memo = "memo";
        eventDateTime = purchaseDateTime.dayOfMonth().roundFloorCopy();
        periodDateTime = null;
        price = dateTimePrice(purchaseDateTime);
    }

    @Override
    int dateTimePrice(DateTime dateTime) {
        if (dateTime.getDayOfMonth() == 1) {
            return 1100;
        }
        int hourOfDay = dateTime.getHourOfDay();
        if (hourOfDay < 2 || hourOfDay >= 20) {
            return 1300;
        }
        return 1800;
    }

    public int purchasePrice(Context context) {
        if (JDevice.INSTANCE.enabledAutoTime(context)) {
            return price;
        }
        return 2000;
    }

}
