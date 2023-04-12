package com.kotlinespressouitestingfinaldemo
import android.os.IBinder
import android.view.WindowManager
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Root
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Description
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
class Ex6SpinnerInstrumentedTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(Ex6_SpinnerActivity::class.java)

    @Test
    fun spinnerTest(){
        onView(withId(R.id.spLang)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.spLang)).check(matches(withSpinnerText(containsString("Te"))));
    }
}