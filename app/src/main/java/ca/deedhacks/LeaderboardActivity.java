package ca.deedhacks;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class LeaderboardActivity extends AppCompatActivity {

    ListView listview;
    ArrayList<String> users;
    ArrayList<Integer> points;
    LeaderboardAdapter adapter;
    User user;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_leaderboard);
        user = user.getInstance();

        users = new ArrayList<>();
        points = new ArrayList<>();

        Map<String, Integer> userScores = new HashMap<String, Integer>();

        userScores.put("Amy", 42);
        userScores.put("Jennifer", 21);
        userScores.put("Mo", 8);
        userScores.put("Dia", 12);
        userScores.put("Alex",6);
        userScores.put(user.getName(),user.getNumPoints());

        List<Integer> sortUsersByPoints = new ArrayList<>(userScores.values());
        Collections.sort(sortUsersByPoints,Collections.reverseOrder());

        System.out.print("sortUsersByPoints:" + sortUsersByPoints);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(userScores.entrySet());
        list.sort(Map.Entry.comparingByValue());
        LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();
        list.forEach(e -> {
            sortedMap.put(e.getValue(), e.getKey());
        });

        TreeMap<Integer, String> tmap = new TreeMap<>(sortedMap);
        sortedMap.clear();
        sortedMap.putAll(tmap.descendingMap());

        System.out.print("SORTED: " + sortedMap.keySet());
        System.out.print("SORTED: " + sortedMap.values());


        users = new ArrayList<>(sortedMap.values());
        points = (ArrayList<Integer>)sortUsersByPoints;

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