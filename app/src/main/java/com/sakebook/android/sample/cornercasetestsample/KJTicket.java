package com.sakebook.android.sample.cornercasetestsample;

/**
 * Created by sakemotoshinya on 2017/08/12.
 */

import org.joda.time.DateTime;

public abstract class KJTicket {

    public KJTicket() {
    }

    public abstract int dateTimePrice(DateTime datetime);

    public abstract DateTime getEventDateTime();

    public abstract String getMemo();

    public abstract PeriodDateTime getPeriodDateTime();

    protected abstract int getPrice();

    public abstract DateTime getPurchaseDateTime();

    public abstract Type getType();

    public abstract void setMemo(String s);
}