package com.sakebook.android.sample.cornercasetestsample;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.joda.time.DateTime;

/**
 * Created by sakemotoshinya on 2017/08/11.
 */

public abstract class JTicket {
    @NonNull String memo;
    @NonNull Type type;
    @NonNull DateTime purchaseDateTime;
    @Nullable DateTime eventDateTime;
    @Nullable PeriodDateTime periodDateTime;
    @NonNull int price;
    abstract int dateTimePrice(DateTime dateTime);
}
