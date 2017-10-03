package mx.datafit.escolarex;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mx.datafit.escolarex.activities.ForgotPasswordActivity;
import mx.datafit.escolarex.activities.MainMenuActivity;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText emailText;
    private EditText passwordText;
    private Button loginButton;
    private TextView forgotPwdLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailText     = (EditText) findViewById(R.id.input_email);
        passwordText  = (EditText) findViewById(R.id.input_password);
        forgotPwdLink = (TextView) findViewById(R.id.link_forgot_pwd);
        loginButton   = (Button) findViewById(R.id.btn_login);

        emailText.setText("john@doe.com");
        passwordText.setText("datafit");

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

        forgotPwdLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    @Override
    public void onBackPressed() { // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        loginButton.setEnabled(true);
        Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        loginButton.setEnabled(true);
    }

    private void attemptLogin() {
        Log.d(TAG, "attemptLogin()");

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (! validate(emailText, passwordText)) {
            onLoginFailed();
            return;
        }

        loginButton.setEnabled(false);

        UserLoginTask authTask = new UserLoginTask(email, password);
        authTask.execute((Void) null);
    }

    private boolean validate(EditText emailText, EditText passwordText) {
        // Reset errors.
        emailText.setError(null);
        passwordText.setError(null);

        // Store values at the time of the login attempt.
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        boolean valid = true;
        View focusView = null;

        // Check for a valid email address.
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError(getString(R.string.error_invalid_email));
            focusView = emailText;
            valid = false;
        } else {
            emailText.setError(null);
        }

        // Check for a valid password, if the user entered one.
        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError(getString(R.string.error_invalid_password));
            focusView = passwordText;
            valid = false;
        } else {
            passwordText.setError(null);
        }

        if (! valid) { // There was an error focus the first form field with an error.
            focusView.requestFocus();
        }

        return valid;
    }

    /**
     * Represents an asynchronous login task used to authenticate
     * the user.
     */
    private class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;
        private ProgressDialog progressDialog;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
            progressDialog = new ProgressDialog(LoginActivity.this, R.style.AppTheme_Dark_Dialog);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Iniciando Sesión...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.
            try {
                // Simulate network access.
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            if (success) {
                onLoginSuccess();
                progressDialog.dismiss();
            } else {
                onLoginFailed();
            }
        }
    }
}
