package evapaunova.example.com.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

import evapaunova.example.com.project.model.User;

public class RegisterActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final ToggleButton genderMale = findViewById(R.id.gender_male);
        final ToggleButton genderFemale = findViewById(R.id.gender_female);

        genderFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(genderFemale.isChecked()){
                    genderMale.setChecked(false);
                }
                else{
                    genderMale.setChecked(true);
                }
            }
        });

        genderMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(genderMale.isChecked()){
                    genderFemale.setChecked(false);
                }
                else{
                    genderFemale.setChecked(true);
                }
            }
        });

        Button register = findViewById(R.id.button_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(RegisterActivity.this,LoginActivity.class);

                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);
                EditText passwordRepeat = findViewById(R.id.confirm_password);
                EditText age = findViewById(R.id.age);

                boolean gender = false;
                int ageInt = 0;


                if(!age.getText().toString().equals("") && age.getText().toString().length() <= 3){
                    ageInt = Integer.parseInt(age.getText().toString());
                }
                else{
                    ageInt = -1;
                }

                if(genderFemale.isChecked()){
                    gender = true;
                }

                if(!validUsername(username.getText().toString())){
                    username.setError("Wrong username!");
                }
                else if(!validPassword(password.getText().toString(),passwordRepeat.getText().toString())){
                    password.setError("Wrong password!");
                }
                else if(!validAge(ageInt)){
                    age.setError("Invalid age!");
                }
                else  {
                    User user = new User(username.getText().toString(), password.getText().toString(), Integer.parseInt(age.getText().toString()), gender);

                    i.putExtra("User", user);

                    setResult(567, i);
                    finish();
                }

            }
        });
    }

    private boolean validUsername(String username){
        if(username.length() < 4){
            return false;
        }
        return true;
    }

    private boolean validPassword(String password, String repeatPassword){
        if(!password.equals(repeatPassword) || password.length() < 4){
            return false;
        }
        return true;
    }

    private boolean validAge(int age){
        if(age < 0 || age > 100){
            return false;
        }
        return true;
    }
}
