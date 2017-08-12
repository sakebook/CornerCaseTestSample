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
 * Created by sakemotoshinya on 2017/08/12.
 */

@RunWith(RobolectricTestRunner.class)
@Config(packageName = "com.sakebook.android.sample.cornercasetestsample", constants = BuildConfig.class, sdk = {21})
public class KJMovieTicketTest {

    Context context;

    @Before
    public void setup() throws Exception {
        context = RuntimeEnvironment.application;
    }

    @Test
    public void 抽象クラスのmockは変更が反映されない() throws Exception {
        KJMovieTicket mock = Mockito.mock(KJMovieTicket.class);
        Assert.assertNull(mock.getMemo()); // nullになる

        mock.setMemo("test memo");
        Assert.assertNull(mock.getMemo()); // 代入してもnullになる
    }


    @Test
    public void 抽象クラスのmockはCALLS_REAL_METHODSが必要() throws Exception {
        KJMovieTicket mock = Mockito.mock(KJMovieTicket.class, Mockito.CALLS_REAL_METHODS);
        Assert.assertNull(mock.getMemo()); // nullになる

        String memo = "test memo";
        mock.setMemo(memo);
        Assert.assertEquals("Mockito.CALLS_REAL_METHODSを利用したのに反映されてない", memo, mock.getMemo());
    }

}
