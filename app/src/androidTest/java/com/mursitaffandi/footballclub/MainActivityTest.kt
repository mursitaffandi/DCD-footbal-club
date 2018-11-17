package com.mursitaffandi.footballclub

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.doesNotExist
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import com.mursitaffandi.footballclub.R.id.*
import com.mursitaffandi.footballclub.entity.league.League
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.core.IsInstanceOf
import android.support.test.espresso.Espresso.onData
import org.hamcrest.Matchers.*


/**
 * Created by mursitaffandi on 7/27/18.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun behaviorTest(){
        Espresso.onView(ViewMatchers.withId(bnav_match)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(3000)

        val recyclerView = onView(
                allOf(withId(R.id.ui_listmatch),
                        isDisplayed()))


        recyclerView.check(matches(isDisplayed()))
        recyclerView
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(7, ViewActions.click()))
        Thread.sleep(3000)
        Espresso.onView(ViewMatchers.withId(img_home)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(add_to_favorite)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("Added to favorite"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.pressBack()

        Espresso.onView(ViewMatchers.withId(bnav_favorite)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(click())
        recyclerView.check(matches(isDisplayed()))
        recyclerView
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))

        Espresso.onView(ViewMatchers.withId(add_to_favorite)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("Removed from favorite"))
        Espresso.pressBack()
        val linearLayout = onView(
                allOf<View>(childAtPosition(
                        allOf<View>(withId(cv_match),
                                childAtPosition(
                                        withId(ui_listmatch),
                                        0)),
                        0),
                        isDisplayed()))
        linearLayout.check(doesNotExist())




    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return (parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position))
            }
        }
    }

}