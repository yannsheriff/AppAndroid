package com.example.ycherif.myapplication

/**
 * Created by ycherif on 16/11/2017.
 */


class VenueResponse(val response: NestedResponse) {
    class NestedResponse(val venue : SingleVenue){}
}