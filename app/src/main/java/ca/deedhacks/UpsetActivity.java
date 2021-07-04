package ca.deedhacks;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mukesh.DrawingView;

public class UpsetActivity extends AppCompatActivity {

    DrawingView drawingView;

    Button pen;
    Button eraser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_upset);

        drawingView = (DrawingView) findViewById(R.id.scratch_pad);
        pen = findViewById(R.id.pen_btn);
        eraser = findViewById(R.id.eraser_btn);
        User user = User.getInstance();
        user.addPoints(10);

        if(drawingView != null){

            drawingView.initializePen();

            pen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //To use the pen mode to draw on the screen
                    drawingView.setPenColor(getResources().getColor(R.color.black));
                    drawingView.initializePen();
                    user.addPoints(4);
                }
            });

            eraser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawingView.initializeEraser();
                    user.addPoints(4);
                }
            });

        }


    }

}