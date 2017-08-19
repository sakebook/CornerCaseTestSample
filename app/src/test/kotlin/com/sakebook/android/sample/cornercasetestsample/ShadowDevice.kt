package com.sakebook.android.sample.cornercasetestsample

import android.content.Context
import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements

/**
 * Created by sakemotoshinya on 2017/08/10.
 */
@Implements(Device::class)
class ShadowDevice {

    companion object {
        @JvmStatic // Robolectricで動かすために必要。
        @Implementation
        fun enabledAutoTime(context: Context): Boolean {
            return true
        }
    }
}