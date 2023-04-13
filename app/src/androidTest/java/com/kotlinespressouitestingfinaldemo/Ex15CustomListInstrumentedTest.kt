package com.kotlinespressouitestingfinaldemo
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.kotlinespressouitestingfinaldemo.CustomMatchers.*
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class Ex15CustomListInstrumentedTest {


    @Before
    fun setUp(){
        val activityScenario = ActivityScenario.launch(Ex15CustomListViewActivity::class.java)
    }

    @Test
    open fun testOpenBookById() {
        // Click on the Book with ID 5
        onData(withBookId(5)).perform(click())

        // Check the correct book title is displayed
        onView(withId(R.id.book_title)).check(matches(withText(Companion.BOOK_TITLE)))

        // Check the correct author is displayed
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)))
    }

    companion object {
        private const val BOOK_TITLE = "Java Concurrency in Practice"
        private const val BOOK_AUTHOR = "Brian Goetz"
    }

    @Test
    fun testOpenBookByTitleAndAuthor() {
        // Match a book with a specific title and author name
        onData(allOf(withBookTitle(BOOK_TITLE), withBookAuthor(BOOK_AUTHOR))).perform(click())

        // Check the correct book title is displayed
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)))

        // Check the correct author is displayed
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)))
    }

    @Test
    fun testClickOnBookByPosition() {
        onData(anything()).atPosition(5).perform(click())
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)))
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)))
    }
}