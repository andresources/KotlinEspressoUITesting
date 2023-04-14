package com.kotlinespressouitestingfinaldemo

import androidx.test.espresso.idling.CountingIdlingResource

object CountingIdlingResourceSingleton {
    private val RESOURCE = "GLOBAL"

    @JvmField val countingIdlingResource = CountingIdlingResource(RESOURCE)

    public fun increment() {
        countingIdlingResource.increment()
    }

    public fun decrement() {
        if (!countingIdlingResource.isIdleNow) {
            countingIdlingResource.decrement()
        }
    }
}