package com.darko.mvptestingpracticeexample;

import com.darko.mvptestingpracticeexample.mvp.LoginMVP;
import com.darko.mvptestingpracticeexample.mvp.model.User;
import com.darko.mvptestingpracticeexample.mvp.presenter.LoginPresenterMVPImpl;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SuppressWarnings("WeakerAccess")
public class PresenterTest {

    LoginMVP.Model mockModel;
    LoginMVP.View mockView;
    LoginPresenterMVPImpl mockPresenter;
    User user;

    @Before
    public void setup() {
        user = new User("Fox", "Mulder");
        mockModel = mock(LoginMVP.Model.class);
        mockView = mock(LoginMVP.View.class);
        mockPresenter = new LoginPresenterMVPImpl(mockModel);
        mockPresenter.setView(mockView);
    }

    @Test
    public void loadTheUserFromTheRepositoryWhenValidUserIsPresent() {
        when(mockModel.getUser()).thenReturn(user);

        mockPresenter.getCurrentUser();

        //verify model interactions
        verify(mockModel, times(1)).getUser();

        //verify view interactions
        verify(mockView, times(1)).setFirstName("Fox");
        verify(mockView, times(1)).setLastName("Mulder");
        verify(mockView, never()).showUserNotAvailable();
    }

    @Test
    public void shouldShowErrorMessageWhenUserIsNull() {
        when(mockModel.getUser()).thenReturn(null);

        mockPresenter.getCurrentUser();

        //verify model interactions
        verify(mockModel, times(1)).getUser();

        //verify view interactions
        verify(mockView, never()).setFirstName("Fox");
        verify(mockView, never()).setLastName("Mulder");
        verify(mockView, times(1)).showUserNotAvailable();
    }

    @Test
    public void shouldCreateErrorMessageIfFieldAreEmpty() {
        // Set up the view mock
        when(mockView.getFirstName()).thenReturn(""); // empty string

        mockPresenter.saveUser();

        verify(mockView, times(1)).getFirstName();
        verify(mockView, never()).getLastName();
        verify(mockView, times(1)).showInputError();

        // Now tell mockView to return a value for first name and an empty last name
        when(mockView.getFirstName()).thenReturn("Dana");
        when(mockView.getLastName()).thenReturn("");

        mockPresenter.saveUser();

        verify(mockView, times(2)).getFirstName(); // Called two times now, once before, and once now
        verify(mockView, times(1)).getLastName();  // Only called once
        verify(mockView, times(2)).showInputError(); // Called two times now, once before and once now
    }

    @Test
    public void shouldBeAbleToSaveAValidUser() {
        when(mockView.getFirstName()).thenReturn("Dana");
        when(mockView.getLastName()).thenReturn("Scully");

        mockPresenter.saveUser();

        // Called two more times in the saveUser call.
        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(2)).getLastName();

        // Make sure the repository saved the user
        verify(mockModel, times(1)).createUser("Dana", "Scully");

        // Make sure that the view showed the user saved message
        verify(mockView, times(1)).showUserSavedMessage();
    }
}