package ca.deedhacks;
import java.util.ArrayList;

public class User {

    String name;
    Integer numPoints;
    ArrayList<String> taskHistory;
    ArrayList<Integer> pointsHistory;

    private static User instance = null;

    private User(){

        name = "";
        numPoints = 0;
        taskHistory = new ArrayList<>();
        pointsHistory = new ArrayList<>();

    }

    public static User getInstance(){
        if(instance == null){
            System.out.println("User created");
            instance = new User();
        }
        return instance;
    }

}
