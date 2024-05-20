package sg.edu.np.mad.madpractical5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent recieve = getIntent();
        MyDBHandler db = new MyDBHandler(this,null,null,2);
        String num = recieve.getStringExtra("Random Number");
        int id = recieve.getIntExtra("ID", -1);



        User user = db.getUserByID(id);
        TextView tvName = findViewById(R.id.promt);
        TextView tvDes = findViewById(R.id.lorem);
        Button btnFollow = findViewById(R.id.button1);
        Button btnMessage = findViewById(R.id.button2);
        Log.d(TAG, "Initial Follow: " + user.followed);
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.followed){
                    btnFollow.setText("Follow");
                    user.followed = false;
                    Toast.makeText(MainActivity.this,"Followed",Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Unfollowing to Following : " + user.followed);
                }
                else{
                    btnFollow.setText("Unfollow");
                    user.followed = true;
                    Toast.makeText(MainActivity.this,"Unfollowed",Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Following to Unfollowing: " + user.followed);
                }
                db.updateUser(user);
            }

        });
        tvName.setText(user.name);
        tvDes.setText(user.description);
        if(user.followed){
            btnFollow.setText("Unfollow");

        }
        else{
            btnFollow.setText("Follow");
        }
        Log.d(TAG, "Initial Text: " + btnFollow.getText());
    }

}