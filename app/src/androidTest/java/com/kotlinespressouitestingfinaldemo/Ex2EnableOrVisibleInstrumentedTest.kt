package com.kotlinespressouitestingfinaldemo

import androidx.test.core.app.ActivityScenario
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
        //val activityScenario = ActivityScenario.launch(Ex2_EnableOrVisibleActivity::class.java)
        //onView(withId(R.id.btn)).perform(click())//match by ID

        onView(withId(R.id.btn)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.tv)).check(matches(isDisplayed())) //Expected o/p textview visible
        Thread.sleep(3000)
        /*onView(allOf(withId(R.id.btn), withText("Click Button"))).perform(click())
        onView(withId(R.id.tv)).check(matches(isDisplayed()))*/
       /* onView(withId(R.id.tv))
                   .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))*/
    }
}