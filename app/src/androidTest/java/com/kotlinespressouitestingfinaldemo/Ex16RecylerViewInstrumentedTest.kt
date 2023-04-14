package com.kotlinespressouitestingfinaldemo
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.kotlinespressouitestingfinaldemo.adapters.RecyclerBooksAdapter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class Ex16RecylerViewInstrumentedTest {
    private val BOOK_TITLE = "Clean Code"
    private val BOOK_AUTHOR = "Robert C. Martin"
    @Before
    fun setUp(){
        val activityScenario = ActivityScenario.launch(Ex16RecylerViewActivity::class.java)
    }

    @Test
    fun checkItemExist(){
        // Perform a click on first element in the RecyclerView
        onView(withId(R.id.rv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerBooksAdapter.RowHolder>(0, click()))
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)));
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)));
    }

    @Test
    fun testClickOnViewInRow(){
        onView(withId(R.id.rv)).perform(RecyclerViewActions.actionOnItem<RecyclerBooksAdapter.RowHolder>(hasDescendant(withText(BOOK_TITLE)), click()));
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)));
    }

    @Test
    fun checkPositionItem(){
        try {
            onView(RecyclerViewMatcher(R.id.rv).atPosition(3)).check(
                matches(
                    hasDescendant(
                        withText(
                            "Joshua Bloch1"
                        )
                    )
                )
            )
        }catch (e:java.lang.Exception){
            throw  Exception("This test failed - " + e.message);
        }
    }
}