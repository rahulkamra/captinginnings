/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Pavallion;

import java.util.Set;

/**
 *
 * @author Owner
 */
public class AllDetailsBean {
    private int money;
    private int points_left;
    private int coach_level;
    private int batsman_level;
    private int bowler_level;
    private int banked_money;
    private int strategy_level;
    private int total_matches;
    private int win;
    private int loose;
    private int draw;
    private int time_left;
    private int rank;
    private int extra_batting_points=0;
    private int extra_bowling_points=0;
    private String teamname;
    private Set teamlist;
    

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPoints_left() {
        return points_left;
    }

    public void setPoints_left(int points_left) {
        this.points_left = points_left;
    }

    public int getCoach_level() {
        return coach_level;
    }

    public void setCoach_level(int coach_level) {
        this.coach_level = coach_level;
    }

    public int getBatsman_level() {
        return batsman_level;
    }

    public void setBatsman_level(int batsman_level) {
        this.batsman_level = batsman_level;
    }

    public int getBowler_level() {
        return bowler_level;
    }

    public void setBowler_level(int bowler_level) {
        this.bowler_level = bowler_level;
    }

    public int getBanked_money() {
        return banked_money;
    }

    public void setBanked_money(int banked_money) {
        this.banked_money = banked_money;
    }

    public int getTotal_matches() {
        return total_matches;
    }

    public void setTotal_matches(int total_matches) {
        this.total_matches = total_matches;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLoose() {
        return loose;
    }

    public void setLoose(int loose) {
        this.loose = loose;
    }

    public int getTime_left() {
        return time_left;
    }

    public void setTime_left(int time_left) {
        this.time_left = time_left;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getExtra_batting_points() {
        return extra_batting_points;
    }

    public void setExtra_batting_points(int extra_batting_points) {
        this.extra_batting_points = extra_batting_points;
    }

    public int getExtra_bowling_points() {
        return extra_bowling_points;
    }

    public void setExtra_bowling_points(int extra_bowling_points) {
        this.extra_bowling_points = extra_bowling_points;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public int getStrategy_level() {
        return strategy_level;
    }

    public void setStrategy_level(int strategy_level) {
        this.strategy_level = strategy_level;
    }

    public Set getTeamlist() {
        return teamlist;
    }

    public void setTeamlist(Set teamlist) {
        this.teamlist = teamlist;
    }

    
    
}
