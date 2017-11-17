package com.example.ycherif.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.moshi.Moshi
import okhttp3.*
import java.io.IOException

class SingleVenueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_venue)

        val intent = intent
        val id = intent.getStringExtra("id")

        val venueUrl : String = "https://api.foursquare.com/v2/venues/"+ id +"?client_id=OY0ZDAZNN3RPAYZ1ZASMOABE0LBZCNUX0TGTTD0ZP5LZ1DKM&client_secret=5YTIR2A34SITAL2HBB04ZAZJFRXUGNCNO4KYN3PSV5UHOKAR&v=20170801"

        val client = OkHttpClient()
        val request = Request.Builder()
                .url(venueUrl)
                .build()

        val response = client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call?, response: Response?) {
                val json : String? = response!!.body()?.string()

                if(!json.isNullOrEmpty()) {

                    val moshi = Moshi.Builder().build()
                    val adapter = moshi.adapter(VenueResponse::class.java)
                    val venuResponse = adapter.fromJson(json)

                    if (venuResponse != null) {
                        val singleVenue = venuResponse.response.venue
                        runOnUiThread {

                        }
                    }
                }

            }
        })
    }


}
