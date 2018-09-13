package edu.duke.compsci408.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView profilep;
    private TextView bio;
    private TextView addition;
    private TextView welcome;
    private Button add;
    private Integer num;
    private String addtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        welcome = findViewById(R.id.welcome_textView);
        welcome.setText("welcome to My Page " + name + "!");
        profilep = findViewById(R.id.profilepicture);
        bio = findViewById(R.id.bio);
        addition = findViewById(R.id.additiontext);
        add = findViewById(R.id.addbutton);
        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.profile);
        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 200, 200, true);
        profilep.setImageBitmap(bMapScaled);
//        profilep.setImageDrawable(getResources().getDrawable(R.drawable.profile));
        bio.setText(getResources().getText(R.string.bio_description));
        num = 0;
        addtext = getResources().getText(R.string.add_string) + Integer.toString(num);
        addition.setText(addtext);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                addtext = getResources().getText(R.string.add_string) + Integer.toString(num);
                addition.setText(addtext);
            }
        });
    }
}
