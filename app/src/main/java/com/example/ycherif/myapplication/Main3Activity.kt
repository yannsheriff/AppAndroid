package com.example.ycherif.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.squareup.moshi.Moshi

import kotlinx.android.synthetic.main.activity_main3.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        setSupportActionBar(toolbar)

        val recycleView : RecyclerView = findViewById(R.id.recyclerView)
        recycleView.layoutManager = LinearLayoutManager(this)




        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        fun handleJson(json:String) {
            val moshi = Moshi.Builder().build()
            val adapter = moshi.adapter(VenuesResponse::class.java)
            val venuResponse = adapter.fromJson(json)
            if (venuResponse != null) {
                val venues = venuResponse.response.venues
                runOnUiThread {
                    recycleView.adapter = VenueAdapter(venues, { id ->
                            val intent : Intent = Intent(this, SingleVenueActivity::class.java)
                                    .putExtra("id", id)
                            startActivity(intent)
                    })
                }
            }
        }

        val venueUrl : String = "https://api.foursquare.com/v2/venues/search?client_id=OY0ZDAZNN3RPAYZ1ZASMOABE0LBZCNUX0TGTTD0ZP5LZ1DKM&client_secret=5YTIR2A34SITAL2HBB04ZAZJFRXUGNCNO4KYN3PSV5UHOKAR&v=20170801&near=Paris&limit=10"
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
                    handleJson(json!!)
                }

            }
        })
    }

    class VenueAdapter(val venues : List<Venue>,
                       val venueCallback: ((String) -> Unit)) : RecyclerView.Adapter<VenueAdapter.VenueViewHolder> () {



        override fun getItemCount(): Int = venues.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueViewHolder {

            val context = parent.context
            val layoutInflater = LayoutInflater.from(context)
            val view : View = layoutInflater.inflate(R.layout.activity_venue_item, parent, false)
            return  VenueViewHolder(view)

        }

        override fun onBindViewHolder(holder: VenueViewHolder, position: Int) {
            val nameView = holder.itemView.findViewById<TextView>(R.id.name)
            val context = holder.itemView.context

            val (id, name, location) = venues[position]

            holder.nameView.text = name
            holder.addresseView.text = location.address
            holder.itemView.setOnClickListener {
                venueCallback?.invoke(id)
            }

        }


        class VenueViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
            val nameView : TextView = view.findViewById(R.id.name)
            val addresseView : TextView = view.findViewById(R.id.adresse)
        }



    }




}
