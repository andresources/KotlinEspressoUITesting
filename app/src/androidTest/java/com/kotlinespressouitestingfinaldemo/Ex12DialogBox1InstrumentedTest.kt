package com.kotlinespressouitestingfinaldemo
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class Ex12DialogBox1InstrumentedTest {
    @Test
    fun test_showDialog_confirmVisible() {
        val activityScenario = ActivityScenario.launch(Ex12DialogBox1Activity::class.java)
        onView(withId(R.id.btnShowDialog)).perform(click())
        onView(withText("This is title")).check(matches(isDisplayed()))
        onView(withText("Yes")).perform(click())
        onView(withText("This is title")).check(doesNotExist())
        onView(withId(R.id.btnShowDialog)).check(matches(isDisplayed()))
    }
}