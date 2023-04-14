package com.kotlinespressouitestingfinaldemo
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.kotlinespressouitestingfinaldemo.adapters.RecyclerBooksAdapter
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class Ex20CountingIdlingResourcesInstumentedTest {

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(CountingIdlingResourceSingleton.countingIdlingResource)
    }
    @Test
    fun testIdlingResources(){
        val activityScenario = ActivityScenario.launch(Ex20CountingIdlingResourcesActivity::class.java)
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.tvWelcome)).check(matches(isDisplayed()))
    }
    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(CountingIdlingResourceSingleton.countingIdlingResource)
    }
}