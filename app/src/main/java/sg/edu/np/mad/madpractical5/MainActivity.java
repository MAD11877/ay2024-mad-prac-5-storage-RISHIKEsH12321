package sg.edu.np.mad.madpractical5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<User> userList;

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

        DatabaseHandler dbHandler = new DatabaseHandler(this, null, null, 1);

//        Random random = new Random();
//        dbHandler.addUser(new User("Alice" + new Random().nextInt(99999), "Software Engineer", 1, false ));
//        dbHandler.addUser(new User("Bob" + new Random().nextInt(99999), "Data Scientist", 2, true));
//        dbHandler.addUser(new User("Charlie" + new Random().nextInt(99999), "UI/UX Designer", 3, false));
//        dbHandler.addUser(new User("David" + new Random().nextInt(99999), "Product Manager", 4, true));
//        dbHandler.addUser(new User("Emma" + new Random().nextInt(99999), "Frontend Developer", 5, false));
//        dbHandler.addUser(new User("Frank" + new Random().nextInt(99999), "Backend Developer", 6, true));
//        dbHandler.addUser(new User("Grace" + new Random().nextInt(99999), "Mobile App Developer", 7, false));
//        dbHandler.addUser(new User("Henry" + new Random().nextInt(99999), "DevOps Engineer", 8, true));
//        dbHandler.addUser(new User("Ivy" + new Random().nextInt(99999), "Systems Analyst", 9, false));
//        dbHandler.addUser(new User("Jack" + new Random().nextInt(99999), "Database Administrator", 10, true));
//        dbHandler.addUser(new User("Kevin" + new Random().nextInt(99999), "Network Engineer", 11, false));
//        dbHandler.addUser(new User("Lily" + new Random().nextInt(99999), "Cyber security Analyst", 12, true));
//        dbHandler.addUser(new User("Mike" + new Random().nextInt(99999), "Cloud Architect", 13, false));
//        dbHandler.addUser(new User("Nancy" + new Random().nextInt(99999), "AI Specialist", 14, true));
//        dbHandler.addUser(new User("Oliver" + new Random().nextInt(99999), "Game Developer", 15, false));
//        dbHandler.addUser(new User("Pam" + new Random().nextInt(99999), "Embedded Systems Engineer", 16, true));
//        dbHandler.addUser(new User("Quinn" + new Random().nextInt(99999), "Web Developer", 17, false));
//        dbHandler.addUser(new User("Rachel" + new Random().nextInt(99999), "Software Tester", 18, true));
//        dbHandler.addUser(new User("Sam" + new Random().nextInt(99999), "Data Engineer", 19 ,false));
//        dbHandler.addUser(new User("Tom" + new Random().nextInt(99999), "Machine Learning Engineer", 20, true));



        userList = dbHandler.getUsers();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        UserAdapter userAdapter = new UserAdapter(userList, this);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    protected void onResume(){
        super.onResume();
        DatabaseHandler dbHandler = new DatabaseHandler(this, null, null, 1);
        userList = dbHandler.getUsers();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        UserAdapter userAdapter = new UserAdapter(userList, this);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}