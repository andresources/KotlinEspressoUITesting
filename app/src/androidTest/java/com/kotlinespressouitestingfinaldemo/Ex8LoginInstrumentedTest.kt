package com.kotlinespressouitestingfinaldemo


import android.os.IBinder
import android.view.WindowManager
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Root
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Description
import org.hamcrest.Matchers.not
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test

class Ex8LoginInstrumentedTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(Ex8_LoginActivity::class.java)

    @Test
    fun checkLoginSuccess(){
        onView(withId(R.id.etUserName)).perform(typeText("abc"))
        onView(withId(R.id.etPwd)).perform(typeText("123"))
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withText("Success"))
            .inRoot(Ex5ToastMessageInstrumentedTest.ToastMatcher().apply {
                matches(isDisplayed())
                //matches(not(isDisplayed())) Incase not equal to
            })
    }

    class ToastMatcher : TypeSafeMatcher<Root?>() {

        override fun matchesSafely(item: Root?): Boolean {
            val type: Int? = item?.windowLayoutParams?.get()?.type
            if (type == WindowManager.LayoutParams.FIRST_APPLICATION_WINDOW) {
                val windowToken: IBinder = item.decorView.windowToken
                val appToken: IBinder = item.decorView.applicationWindowToken
                if (windowToken === appToken) { // means this window isn't contained by any other windows.
                    return true
                }
            }
            return false
        }

        override fun describeTo(description: Description?) {
            description?.appendText("is toast")
        }
    }
}