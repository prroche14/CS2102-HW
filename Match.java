public class Match{

    IContestant team1;
    IContestant team2;
    IResult matchOutcome;

    public Match (IContestant team1, IContestant team2,IResult matchOutcome){
        this.team1 = team1;
        this.team2 = team2;
        this.matchOutcome = matchOutcome;

    }

    public IContestant winner()
    {
        if (matchOutcome.isValid()) {
            return matchOutcome.getWinner();
        } else {
            return null;
        }
    }

}
