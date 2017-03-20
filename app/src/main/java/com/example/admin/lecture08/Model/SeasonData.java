package com.example.admin.lecture08.Model;

import com.example.admin.lecture08.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 3/20/2017.
 */

public class SeasonData {
    private static final String[] myFavSeasonArray = {
            "Silicon Valley",
            "Game of Thrones",
            "Big Bang Theory",
            "Prison Break",
            "Citizen Khan",
            "Divinci Demons",
            "Mr. Robot",
            "House of Cards",
            "Sherlock Holmes"};
    private static final int[] myFavSeasonImageArray = {
            R.drawable.siliconvalley,
            R.drawable.gameofthrones,
            R.drawable.bigbangtheory,
            R.drawable.prisonbreak,
            R.drawable.citizenkhan,
            R.drawable.divincidemons,
            R.drawable.mrrobot,
            R.drawable.houseofcards,
            R.drawable.sherlockholmes};

    public static List<SeasonAccessorMutator> getSeasonData() {
        List<SeasonAccessorMutator> seasonArrayList = new ArrayList<>();
        for (int iteration = 0; iteration < 5; iteration++) {
            for (int i = 0; i < myFavSeasonArray.length && i < myFavSeasonImageArray.length; i++) {
                SeasonAccessorMutator seasonAccessorMutator = new SeasonAccessorMutator();
                seasonAccessorMutator.setSeasonName(myFavSeasonArray[i]);
                seasonAccessorMutator.setSeasonImage(myFavSeasonImageArray[i]);
                seasonArrayList.add(seasonAccessorMutator);
            }
        }
        return seasonArrayList;
    }
}
