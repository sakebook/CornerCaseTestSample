package com.sakebook.android.sample.cornercasetestsample;

import android.content.Context;
import android.provider.Settings;

import kotlin.jvm.internal.Intrinsics;

/**
 * Created by sakemotoshinya on 2017/08/16.
 */

public final class KJDevice {

    private KJDevice() {
    }

    static {
        new KJDevice();
    }

    public static final KJDevice INSTANCE = new KJDevice();
//    public static final KJDevice INSTANCE = (KJDevice)this;

    public final boolean enabledAutoTime(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        try {
            if(android.os.Build.VERSION.SDK_INT >= 17) {
                return android.provider.Settings.Global.getInt(context.getContentResolver(), "auto_time") > 0;
            } else {
                return Settings.System.getInt(context.getContentResolver(), "auto_time") > 0;
            }
        } catch (Settings.SettingNotFoundException e) {
            return false;
        }
    }
}