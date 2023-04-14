package com.kotlinespressouitestingfinaldemo
import android.widget.AdapterView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.kotlinespressouitestingfinaldemo.CustomMatchers.withBookAuthor
import com.kotlinespressouitestingfinaldemo.CustomMatchers.withBookTitle
import com.kotlinespressouitestingfinaldemo.adapters.RecyclerBooksAdapter
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4ClassRunner::class)
class Ex17ViewPagerInstumentedTest {
    private val BOOK_TITLE = "Clean Code"
    private val BOOK_AUTHOR = "Robert C. Martin"
    @Before
    fun setUp(){
        val activityScenario = ActivityScenario.launch(Ex17ViewPagerActivity::class.java)
    }
    @Test
    fun testAllTabDisplayedOnSwipe(){
        onView(withId(R.id.pager)).perform(swipeLeft())
        onView(allOf(withText("ALL BOOKS"), isDisplayed())).check(matches(withText("ALL BOOKS")))
        onData(allOf(withBookTitle(BOOK_TITLE), withBookAuthor(BOOK_AUTHOR))).inAdapterView(allOf(isAssignableFrom(AdapterView::class.java), isDisplayed()))
        onData(allOf(withBookTitle(BOOK_TITLE))).perform(click())
        // Check the correct book title is displayed
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)));

        // Check the correct author is displayed
       // onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)));
    }
}