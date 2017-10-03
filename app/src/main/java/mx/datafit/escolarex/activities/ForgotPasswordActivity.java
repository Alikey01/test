package mx.datafit.escolarex.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mx.datafit.escolarex.LoginActivity;
import mx.datafit.escolarex.R;


public class ForgotPasswordActivity extends AppCompatActivity {

    private static final String TAG = "ForgotPasswordActivity";

    private EditText emailText;
    private Button forgotButton;
    private TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailText     = (EditText) findViewById(R.id.input_email);
        loginLink = (TextView) findViewById(R.id.link_login);
        forgotButton   = (Button) findViewById(R.id.btn_forgot_password);

        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPwd();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    public void forgotPwd() {
        forgotButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(ForgotPasswordActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(getString(R.string.login_message));
        progressDialog.show();

        new android.os.Handler().postDelayed(new Runnable() {
            public void run() {
                onSignupSuccess();
                progressDialog.dismiss();
            }
        }, 3000);
    }


    public void onSignupSuccess() {
        forgotButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

}
