package com.fsck.k9.activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.fsck.k9.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ViewComponentNotVisibleFolder {

    @Rule
    public ActivityTestRule<Accounts> mActivityTestRule = new ActivityTestRule<>(Accounts.class);

    @Test
    public void viewComponentNotVisibleFolder() {
        ViewInteraction button = onView(
                allOf(withId(R.id.next), withText("Siguiente"), isDisplayed()));
        button.perform(click());

        ViewInteraction editText = onView(
                withId(R.id.account_email));
        editText.perform(scrollTo(), click());

        ViewInteraction editText2 = onView(
                withId(R.id.account_email));
        editText2.perform(scrollTo(), replaceText("misotest2017@gmail.com"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                withId(R.id.account_password));
        editText3.perform(scrollTo(), replaceText("pruebas2017*"), closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.next), withText("Siguiente"), isDisplayed()));
        button2.perform(click());

        ViewInteraction button3 = onView(
                allOf(withId(android.R.id.button2), withText("Continuar"), isDisplayed()));
        button3.perform(click());

        ViewInteraction button4 = onView(
                allOf(withId(android.R.id.button2), withText("Continuar"), isDisplayed()));
        button4.perform(click());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.account_description), withContentDescription("Elija un nombre para esta cuenta (opcional):")));
        editText4.perform(scrollTo(), replaceText("miso"), closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.account_name), withContentDescription("Introduzca su nombre (se verá en los mensajes salientes):")));
        editText5.perform(scrollTo(), replaceText("Miso"), closeSoftKeyboard());

        ViewInteraction button5 = onView(
                allOf(withId(R.id.done), withText("Terminado"), isDisplayed()));
        button5.perform(click());

        ViewInteraction button6 = onView(
                allOf(withId(android.R.id.button1), withText("Aceptar"), isDisplayed()));
        button6.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction linearLayout = onView(
                allOf(withId(R.id.accounts_item_layout),
                        childAtPosition(
                                withId(android.R.id.list),
                                2),
                        isDisplayed()));
        linearLayout.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.title), withText("Carpetas"), isDisplayed()));
        textView.perform(click());

        ViewInteraction linearLayout2 = onView(
                allOf(withId(R.id.folder_list_item_layout),
                        childAtPosition(
                                withId(android.R.id.list),
                                2),
                        isDisplayed()));
        linearLayout2.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
