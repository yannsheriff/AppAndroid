package com.example.ycherif.myapplication

/**
 * Created by ycherif on 15/11/2017.
 */


data class Venue  (val id: String, val name : String, val location : Location) {
    data class Location(val address : String){}
}