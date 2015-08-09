package com.nguyenqphan.ribbit;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class ForgetPassword extends AppCompatActivity {

    protected EditText mEmailToResetPassword;
    protected Button mResetPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        mEmailToResetPassword = (EditText)findViewById(R.id.emailToResetPassword);
        mResetPassword = (Button)findViewById(R.id.resetPasswordButton);
        mResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmailToResetPassword.getText().toString();
                ParseUser.requestPasswordResetInBackground(email, new RequestPasswordResetCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            Intent intent = new Intent(ForgetPassword.this, LoginActivity.class);
                            //not go back to the main activity when user hits back button
                            //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                            startActivity(intent);
                            // An email was successfully sent with reset instructions.
                            //just redirect user back to the log in Activity
                        } else {
                            // Something went wrong. Look at the ParseException to see what's up.
                            AlertDialog.Builder builder= new AlertDialog.Builder(ForgetPassword.this);
                            builder.setMessage(e.getMessage());
                            builder.setTitle(R.string.invalid_email);
                            builder.setPositiveButton(android.R.string.ok, null);

                            AlertDialog dialog = builder.create();
                            dialog.show();

                        }
                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forget_password, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
