package com.example.android.teatime;

/**
 * Created by ctyeung on 2/12/18.
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.*;
/**
 * This test demos a user clicking on a GridView item in MenuActivity which opens up the
 * corresponding OrderActivity.
 *
 * This test does not utilize Idling Resources yet. If idling is set in the MenuActivity,
 * then this test will fail. See the IdlingResourcesTest for an identical test that
 * takes into account Idling Resources.
 */


// TODO (8-19 1) Add annotation to specify AndroidJUnitRunner class as the default test runner
@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest
{
    // TODO (8-19 2) Add the rule that provides functional testing of a single activity
    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule
            = new ActivityTestRule<>(MenuActivity.class);

    // TODO (8-19 3) Finish writing this test which will click on a gridView Tea item and verify that
    // the OrderActivity opens up with the correct tea name displayed.
    @Test
    public void clickGridViewItem_OpensOrderActivity()
    {
        //https://stackoverflow.com/questions/28067738/espresso-click-an-image-inside-a-gridview
        onData(anything()).inAdapterView(withId(R.id.tea_grid_view))
                .atPosition(0)
                .onChildView(withId(R.id.image))
                .perform(click());

        onView((withId(R.id.customize)))
                .check(matches(withText("Customizations")));

        onView((withId(R.id.tea_name_text_view)))
                .check(matches(withText("Black Tea")));
    }

}
