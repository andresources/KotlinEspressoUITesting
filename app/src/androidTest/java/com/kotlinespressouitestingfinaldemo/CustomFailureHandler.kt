package com.kotlinespressouitestingfinaldemo

import android.content.Context
import android.view.View
import androidx.test.espresso.FailureHandler
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.base.DefaultFailureHandler
import org.hamcrest.Matcher

 class CustomFailureHandler(targetContext: Context) : FailureHandler {
    private val delegate: FailureHandler

    init {
        delegate = DefaultFailureHandler(targetContext)
    }

    override fun handle(error: Throwable, viewMatcher: Matcher<View>) {
        try {
            delegate.handle(error, viewMatcher)
        } catch (e: Exception) {
            throw MySpecialException("Text field not present")
        }

    }
}