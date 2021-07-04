package ca.deedhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity {

    ListView listview;
    ArrayList<String> users;
    ArrayList<Integer> points;
    LeaderboardAdapter adapter;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        user = user.getInstance();

        users = new ArrayList<>();
        points = new ArrayList<>();

        users.add(user.getName());
        points.add(user.getNumPoints());

        users.add("Amy");
        users.add("Janey");
        users.add("Mo");
        users.add("Dia");
        users.add("Alec");
        points.add(42);
        points.add(21);
        points.add(18);
        points.add(12);
        points.add(6);

        listview = (ListView) findViewById(R.id.listview_leaderboard);
        adapter = new LeaderboardAdapter(this, users, points);
        listview.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();

    }
}