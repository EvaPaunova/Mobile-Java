package evapaunova.example.com.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import evapaunova.example.com.project.model.User;

public class LoggedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        User user = (User)getIntent().getExtras().getSerializable("User");

        TextView username = findViewById(R.id.name);
        TextView age = findViewById(R.id.age);
        TextView gender = findViewById(R.id.gender);

        username.setText(user.getUsername());
        age.setText(user.getAge()+"");
        if(user.isFemale()){
            gender.setText("female.");
        }
        else{
            gender.setText("male.");
        }

        Button logOut = findViewById(R.id.button_logOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoggedActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button menu = findViewById(R.id.button_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoggedActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

    }
}
