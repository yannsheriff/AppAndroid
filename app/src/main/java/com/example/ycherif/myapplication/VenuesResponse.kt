package com.example.ycherif.myapplication

/**
 * Created by ycherif on 15/11/2017.
 */

class VenuesResponse(val response: NestedResponse) {
    class NestedResponse(val venues : List<Venue>){}
}