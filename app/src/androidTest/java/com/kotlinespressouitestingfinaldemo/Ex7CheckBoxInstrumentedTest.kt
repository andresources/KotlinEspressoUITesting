package com.kotlinespressouitestingfinaldemo
import android.os.IBinder
import android.view.WindowManager
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Root
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Description
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
class Ex7CheckBoxInstrumentedTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(Ex7_CheckBoxActivity::class.java)

    @Test
    fun testCheckboxChecked(){
        //onView(withId(R.id.cb1)).check(matches(not(isChecked())));
        onView(withId(R.id.cb1)).check(matches(isNotChecked())).perform(click()).check(matches(isChecked()));
    }
}