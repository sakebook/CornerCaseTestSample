package com.sakebook.android.sample.cornercasetestsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val textView: TextView by lazy { findViewById(R.id.text) as TextView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showTicketPrice()
    }

    private fun showTicketPrice() {
        val ticket = MovieTicket()
        textView.text = "Today's price: ${ticket.purchasePrice(this)}円"
    }
}
