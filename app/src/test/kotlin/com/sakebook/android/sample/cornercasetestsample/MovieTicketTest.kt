package com.sakebook.android.sample.cornercasetestsample

import android.content.Context
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Created by sakemotoshinya on 2017/08/10.
 */
@RunWith(RobolectricTestRunner::class)
@Config(packageName = "com.sakebook.android.sample.cornercasetestsample", constants = BuildConfig::class, sdk = intArrayOf(21))
class MovieTicketTest {

    lateinit var context: Context

    @Before
    @Throws(Exception::class)
    fun setup() {
        context = RuntimeEnvironment.application
    }


    @Test
    @Throws(Exception::class)
    fun 抽象クラスのmockは変更が反映されない() {
        val mock = Mockito.mock(MovieTicket::class.java)
        Assert.assertNull(mock.memo) // nullになる

        mock.memo = "test memo"
        Assert.assertNull(mock.memo) // 代入してもnullになる
    }

    @Test
    @Throws(Exception::class)
    fun 抽象クラスのmockはCALLS_REAL_METHODSが必要() {
        val mockWithOption = Mockito.mock(MovieTicket::class.java, Mockito.CALLS_REAL_METHODS)
        Assert.assertNull(mockWithOption.memo) // nullになる

        val memo = "test memo"
        mockWithOption.memo = memo
        Assert.assertEquals("Mockito.CALLS_REAL_METHODSを利用したのに反映されてない", memo, mockWithOption.memo)
    }

    @Test
    @Throws(Exception::class)
    fun 抽象クラスでもwhenで置き換えることはできる() {
        val memo = "test memo"
        val mock = Mockito.mock(MovieTicket::class.java)
        Mockito.`when`(mock.memo).thenReturn(memo)
        Assert.assertEquals("Mockito.`when`で置き換えできていない", memo, mock.memo)
    }

    @Test
    @Throws(Exception::class)
    fun spyが使えればシンプル() {
        val spy = Mockito.spy(MovieTicket())
        Assert.assertEquals("初期化されていない", "memo", spy.memo)
    }

    @Test
    @Throws(Exception::class)
    fun 端末時間が不正だと割高になる() {
        val movieTicket = Mockito.spy(MovieTicket())
        Assert.assertEquals("aa", 2000, movieTicket.purchasePrice(context))
    }

    @Test
    @Throws(Exception::class)
    @Config(shadows = arrayOf(ShadowDevice::class))
    fun 端末時間が正常() {
        val movieTicket = Mockito.spy(MovieTicket())
        Assert.assertEquals("aa", 1800, movieTicket.purchasePrice(context))
    }
}
