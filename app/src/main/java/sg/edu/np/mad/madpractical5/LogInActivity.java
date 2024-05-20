package sg.edu.np.mad.madpractical5;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {

    private static final String TAG = "Firebase";
    private String usernameGET;
    private String passwordGET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText usernameET = findViewById(R.id.etUsername);
        EditText passwordET = findViewById(R.id.etPassword);
        Button loginBtn = findViewById(R.id.btnLogin);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://innate-algebra-421614-default-rtdb.asia-southeast1.firebasedatabase.app/");
        database.goOnline();
        DatabaseReference myRef = database.getReference("Users");


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.user);
                Log.d(TAG, "Value is: " + dataSnapshot);
                usernameGET = dataSnapshot.child("MAD/username").getValue(String.class);
                passwordGET = dataSnapshot.child("MAD/password").getValue(String.class);
                Log.d(TAG, "Username is: " + usernameGET);
                Log.d(TAG, "Password is: " + passwordGET);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = String.valueOf(usernameET.getText());
                String password = String.valueOf(passwordET.getText());
                Log.d(TAG, "Input Username is: " + username);
                Log.d(TAG, "Input Password is: " + password);
                if (username.equals(usernameGET) && password.equals(passwordGET)){
                    Intent intent = new Intent(LogInActivity.this,ListActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LogInActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}