package edu.bsu.cs222;

import java.util.HashMap;
import java.util.Map;

public class TeamNumber {
    public int findTeamsId(String teamsName) {
        int teamId=0;
        Map<String, Integer> nbaTeamsId = new HashMap<String, Integer>();
        nbaTeamsId.put("Golden State Warriors",9);
        nbaTeamsId.put("LA Clippers",12);
        nbaTeamsId.put("LA Lakers",13);
        nbaTeamsId.put("Phoenix Suns",21);
        nbaTeamsId.put("Houston Rockets",10);
        nbaTeamsId.put("Denver Nuggets",7);
        nbaTeamsId.put("Utah Jazz",26);
        nbaTeamsId.put("Portland Trailblazers",22);
        nbaTeamsId.put("Minnesota Timberwolves",16);
        nbaTeamsId.put("Oklahoma City Thunder",25);
        nbaTeamsId.put("Dallas Mavericks",6);
        nbaTeamsId.put("San Antonio Spurs",24);
        nbaTeamsId.put("Memphis Grizzlies",29);
        nbaTeamsId.put("New Orleans Pelicans",3);
        nbaTeamsId.put("Boston Celtics",2);
        nbaTeamsId.put("New York Knicks",18);
        nbaTeamsId.put("Brooklyn Nets",17);
        nbaTeamsId.put("Philadelphia 76ers",20);
        nbaTeamsId.put("Toronto Raptors",28);
        nbaTeamsId.put("Miami Heat",14);
        nbaTeamsId.put("Orlando Magic",19);
        nbaTeamsId.put("Atlanta Hawks",1);
        nbaTeamsId.put("Washington Wizards",27);
        nbaTeamsId.put("Charlotte Hornets",30);
        nbaTeamsId.put("Chicago Bulls",4);
        nbaTeamsId.put("Cleveland Cavaliers",5);
        nbaTeamsId.put("Detroit Pistons",8);
        nbaTeamsId.put("Indiana Pacers",11);
        nbaTeamsId.put("Milwaukee Bucks",15);
        teamId = nbaTeamsId.get(teamsName);
        return teamId;
    }
}
