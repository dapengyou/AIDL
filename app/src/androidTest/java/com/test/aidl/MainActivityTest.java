package com.test.aidl;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Before
    public void setUp() throws Exception {

    }
    @Rule
    public ActivityTestRule<MainActivity> rule=new ActivityTestRule<MainActivity>(MainActivity.class,true);

    @Test
    public void add_result() {
//        输入两个数字
        onView(withId(R.id.et_num1)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.et_num2)).perform(typeText("89"), closeSoftKeyboard());
//        点击按钮
        onView(withId(R.id.button)).perform(click());
//        检查textview显示状态
        onView(withId(R.id.textview)).check(matches(isDisplayed()));
    }
}