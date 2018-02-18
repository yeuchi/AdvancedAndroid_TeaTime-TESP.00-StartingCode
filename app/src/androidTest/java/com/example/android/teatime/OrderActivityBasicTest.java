package com.example.android.teatime;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
/**
 * Created by ctyeung on 2/7/18.
 */



// TODO (8-19 1) Add annotation to specify AndroidJUnitRunner class as the default test runner
@RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest
{
    @Rule public ActivityTestRule<OrderActivity> mActivityTestRule
            = new ActivityTestRule<>(OrderActivity.class);

    // TODO (8-19 2) Add the rule that provides functional testing of a single activity

    // TODO (8-19 3) Finish writing this test which will:
    //          - Check that the initial quantity is zero
    //          - Click on the decrement button
    //          - Verify that the decrement button won't decrease the quantity 0 and cost below $0.00
    @Test
    public void clickDecrementButton_ChangesQuantityAndCost()
    {
        onView((withId(R.id.quantity_text_view))).check(matches(withText("0")));

        onView((withId(R.id.decrement_button))) // 1. find the view
                .perform(click());              // 2. perform action

        // 3. check result behaviors
        String str = onView((withId(R.id.quantity_text_view))).toString();
        onView((withId(R.id.quantity_text_view))).check(matches(withText("0")));
        onView((withId(R.id.cost_text_view))).check(matches(withText("$0.00")));
    }

    @Test
    public void clickIncrementButton_ChangesQuantityAndCost()
    {
        onView((withId(R.id.increment_button))) // 1. find the view
                .perform(click());              // 2. perform action

        // 3. check result behaviors
        onView((withId(R.id.quantity_text_view))).check(matches(withText("1")));
        onView((withId(R.id.cost_text_view))).check(matches(withText("$5.00")));
    }
}
