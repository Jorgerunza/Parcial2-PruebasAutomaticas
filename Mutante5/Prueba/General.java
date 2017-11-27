package com.fsck.k9.activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import com.fsck.k9.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class General {

    @Rule
    public ActivityTestRule<Accounts> mActivityTestRule = new ActivityTestRule<>(Accounts.class);

    @Test
    public void general() {
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

        ViewInteraction editText5 = onView(
allOf(withId(R.id.account_description), withContentDescription("Elija un nombre para esta cuenta (opcional):")));
        editText5.perform(scrollTo(), replaceText("miso"), closeSoftKeyboard());

        ViewInteraction editText6 = onView(
allOf(withId(R.id.account_name), withContentDescription("Introduzca su nombre (se verá en los mensajes salientes):")));
        editText6.perform(scrollTo(), replaceText("Miso"), closeSoftKeyboard());

        ViewInteraction button5 = onView(
allOf(withId(R.id.done), withText("Terminado"), isDisplayed()));
        button5.perform(click());

        ViewInteraction button6 = onView(
allOf(withId(android.R.id.button1), withText("Aceptar"), isDisplayed()));
        button6.perform(click());

        ViewInteraction actionMenuItemView = onView(
allOf(withId(R.id.compose), withContentDescription("Redactar"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction recipientSelectView = onView(
allOf(withId(R.id.to),
withParent(withId(R.id.to_wrapper))));
        recipientSelectView.perform(scrollTo(), replaceText(",, "), closeSoftKeyboard());

        ViewInteraction editText7 = onView(
withId(R.id.subject));
        editText7.perform(scrollTo(), click());

        ViewInteraction editText8 = onView(
withId(R.id.subject));
        editText8.perform(scrollTo(), replaceText("Rueb"), closeSoftKeyboard());

        ViewInteraction eolConvertingEditText = onView(
withId(R.id.message_content));
        eolConvertingEditText.perform(scrollTo(), replaceText("Ok"), closeSoftKeyboard());

        ViewInteraction actionMenuItemView2 = onView(
allOf(withId(R.id.send), withContentDescription("Enviar"), isDisplayed()));
        actionMenuItemView2.perform(click());



        ViewInteraction actionMenuItemView4 = onView(
allOf(withId(R.id.search), withContentDescription("Buscar"), isDisplayed()));
        actionMenuItemView4.perform(click());

        ViewInteraction searchAutoComplete = onView(
allOf(withClassName(is("android.widget.SearchView$SearchAutoComplete")),
withParent(allOf(withClassName(is("android.widget.LinearLayout")),
withParent(withClassName(is("android.widget.LinearLayout"))))),
isDisplayed()));
        searchAutoComplete.perform(replaceText("a"), closeSoftKeyboard());

        ViewInteraction searchAutoComplete2 = onView(
allOf(withClassName(is("android.widget.SearchView$SearchAutoComplete")), withText("a"),
withParent(allOf(withClassName(is("android.widget.LinearLayout")),
withParent(withClassName(is("android.widget.LinearLayout"))))),
isDisplayed()));
        searchAutoComplete2.perform(pressImeActionButton());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction actionMenuItemView5 = onView(
allOf(withId(R.id.set_sort), withContentDescription("Ordenado por…"), isDisplayed()));
        actionMenuItemView5.perform(click());

        ViewInteraction actionMenuItemView6 = onView(
allOf(withId(R.id.set_sort), withContentDescription("Ordenado por…"), isDisplayed()));
        actionMenuItemView6.perform(click());

        ViewInteraction linearLayout2 = onView(
allOf(withContentDescription("Buscar, Desplazarse hacia arriba"),
withParent(allOf(withClassName(is("com.android.internal.widget.ActionBarView")),
withParent(withClassName(is("com.android.internal.widget.ActionBarContainer"))))),
isDisplayed()));
        linearLayout2.perform(click());

        ViewInteraction linearLayout3 = onView(
allOf(withContentDescription("K-9 Mail, Desplazarse hacia arriba"),
withParent(allOf(withClassName(is("com.android.internal.widget.ActionBarView")),
withParent(withClassName(is("com.android.internal.widget.ActionBarContainer"))))),
isDisplayed()));
        linearLayout3.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction textView = onView(
allOf(withId(android.R.id.title), withText("Configuración"), isDisplayed()));
        textView.perform(click());

        ViewInteraction textView2 = onView(
allOf(withId(android.R.id.title), withText("Configuración global"), isDisplayed()));
        textView2.perform(click());

        ViewInteraction linearLayout4 = onView(
allOf(childAtPosition(
allOf(withId(android.R.id.list),
withParent(withClassName(is("android.widget.LinearLayout")))),
3),
isDisplayed()));
        linearLayout4.perform(click());

        ViewInteraction linearLayout5 = onView(
allOf(childAtPosition(
allOf(withId(android.R.id.list),
withParent(withId(android.R.id.list_container))),
0),
isDisplayed()));
        linearLayout5.perform(click());

        ViewInteraction checkedTextView = onView(
allOf(withId(android.R.id.text1), withText("Nunca"),
childAtPosition(
allOf(withClassName(is("com.android.internal.app.AlertController$RecycleListView")),
withParent(withClassName(is("android.widget.LinearLayout")))),
2),
isDisplayed()));
        checkedTextView.perform(click());

        pressBack();

        pressBack();

        ViewInteraction linearLayout6 = onView(
allOf(withId(R.id.folder_list_item_layout),
childAtPosition(
withId(android.R.id.list),
0),
isDisplayed()));
        linearLayout6.perform(click());

        ViewInteraction linearLayout7 = onView(
allOf(childAtPosition(
allOf(withId(R.id.message_list),
withParent(withId(R.id.swiperefresh))),
1),
isDisplayed()));
        linearLayout7.perform(click());

        ViewInteraction actionMenuItemView7 = onView(
allOf(withId(R.id.set_sort), withContentDescription("Ordenado por…"), isDisplayed()));
        actionMenuItemView7.perform(click());

        ViewInteraction textView3 = onView(
allOf(withId(android.R.id.title), withText("Estrella"), isDisplayed()));
        textView3.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction linearLayout8 = onView(
allOf(withContentDescription("K-9 Mail, Desplazarse hacia arriba"),
withParent(allOf(withClassName(is("com.android.internal.widget.ActionBarView")),
withParent(withClassName(is("com.android.internal.widget.ActionBarContainer"))))),
isDisplayed()));
        linearLayout8.perform(click());

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
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
