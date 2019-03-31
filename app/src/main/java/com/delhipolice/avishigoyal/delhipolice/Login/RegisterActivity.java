package com.delhipolice.avishigoyal.delhipolice.Login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.Database.Register;
import com.delhipolice.avishigoyal.delhipolice.R;
import com.delhipolice.avishigoyal.delhipolice.common.MyPrefences;

public class RegisterActivity extends AppCompatActivity {

    MyPrefences myPrefences;
    private AutoCompleteTextView mEmailView, mName, phoneno;
    private EditText mPass,mConfirmPass;
    private Button mRegister;
    private String name,email,phn,pass,cpass;
    public Register register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEmailView = (AutoCompleteTextView)findViewById(R.id.email);
        mName = (AutoCompleteTextView)findViewById(R.id.name);
        phoneno = (AutoCompleteTextView)findViewById(R.id.phno);
        mPass = findViewById(R.id.password);
        mConfirmPass = findViewById(R.id.confirmPassword);
        mRegister = (Button)findViewById(R.id.register_button);
        myPrefences = new MyPrefences(this);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mName.getText().toString();
                email = mEmailView.getText().toString();
                phn = phoneno.getText().toString();
                pass = mPass.getText().toString();
                cpass = mConfirmPass.getText().toString();
                if(name.equals("")||email.equals("")||phn.equals("")||pass.equals("")||cpass.equals("")||myPrefences.getTypeOfUser()==null){
                    Toast.makeText(RegisterActivity.this,"Fill the form",Toast.LENGTH_SHORT).show();
                }
                else if(!pass.equals(cpass)){
                    Toast.makeText(RegisterActivity.this,"Password don't match",Toast.LENGTH_SHORT).show();
                }else {
                    register = new Register(name,email, phn,myPrefences.getTypeOfUser(),pass,getApplicationContext());
                    register.execute("");
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {

            case R.id.user:
                if (checked) {
                    myPrefences.setTypeOfUser("1");

                }
                break;

            case R.id.police:
                if (checked)
                    myPrefences.setTypeOfUser("2");
                break;

            case R.id.vendor:
                if (checked)
                    myPrefences.setTypeOfUser("3");
                break;

        }
    }

}
