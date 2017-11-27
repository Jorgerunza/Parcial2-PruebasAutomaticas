package com.fsck.k9.activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.fsck.k9.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
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
public class QuitarActividadAccounts {

    @Rule
    public ActivityTestRule<Accounts> mActivityTestRule = new ActivityTestRule<>(Accounts.class);

    @Test
    public void quitarPermisoContactos() {
        ViewInteraction button = onView(
                allOf(withId(R.id.next), withText("Siguiente"), isDisplayed()));
        button.perform(click());

        ViewInteraction editText = onView(
                withId(R.id.account_email));
        editText.perform(scrollTo(), replaceText("misotest2017@gmail.com"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                withId(R.id.account_password));
        editText2.perform(scrollTo(), replaceText("pruebas2017*"), closeSoftKeyboard());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.next), withText("Siguiente"), isDisplayed()));
        button2.perform(click());

        ViewInteraction button3 = onView(
                allOf(withId(android.R.id.button2), withText("Continuar"), isDisplayed()));
        button3.perform(click());

        ViewInteraction button4 = onView(
                allOf(withId(android.R.id.button2), withText("Continuar"), isDisplayed()));
        button4.perform(click());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.account_description), withContentDescription("Elija un nombre para esta cuenta (opcional):")));
        editText3.perform(scrollTo(), replaceText("miso"), closeSoftKeyboard());

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.account_name), withContentDescription("Introduzca su nombre (se verá en los mensajes salientes):")));
        editText4.perform(scrollTo(), replaceText("Miso"), closeSoftKeyboard());

        ViewInteraction button5 = onView(
                allOf(withId(R.id.done), withText("Terminado"), isDisplayed()));
        button5.perform(click());

        ViewInteraction button6 = onView(
                allOf(withId(android.R.id.button1), withText("Aceptar"), isDisplayed()));
        button6.perform(click());


    }

}
