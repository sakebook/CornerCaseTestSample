package com.sakebook.android.sample.cornercasetestsample;

import android.content.Context;

import org.jetbrains.annotations.NotNull;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

/**
 * Created by sakemotoshinya on 2017/08/18.
 */

@Implements(KJDevice.class)
public class ShadowKJDevice {

    @Implementation
    public final static boolean enabledAutoTime(@NotNull Context context) {
        return true;
    }
}
