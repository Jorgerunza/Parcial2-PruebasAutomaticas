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
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Settings {

    @Rule
    public ActivityTestRule<Accounts> mActivityTestRule = new ActivityTestRule<>(Accounts.class);

    @Test
    public void settings() {
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
        editText4.perform(scrollTo(), replaceText("mis"), closeSoftKeyboard());

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

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.title), withText("Configuración"), isDisplayed()));
        textView.perform(click());

        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.list),
                                withParent(withClassName(is("android.widget.LinearLayout")))),
                        0),
                        isDisplayed()));
        linearLayout.perform(click());

        pressBack();

        ViewInteraction linearLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.list),
                                withParent(withClassName(is("android.widget.LinearLayout")))),
                        1),
                        isDisplayed()));
        linearLayout2.perform(click());

        pressBack();

        ViewInteraction linearLayout3 = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.list),
                                withParent(withClassName(is("android.widget.LinearLayout")))),
                        2),
                        isDisplayed()));
        linearLayout3.perform(click());

        pressBack();

        ViewInteraction linearLayout4 = onView(
                allOf(childAtPosition(
                        allOf(withId(android.R.id.list),
                                withParent(withClassName(is("android.widget.LinearLayout")))),
                        4),
                        isDisplayed()));
        linearLayout4.perform(click());

        pressBack();

        pressBack();

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction textView2 = onView(
                allOf(withId(android.R.id.title), withText("Acerca de"), isDisplayed()));
        textView2.perform(click());

        ViewInteraction button7 = onView(
                allOf(withId(android.R.id.button1), withText("Aceptar"), isDisplayed()));
        button7.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction textView3 = onView(
                allOf(withId(android.R.id.title), withText("Importar y exportar ajustes"), isDisplayed()));
        textView3.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction textView4 = onView(
                allOf(withId(android.R.id.title), withText("Configuración"), isDisplayed()));
        textView4.perform(click());

        pressBack();

        pressBack();

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
