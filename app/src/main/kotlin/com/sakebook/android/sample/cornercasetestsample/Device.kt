package com.sakebook.android.sample.cornercasetestsample

import android.content.Context
import android.os.Build
import android.provider.Settings

/**
 * Created by sakemotoshinya on 2017/08/09.
 */
object Device {
    /**
     * 端末の日付の設定を自動にしているかどうか。
     * */
    fun enabledAutoTime(context: Context): Boolean {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                return Settings.Global.getInt(context.contentResolver, Settings.Global.AUTO_TIME) > 0
            } else {
                return Settings.System.getInt(context.contentResolver, Settings.System.AUTO_TIME) > 0
            }
        } catch (e: Settings.SettingNotFoundException) {
            return false
        }
    }

}