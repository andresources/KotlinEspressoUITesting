package com.kotlinespressouitestingfinaldemo

import android.widget.DatePicker
import android.widget.TimePicker
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class Ex14DateTimePickerInstumentedTest {
    @Before
    fun setUp(){
        val activityScenario = ActivityScenario.launch(Ex14DateTimePickerActivity::class.java)
    }
    @Test
    fun testDate() {
        val year = 2020
        val month = 11
        val day = 15

        onView(withId(R.id.date_picker_button)).perform(click())
        onView(withClassName(Matchers.equalTo(DatePicker::class.java.getName()))).perform(PickerActions.setDate(year, month + 1, day))
        onView(withId(android.R.id.button1)).perform(click())

        onView(withId(R.id.status)).check(matches(withText("$year/$month/$day")))
    }
    @Test
    fun testTime() {
        val hour = 10
        val minutes = 59
        onView(withId(R.id.time_picker_button)).perform(click())
        onView(withClassName(Matchers.equalTo(TimePicker::class.java.getName()))).perform(
            PickerActions.setTime(hour, minutes)
        )
        onView(withId(android.R.id.button1)).perform(click())
        onView(withId(R.id.status)).check(matches(withText("$hour:$minutes")))
    }
}