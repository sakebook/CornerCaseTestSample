package com.sakebook.android.sample.cornercasetestsample;

import android.content.Context;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * Created by sakemotoshinya on 2017/08/11.
 */

@RunWith(RobolectricTestRunner.class)
@Config(packageName = "com.sakebook.android.sample.cornercasetestsample", constants = BuildConfig.class, sdk = {21})
public class JMovieTicketTest {

    Context context;

    @Before
    public void setup() throws Exception {
        context = RuntimeEnvironment.application;
    }

    @Test
    public void フィールドには代入できる() throws Exception {
        JMovieTicket mock = Mockito.mock(JMovieTicket.class);
        Assert.assertNull(mock.memo); // nullになる

        mock.memo = "test memo";
        Assert.assertNotNull(mock.memo); // 代入されるのでNullにはならない
    }
}
