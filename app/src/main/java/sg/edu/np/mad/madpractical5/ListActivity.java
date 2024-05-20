package sg.edu.np.mad.madpractical5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Creating DB
        MyDBHandler db = new MyDBHandler(this,null,null,1);
        //Deletes all rows in table
//        db.resertTable();
//
//        Random random = new Random();
//        db.addUser(new User("Alice" + new Random().nextInt(99999), "Software Engineer", false));
//        db.addUser(new User("Bob" + new Random().nextInt(99999), "Data Scientist", true));
//        db.addUser(new User("Charlie" + new Random().nextInt(99999), "UI/UX Designer", false));
//        db.addUser(new User("David" + new Random().nextInt(99999), "Product Manager", true));
//        db.addUser(new User("Emma" + new Random().nextInt(99999), "Frontend Developer", false));
//        db.addUser(new User("Frank" + new Random().nextInt(99999), "Backend Developer", true));
//        db.addUser(new User("Grace" + new Random().nextInt(99999), "Mobile App Developer", false));
//        db.addUser(new User("Henry" + new Random().nextInt(99999), "DevOps Engineer", true));
//        db.addUser(new User("Ivy" + new Random().nextInt(99999), "Systems Analyst",false));
//        db.addUser(new User("Jack" + new Random().nextInt(99999), "Database Administrator", true));
//        db.addUser(new User("Kevin" + new Random().nextInt(99999), "Network Engineer", false));
//        db.addUser(new User("Lily" + new Random().nextInt(99999), "Cybersecurity Analyst", true));
//        db.addUser(new User("Mike" + new Random().nextInt(99999), "Cloud Architect", false));
//        db.addUser(new User("Nancy" + new Random().nextInt(99999), "AI Specialist", true));
//        db.addUser(new User("Oliver" + new Random().nextInt(99999), "Game Developer", false));
//        db.addUser(new User("Pam" + new Random().nextInt(99999), "Embedded Systems Engineer", true));
//        db.addUser(new User("Quinn" + new Random().nextInt(99999), "Web Developer", false));
//        db.addUser(new User("Rachel" + new Random().nextInt(99999), "Software Tester", true));
//        db.addUser(new User("Sam" + new Random().nextInt(99999), "Data Engineer" ,false));
//        db.addUser(new User("Tom" + new Random().nextInt(99999), "Machine Learning Engineer", true));


        RecyclerView rcView = findViewById(R.id.rvView);
        UserAdapter mAdapter = new UserAdapter(db.getUser());

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        rcView.setLayoutManager(mLayoutManager);
        rcView.setItemAnimator(new DefaultItemAnimator());
        rcView.setAdapter(mAdapter);

        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    }
}