package com.example.calculatorv2


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import com.example.calculatorv2.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun navigationTest() {
        val bottomNavigationItemView = onView(
allOf(withId(R.id.navigation_home), withContentDescription("Home"),
childAtPosition(
childAtPosition(
withId(R.id.nav_view),
0),
0),
isDisplayed()))
        bottomNavigationItemView.perform(click())
        
        val bottomNavigationItemView2 = onView(
allOf(withId(R.id.navigation_dashboard), withContentDescription("Dashboard"),
childAtPosition(
childAtPosition(
withId(R.id.nav_view),
0),
1),
isDisplayed()))
        bottomNavigationItemView2.perform(click())
        
        val bottomNavigationItemView3 = onView(
allOf(withId(R.id.navigation_notifications), withContentDescription("Notifications"),
childAtPosition(
childAtPosition(
withId(R.id.nav_view),
0),
2),
isDisplayed()))
        bottomNavigationItemView3.perform(click())
        
        val bottomNavigationItemView4 = onView(
allOf(withId(R.id.navigation_home), withContentDescription("Home"),
childAtPosition(
childAtPosition(
withId(R.id.nav_view),
0),
0),
isDisplayed()))
        bottomNavigationItemView4.perform(click())
        
        val textView = onView(
allOf(withId(R.id.text_home), withText("This is home Fragment"),
withParent(withParent(withId(R.id.nav_host_fragment_activity_main))),
isDisplayed()))
        textView.check(matches(withText("This is home Fragment")))
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
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
