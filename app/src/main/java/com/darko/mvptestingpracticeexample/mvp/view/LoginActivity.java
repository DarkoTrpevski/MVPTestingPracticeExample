package com.darko.mvptestingpracticeexample.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.darko.mvptestingpracticeexample.LoginApp;
import com.darko.mvptestingpracticeexample.R;
import com.darko.mvptestingpracticeexample.mvp.LoginMVP;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginMVP.View {

    @Inject
    LoginMVP.Presenter presenter;


    private EditText firstName;
    private EditText lastName;

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((LoginApp) getApplication()).getComponent().inject(this);

        firstName = findViewById(R.id.loginActivity_firstName_editText);
        lastName = findViewById(R.id.loginActivity_lastName_editText);
        Button login = findViewById(R.id.loginActivity_login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginButtonClicked();
            }
        });
    }

    @Override
    public String getFirstName() {
        return firstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastName.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "Error the user is not available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserAvailable() {
        Toast.makeText(this, "User is available", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "First Name or last name cannot be empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User saved successfully", Toast.LENGTH_SHORT).show();
    }
}