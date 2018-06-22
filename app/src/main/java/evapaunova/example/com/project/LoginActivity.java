package evapaunova.example.com.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import evapaunova.example.com.project.model.User;

public class LoginActivity extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<>();

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        users.add(new User("Eva","12345",21,true));

        Button login = findViewById(R.id.button_Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User currentUser = new User(username.getText().toString(),password.getText().toString());
                boolean credentialsOK = false;
                for(User u: users){
                    if(u.getUsername().equals(currentUser.getUsername()) && u.getPassword().equals(currentUser.getPassword())){
                        credentialsOK = true;
                        currentUser = new User(u.getUsername(),u.getPassword(),u.getAge(), u.isFemale());
                        Intent intent = new Intent(LoginActivity.this,LoggedActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("User",currentUser);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }

                if(!credentialsOK){
                    Toast.makeText(LoginActivity.this, "Wrong credentials!", Toast.LENGTH_SHORT).show();
                    password.setText("");
                }

            }
        });

        Button register = findViewById(R.id.button_ToRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(i,234);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null) {
            User newUser = (User) data.getSerializableExtra("User");
            users.add(newUser);
            username.setText(newUser.getUsername());
            password.setText(newUser.getPassword());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        username.setText("");
        password.setText("");
    }
}
