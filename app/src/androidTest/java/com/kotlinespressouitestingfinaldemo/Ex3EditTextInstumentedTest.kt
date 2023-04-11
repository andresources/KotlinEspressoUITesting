package com.kotlinespressouitestingfinaldemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Ex3EditTextInstumentedTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(Ex3_EditTextActivity::class.java)
    @Test
    fun checkEnteredData(){
        onView(withId(R.id.etName)).perform(typeText("KSR"))
        onView(withId(R.id.btnSubmit)).perform(click())
        //onView(withId(R.id.etName)).check(matches(withText("Bhav")))
        onView(withId(R.id.etName)).check(matches(withText(containsString("av"))))
    }
}