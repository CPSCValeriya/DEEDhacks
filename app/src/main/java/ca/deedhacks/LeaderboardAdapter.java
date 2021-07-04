package ca.deedhacks;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class LeaderboardAdapter extends BaseAdapter{

    Context context;
    ArrayList<String> users;
    ArrayList<Integer> points;

    private static LayoutInflater inflater = null;

    public LeaderboardAdapter(Context context, ArrayList<String> users, ArrayList<Integer> points){

        this.context = context;
        this.users = users;
        this.points = points;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        System.out.println("inside constr: users size = " + this.users.size() + " points size = " + this.points.size());


    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        System.out.println("inside getview: users size = " + users.size() + " points size = " + points.size());
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.list_item, null);

        TextView usersTxt = (TextView) vi.findViewById(R.id.names_list_txt);
        TextView  pointsTxt = vi.findViewById(R.id.points_list_txt);

        usersTxt.setText(users.get(position));
        pointsTxt.setText(points.get(position).toString());

        if(position == 1){
            usersTxt.setTypeface(null, Typeface.BOLD);
            pointsTxt.setTypeface(null, Typeface.BOLD);
        }

        return vi;
    }
}
