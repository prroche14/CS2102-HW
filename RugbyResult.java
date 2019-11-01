public class RugbyResult implements IResult {

    RugbyTeam team1;
    RugbyTeam team2;
    double team1Points;
    double team2Points;

    public RugbyResult(RugbyTeam team1, RugbyTeam team2, double team1Points, double team2Points) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Points = team1Points;
        this.team2Points = team2Points;
    }

//checks to see if the teams scores are valid
    public boolean isValid() {
        if (team1Points <150 && team2Points <150) {
            return true;
        } else {
            return false;
        }
    }

//produces the team with a higher score
    public IContestant getWinner() {
            if (team1Points > team2Points) {
                return team1;
            }
            return team2;
        }
        }



