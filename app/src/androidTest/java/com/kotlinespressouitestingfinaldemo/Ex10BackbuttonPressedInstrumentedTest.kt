package com.kotlinespressouitestingfinaldemo
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class Ex10BackbuttonPressedInstrumentedTest {
    @Test
    fun test_navSecondaryActivity() {
        val activityScenario = ActivityScenario.launch(Ex10BackbuttonPressedActivity::class.java)
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.button_back)).check(matches(isDisplayed()))
    }

    @Test
    fun test_backPress_toMainActivity() {
        val activityScenario = ActivityScenario.launch(Ex10BackbuttonPressedActivity::class.java)

        onView(withId(R.id.button_next_activity)).perform(click())

        onView(withId(R.id.button_back)).check(matches(isDisplayed()))

        onView(withId(R.id.button_back)).perform(click()) // method 1

        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))

        onView(withId(R.id.button_next_activity)).perform(click())

        pressBack() // Device Back Button
        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
    }

}