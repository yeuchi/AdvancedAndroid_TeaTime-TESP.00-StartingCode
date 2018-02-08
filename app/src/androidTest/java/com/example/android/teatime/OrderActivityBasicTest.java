package com.example.android.teatime;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * Created by ctyeung on 2/7/18.
 */

@RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {
    @Rule public ActivityTestRule<OrderActivity> mActivityTestRule
            = new ActivityTestRule<>(OrderActivity.class);
}
