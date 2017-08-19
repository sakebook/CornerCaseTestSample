package com.sakebook.android.sample.cornercasetestsample;

/**
 * Created by sakemotoshinya on 2017/08/19.
 */

import android.content.Context;

import org.jetbrains.annotations.NotNull;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@Implements(JDevice.class)
public class ShadowJDevice {

    @Implementation
    public boolean enabledAutoTime(@NotNull Context context) {
        return true;
    }
}
