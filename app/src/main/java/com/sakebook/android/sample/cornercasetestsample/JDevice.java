package com.sakebook.android.sample.cornercasetestsample;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/**
 * Created by sakemotoshinya on 2017/08/17.
 */

public final class JDevice {
    public static final JDevice INSTANCE = new JDevice();

    public boolean enabledAutoTime(Context context) {
        try {
            if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                return Settings.Global.getInt(context.getContentResolver(), Settings.Global.AUTO_TIME) > 0;
            } else {
                return Settings.System.getInt(context.getContentResolver(), Settings.System.AUTO_TIME) > 0;
            }
        } catch (Settings.SettingNotFoundException e) {
            return false;
        }
    }
}
