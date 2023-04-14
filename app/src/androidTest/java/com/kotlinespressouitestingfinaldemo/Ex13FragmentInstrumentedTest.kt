package com.kotlinespressouitestingfinaldemo

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class Ex13FragmentInstrumentedTest {
    //private lateinit var scenario: FragmentScenario<Ex13MyFragment>

   /* @Before
    fun setup() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_KotlinEspressoUITestingFinalDemo)
        scenario.moveToState(Lifecycle.State.STARTED)
    }*/
    @Test
    fun testViewExist() {
       val activityScenario = ActivityScenario.launch(Ex13FragmentActivity::class.java)
        onView(withId(R.id.btnSubmit)).perform(click())
        onView(withId(R.id.tv)).check(matches(isDisplayed()))
    }
}