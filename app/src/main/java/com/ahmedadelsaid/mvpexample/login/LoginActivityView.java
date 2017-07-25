package com.ahmedadelsaid.mvpexample.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ahmedadelsaid.mvpexample.R;
import com.ahmedadelsaid.mvpexample.root.App;

import javax.inject.Inject;

public class LoginActivityView extends AppCompatActivity implements LoginActivityMVP.View {

    @Inject
    LoginActivityMVP.Presenter presenter;

    private EditText firstName;
    private EditText lastName;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        ((App) getApplication()).getComponent().inject(this);

        firstName = (EditText) findViewById(R.id.loginActivity_firstName_editText);
        lastName = (EditText) findViewById(R.id.loginActivity_lastName_editText);
        login = (Button) findViewById(R.id.loginActivity_login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginButtonClicked();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach(this);
        presenter.getCurrentUser();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    public User getUser() {
        return new User(this.firstName.getText().toString(), this.lastName.getText().toString());
    }

    @Override
    public void setUser(User user) {
        this.firstName.setText(user.getFirstName());
        this.lastName.setText(user.getLastName());
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "First Name or last name cannot be empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSavedMessage(User user) {
        Toast.makeText(this, user.getFirstName() + " " + user.getLastName() + " saved successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "User not available", Toast.LENGTH_SHORT).show();
    }
}
