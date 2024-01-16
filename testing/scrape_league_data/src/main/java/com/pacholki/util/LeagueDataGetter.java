package com.pacholki.util;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class LeagueDataGetter extends DataGetter {

    private League league;
    private Season season;

    public LeagueDataGetter(League league, Season season) {
        this.league = league;
        this.season = season;
    }

    @Override
    public void run() {
        System.out.println("Trying to download data for:\t" + league.getName() + "\t" + season.getLabel());

        getTeams();

        System.out.println("Download finished: \t" + league.getName() + "\t" + season.getLabel());

    }

    public void getTeams() {

        try {
            Document doc = Jsoup
                .connect(FBREF_URL)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .header("Accept-Language", "*")
                .get();

            Elements tableContainers = doc.select("div.type-club");
            big5Container[] = tableContainers.stream()
                .filter(element -> element.selectFirst("div").id().equals("all_comps_intl_club_cup"))
                .toArray();

            System.out.println(big5Container);

            // for (Element leagueContainer : leagueContainers) {
            //     System.out.println(leagueContainer);
            //     for (int i = 0; i < 10; i++) {
            //         System.out.println("----------------------------------------------------------");
            //     }
            //     break;
            // }
            // Elements league_names = league_containers.select("")
            // Tools.display(leagues);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
