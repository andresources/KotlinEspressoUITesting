package com.kotlinespressouitestingfinaldemo

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class RegistrationInstrumentedTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(RegistrationActivity::class.java)

    @Test
    fun signupTest(){
        onView(withHint("Enter First Name")).perform(typeText("Krishna Sai"))
        onView(withId(R.id.etLastName)).perform(typeText("Reddy"))
        onView(withId(R.id.spLang)).perform(click())
        onView(withText("English")).perform(click())
        onView(withId(R.id.rbMale)).perform(click())
        onView(withId(R.id.etUserName)).perform(typeText("ksr123"))
        onView(withId(R.id.etPassword)).perform(typeText("123"))
        Thread.sleep(3000)
        onView(withId(R.id.btnSubmit)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.tvDetails)).check(ViewAssertions.matches(withText("Welcome ksr123")))
    }
}