package com.example.admin.lecture08.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.lecture08.R;

public class DetailsActivity extends AppCompatActivity {
    private  String season_name_received;
    private TextView display_info_season,display_details_season_tv;
    public static final String[] Season_Details={"Silicon Valley","Silicon Valley is about Richard Henricks and his company named pied piper",
            "Game of Thrones","Game of Thrones is a fantasy drama",
            "Big Bang Theory","Big Bang Theory is scientific sci-fi drama",
            "Prison Break","Prison Break is about the story of Micheal Scofield and his brother",
            "Citizen Khan","Citizen Khan: Mr. Khan , a pakistani citizen living abroad in UK",
            "Divinci Demons","Divinci Demons: Story about Leonardo Divinci",
            "Mr. Robot","Mr. Robot is about hacker's story and how he wants to take revenge on society",
            "House of Cards","House of Cards is about underwood and his compaign to become president of USA",
            "Sherlock Holmes","Sherlock Holmes: Detective to solve crimes"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //receive the intent data
        Intent intent=getIntent();
        season_name_received=intent.getExtras().getString("season_name");

        //display season name passed from main activity
        display_info_season=(TextView)this.findViewById(R.id.display_info);
        display_details_season_tv=(TextView)this.findViewById(R.id.details_season);

        display_info_season.setText("The name of season is: "+season_name_received);
        for(int i=0; i<Season_Details.length; i++){
            if(Season_Details[i].equals(season_name_received)){
                display_details_season_tv.setText(Season_Details[i+1]);
            }
        }

    }
}
