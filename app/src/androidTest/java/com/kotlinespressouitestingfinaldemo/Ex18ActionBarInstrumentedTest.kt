package com.kotlinespressouitestingfinaldemo
import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.*
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
class Ex18ActionBarInstrumentedTest {
    @Before
    @Throws(Exception::class)
    fun setUp(){
        val activityScenario = ActivityScenario.launch(Ex18ActionBarActivity::class.java)
        setFailureHandler(CustomFailureHandler(
            ApplicationProvider.getApplicationContext<Context>()))
    }



    @Test
    fun checkSetting(){
        // Click on the icon - we can find it by the r.Id.
        onView(withId(R.id.action_settings))
            .perform(click())

        // Verify that we have really clicked on the icon
        // by checking the TextView content.
        onView(withId(R.id.textView))
            .check(matches(withText("Settings")))
    }
    @Test
    fun checkAction(){
        openContextualActionModeOverflowMenu()
        onView(withText("About"))
            .perform(click())

        // Verify that we have really clicked on the icon
        // by checking the TextView content.
        onView(withId(R.id.textView))
            .check(matches(withText("About")))
    }
}