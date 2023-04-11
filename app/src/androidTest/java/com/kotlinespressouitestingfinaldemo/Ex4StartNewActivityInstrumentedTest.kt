package com.kotlinespressouitestingfinaldemo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Ex4StartNewActivityInstrumentedTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(Ex4_StartAnotherScreenFirstActivity::class.java)

    @Test
    fun startNewActivity(){
        onView(withId(R.id.etName)).perform(typeText("KSR"))
        onView(withId(R.id.btnClickMe)).perform(click())
        onView(withId(R.id.tvName)).check(matches(withText(equalToIgnoringCase("ksr"))))
    }
}