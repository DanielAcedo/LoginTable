package com.danielacedo.logintable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.danielacedo.logintable.controller.LoginTable_Controller;

import static android.text.TextUtils.isEmpty;

public class LoginTable_Activity extends AppCompatActivity {

    private LoginTable_Controller loginTable_Controller;
    private EditText edt_User, edt_Password;
    private Button btn_Ok, btn_Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_table_);
        loginTable_Controller = new LoginTable_Controller();
        edt_User = (EditText)findViewById(R.id.edt_User);
        edt_Password = (EditText)findViewById(R.id.edt_Password);
        btn_Ok = (Button)findViewById(R.id.btn_Ok);
        btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edt_User.getText().toString();
                String pass = edt_Password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.err_emptyData), Toast.LENGTH_SHORT).show();
                }else{
                    int result = loginTable_Controller.validateCredentials(user, pass);

                    switch (result){
                        case LoginTable_Controller.PASSWORD_DIGIT:
                            Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.err_Password_Digit),Toast.LENGTH_SHORT).show();
                            break;
                        case LoginTable_Controller.PASSWORD_UPPERLOWERCASE:
                            Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.err_Password_UpperLowerCase),Toast.LENGTH_SHORT).show();
                            break;
                        case LoginTable_Controller.PASSWORD_LENGTH:
                            Toast.makeText(LoginTable_Activity.this, getResources().getString(R.string.err_Password_Length),Toast.LENGTH_SHORT).show();
                            break;
                        case LoginTable_Controller.OK:
                            // The activity would be started after login

                            break;
                    }
                }
            }
        });

        btn_Cancel = (Button)findViewById(R.id.btn_Cancel);
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetValues();
            }
        });
    }

    private void resetValues() {
        edt_User.setText("");
        edt_Password.setText("");
    }
}
