package com.sakebook.android.sample.cornercasetestsample;

import android.content.Context;

import org.joda.time.DateTime;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/**
 * Created by sakemotoshinya on 2017/08/12.
 */

public final class KJMovieTicket extends KJTicket {

    private final DateTime eventDateTime;
    private String memo;
    private final PeriodDateTime periodDateTime = null;
    private final int price;
    private final DateTime purchaseDateTime;
    private final Type type;

    public KJMovieTicket() {
        this(null, null, 3);
    }

    public KJMovieTicket(DateTime datetime, Type type1) {
        super();
        Intrinsics.checkParameterIsNotNull(datetime, "purchaseDateTime");
        Intrinsics.checkParameterIsNotNull(type1, "type");
//        super();
        purchaseDateTime = datetime;
        type = type1;
        memo = "memo";
        datetime = getPurchaseDateTime().dayOfMonth().roundFloorCopy();
        Intrinsics.checkExpressionValueIsNotNull(datetime, "purchaseDateTime.dayOfMonth().roundFloorCopy()");
        eventDateTime = datetime;
        price = dateTimePrice(getPurchaseDateTime());
    }

    public KJMovieTicket(DateTime datetime, Type type1, int i) {
        this(datetime, type1);
        if((i & 1) != 0)
            datetime = new DateTime();
        if((i & 2) != 0)
            type1 = Type.COUPON;
//        this(datetime, type1, defaultconstructormarker);
    }

    public int dateTimePrice(DateTime datetime) {
        Intrinsics.checkParameterIsNotNull(datetime, "dateTime");
        if(datetime.getDayOfMonth() == 1)
            return 1100;
        for(int i = datetime.getHourOfDay(); RangesKt.until(0, 2).contains(i) || RangesKt.until(20, 24).contains(i);)
            return 1300;
        return 1800;
    }

    public DateTime getEventDateTime() {
        return eventDateTime;
    }

    public String getMemo() {
        return memo;
    }

    public PeriodDateTime getPeriodDateTime() {
        return periodDateTime;
    }

    protected int getPrice() {
        return price;
    }

    public DateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

    public Type getType() {
        return type;
    }

    public final int purchasePrice(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        boolean flag = KJDevice.INSTANCE.enabledAutoTime(context);
        if(flag)
            return getPrice();
        if(!flag)
            return 2000;
        else
            throw new NoWhenBranchMatchedException();
    }

    public void setMemo(String s) {
        Intrinsics.checkParameterIsNotNull(s, "<set-?>");
        memo = s;
    }
}
