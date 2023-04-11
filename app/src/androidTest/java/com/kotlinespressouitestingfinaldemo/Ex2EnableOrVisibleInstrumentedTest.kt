package com.kotlinespressouitestingfinaldemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Ex2EnableOrVisibleInstrumentedTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(Ex2_EnableOrVisibleActivity::class.java)

    @Test
    fun checkViewVisibility(){
        onView(allOf(withId(R.id.btn), withText("ClickMe"))).perform(click())
        onView(withId(R.id.tv)).check(matches(isDisplayed()))
    }
}