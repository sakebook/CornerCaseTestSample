package com.sakebook.android.sample.cornercasetestsample

import android.content.Context
import org.joda.time.DateTime
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
    fun mockだとプロパティの変更ができない() {
        val mock = Mockito.mock(MovieTicket::class.java)
        Assert.assertNull(mock.memo) // nullになる

        mock.memo = "test memo"
        Assert.assertNull(mock.memo) // 代入してもnullになる
    }

    @Test
    @Throws(Exception::class)
    fun mockでプロパティを変更するにはCALLS_REAL_METHODSが必要() {
        val mockWithOption = Mockito.mock(MovieTicket::class.java, Mockito.CALLS_REAL_METHODS)
        Assert.assertNull(mockWithOption.memo) // nullになる

        val memo = "test memo"
        mockWithOption.memo = memo
        Assert.assertEquals(memo, mockWithOption.memo) // test memoが代入されてる
    }

    @Test
    @Throws(Exception::class)
    fun mockでもwhenでメソッドを置き換えることはできる() {
        val mock = Mockito.mock(Ticket::class.java)
        Assert.assertNull(mock.memo) // nullになる

        val memo = "test memo"
        Mockito.`when`(mock.memo).thenReturn(memo) // メソッドの返り値を置き換えている
        Assert.assertEquals(memo, mock.memo)
    }

    @Test
    @Throws(Exception::class)
    fun spyが使えればシンプル() {
        val spy = Mockito.spy(MovieTicket())
        Assert.assertNotNull(spy.memo) // コンストラクタで初期化されてる

        val memo = "test memo"
        spy.memo = memo
        Assert.assertEquals(memo, spy.memo) // test memoが代入されてる
    }

    @Test
    @Throws(Exception::class)
    fun 端末時間が不正だと割高になる() {
        val movieTicket = MovieTicket(purchaseDateTime = DateTime().withHourOfDay(18))
        val spy = Mockito.spy(movieTicket)
        Assert.assertEquals(2000, spy.purchasePrice(context))
    }

    @Test
    @Throws(Exception::class)
    @Config(shadows = arrayOf(ShadowDevice::class))
    fun 端末時間が正常の場合時間帯に寄って価格が変わる() {
        val movieTicket = MovieTicket(purchaseDateTime = DateTime().withHourOfDay(18))
        val spy = Mockito.spy(movieTicket)
        Assert.assertEquals(1800, spy.purchasePrice(context))

        val discountMovieTicket = MovieTicket(purchaseDateTime = DateTime().withHourOfDay(0))
        val spyDiscountMovieTicket = Mockito.spy(discountMovieTicket)
        Assert.assertEquals(1300, spyDiscountMovieTicket.purchasePrice(context))

    }
}
