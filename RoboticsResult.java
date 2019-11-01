public class RoboticsResult implements IResult {

    RoboticsTeam team1;
    RoboticsTeam team2;
    double team1points;
    int team1tasks;
    boolean team1fell;
    double team2points;
    int team2tasks;
    boolean team2fell;

    public RoboticsResult (RoboticsTeam team1, RoboticsTeam team2,
                           double team1points, int team1tasks, boolean team1fell,
                           double team2points, int team2tasks, boolean team2fell) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1points = team1points;
        this.team1tasks = team1tasks;
        this.team1fell = team1fell;
        this.team2points = team2points;
        this.team2tasks = team2tasks;
        this.team2fell = team2fell;
    }


    //checks if one team's overall results are valid
    public boolean isOneTeamValid(double someTeamsPoints, int someTeamsTasks) {
        return ((someTeamsPoints<=16) && (someTeamsTasks<8));
    }

    //checks if the overall results of the match are valid
    public boolean isValid() {
        return ((team1points<=16) && (team1tasks<8)) &&
                ((team2points<=16) && (team2tasks<8));
    }


    //consumes a team's set of points, tasks, and a fall status and calculates the team's score
    public double getScore(double somePoints, int someTasks, boolean fallStatus) {
       if(fallStatus) {
           if ((team1points == somePoints) && (team1tasks == someTasks) && (team1fell == fallStatus)) {
               return (team1points + team1tasks - 5);
           } else {
               return (team2points + team2tasks - 5);
           }
       }
        else {
           if ((team1points == somePoints) && (team1tasks == someTasks) && (team1fell == fallStatus)) {
               return (team1points + team1tasks);
           } else {
               return (team2points + team2tasks);
           }
        }
    }


    public IContestant getWinner(){
        if (getScore(team1points, team1tasks, team1fell)
                > getScore(team2points, team2tasks, team2fell)) {
            return team1;
        }

        else if (getScore(team2points, team2tasks, team2fell)
                > getScore(team1points, team1tasks, team1fell)) {
            return team2;
        }
        else {
            return null;
        }
    }

}
