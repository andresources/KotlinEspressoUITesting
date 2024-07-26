package com.kotlinespressouitestingfinaldemo

import android.view.View
import android.widget.EditText
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class Ex1ButtonClickInstrumentedTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(Ex1_ButtonClickActivity::class.java)

    @Test
    fun englishButtonClicked(){
        //Here
        // withId(R.id.my_view) is a 1.ViewMatcher
        // click() is a 2.ViewAction
        // matches(withText("English")) is a 3.ViewAssertion
        onView(withId(R.id.english))
            .perform(click())

        onView(withId(R.id.preferred_language))
            .check(matches(withText("English")))

        //activityScenarioRule.scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun frenchButtonClicked(){
        onView(withId(R.id.french))
            .perform(click())

        onView(withId(R.id.preferred_language))
            .check(matches(withText("French")))
    }

    @Test
    fun germanButtonClicked(){
        onView(withId(R.id.german))
            .perform(click())

        onView(withId(R.id.preferred_language))
            .check(matches(withText("German")))
    }

    @Test
    fun hindiButtonClicked(){
        onView(allOf(withId(R.id.hindi), withText("Hindi")))
            .perform(click())

        onView(withId(R.id.preferred_language))
            .check(matches(withText("Hindi")))
    }
}