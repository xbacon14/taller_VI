package py.edu.facitec.worldfutballclubb;

import java.io.Serializable;

public class Pais implements Serializable {

private Long team_id;

private String name;
private String group_name;
private Long rank;
private Long points;
private Long matches;
private Long goal_diff;
private Long goals_scored;
private Long goals_conceded;

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Long getMatches() {
        return matches;
    }

    public void setMatches(Long matches) {
        this.matches = matches;
    }

    public Long getGoal_diff() {
        return goal_diff;
    }

    public void setGoal_diff(Long goal_diff) {
        this.goal_diff = goal_diff;
    }

    public Long getGoals_scored() {
        return goals_scored;
    }

    public void setGoals_scored(Long goals_scored) {
        this.goals_scored = goals_scored;
    }

    public Long getGoals_conceded() {
        return goals_conceded;
    }

    public void setGoals_conceded(Long goals_conceded) {
        this.goals_conceded = goals_conceded;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public Pais(Long team_id, String name,String group_name, Long rank, Long points, Long matches, Long goal_diff, Long goals_scored, Long goals_conceded) {
        this.team_id = team_id;
        this.name = name;
        this.group_name=group_name;
        this.rank = rank;
        this.points = points;
        this.matches = matches;
        this.goal_diff = goal_diff;
        this.goals_scored = goals_scored;
        this.goals_conceded = goals_conceded;
    }

    public Pais() {
    }

    @Override
    public String toString() {
        return "Pais{" +
                "team_id=" + team_id +
                ", name='" + name + '\'' + ", group_name='" + group_name + '\'' +
                ", rank=" + rank +
                ", points=" + points +
                ", matches=" + matches +
                ", goal_diff=" + goal_diff +
                ", goals_scored=" + goals_scored +
                ", goals_conceded=" + goals_conceded +
                '}';
    }
}
