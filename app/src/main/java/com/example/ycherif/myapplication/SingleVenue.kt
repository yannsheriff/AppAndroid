package com.example.ycherif.myapplication

/**
 * Created by ycherif on 16/11/2017.
 */

data class SingleVenue (val name: String, val contact: Contact, val location : Location, val description : String) {
    data class Contact (val phone: String) {}
    data class Location(val address : String){}
}