package com.kotlinespressouitestingfinaldemo
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kotlinespressouitestingfinaldemo.CustomMatchers.withAdaptedData
import com.kotlinespressouitestingfinaldemo.CustomMatchers.withItemContent
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test


class Ex6SpinnerInstrumentedTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(Ex6_SpinnerActivity::class.java)

    @Test
    fun spinnerTest1(){
        onView(withId(R.id.spLang)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.spLang)).check(matches(withSpinnerText(containsString("Te"))));
    }
    @Test
    fun spinnerTest2(){
        onView(withId(R.id.spLang)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("Telugu"))).perform(click())
        onView(withId(R.id.spLang)).check(matches(withSpinnerText(containsString("Te"))))
    }

    @Test
    fun spinnerTest3(){
        onView(withId(R.id.spLang)).perform(click())
        onView(withText("Telugu")).perform(click())
    }

    @Test
    fun testLanguageNotInList() {
        val INVALID_LANG_NAME = "Urdu"
        onView(withId(R.id.spLang)).check(matches(not(withAdaptedData(withItemContent(INVALID_LANG_NAME)))))
    }
    @Test
    fun testDataItemNotInAdapter() {
        onView(withId(R.id.spLang))
            .check(matches(not(withAdaptedData(withItemContent("Telugu1")))))
    }

}