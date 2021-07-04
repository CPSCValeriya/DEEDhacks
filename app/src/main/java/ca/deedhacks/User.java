package ca.deedhacks;
import java.util.ArrayList;

public class User {

    String name;
    Integer numPoints;
    ArrayList<String> taskHistory;
    ArrayList<Integer> pointsHistory;

    private static User instance = null;

    private User(){

        name = "Me";
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

    public String getName(){
        return name;
    }

    public void addPoints(int addPoints) {
        numPoints += addPoints;
    }

    public Integer getNumPoints() {
        return numPoints;
    }

    public ArrayList<String> getTaskHistory() {
        return taskHistory;
    }

    public void setTaskHistory(ArrayList<String> taskHistory) {
        this.taskHistory = taskHistory;
    }

    public ArrayList<Integer> getPointsHistory() {
        return pointsHistory;
    }

    public void setPointsHistory(ArrayList<Integer> pointsHistory) {
        this.pointsHistory = pointsHistory;
    }

}
