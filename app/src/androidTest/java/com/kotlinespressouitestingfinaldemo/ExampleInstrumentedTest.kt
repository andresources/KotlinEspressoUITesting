package com.kotlinespressouitestingfinaldemo

import android.view.View
import android.widget.EditText
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
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun buttonClick(){
        onView(withId(R.id.german)).perform(click())
        onView(withId(R.id.preferred_language)).check(matches(withText("German")))
        onView(withId(R.id.english)).perform(click())
        onView(withId(R.id.preferred_language)).check(matches(withText("English")))
    }

    @Test
    fun emailIsEmpty() {
        onView(withId(R.id.tv_email)).perform(clearText())
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.tv_email)).check(matches(withError("This field is required")))
    }



    fun withError(expected: String) : Matcher<View>{
        return object : TypeSafeMatcher<View>(){
            override fun describeTo(description: Description?) {
                description?.appendText("Not found error message" + expected + ", find it!");
            }
            override fun matchesSafely(item: View?): Boolean {
                return if (item is EditText) {
                    (item as EditText).error.toString().equals(expected)
                } else false
            }
        }
    }


}