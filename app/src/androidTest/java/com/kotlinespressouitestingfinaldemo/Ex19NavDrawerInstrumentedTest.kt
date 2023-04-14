package com.kotlinespressouitestingfinaldemo
import android.content.Context
import android.view.Gravity
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.kotlinespressouitestingfinaldemo.adapters.RecyclerBooksAdapter
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class Ex19NavDrawerInstrumentedTest {
    @Before
    fun setUp(){
        val activityScenario = ActivityScenario.launch(Ex19NavigationDrawerActivity::class.java)
    }

    @Test
    fun checkClosedNav(){
        onView(withId(R.id.my_drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
    }
    @Test
    fun openNav(){
        onView(withId(R.id.my_drawer_layout))
            .check(matches(isClosed(Gravity.LEFT))).perform(DrawerActions.open())
        onView(withId(R.id.nav_account)).perform(click())
        onView(withId(R.id.tvMenu)).check(matches(withText("My Account")))
    }

}