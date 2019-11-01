public class RugbyTeam implements IContestant {

    private String jerseyColor;
    private String country;
    private boolean ritual;
    private int wins;
    private int losses;

    public RugbyTeam(String jerseyColor, String country, boolean ritual, int wins, int losses) {
        this.jerseyColor = jerseyColor;
        this.country = country;
        this.ritual = ritual;
        this.wins = wins;
        this.losses = losses;
    }
//checks to see if the team has a ritual
    public boolean isRitual() {
        return ritual;
    }
//checks the number of wins a team has
    public int getWins() {
        return wins;
    }
//checks the number of losses a team has
    public int getLosses() {
        return losses;
    }
//checks to see if the team is expected to win based on if they have a ritual or if the team has a
    //higher win to lose ratio
    public boolean expectToBeat (RugbyTeam otherTeam) {
        if(this.ritual && !otherTeam.isRitual()){
            return true;
        }
        if(!this.ritual && otherTeam.isRitual()) {
            return false;
        }
        int deltaWinsThis = this.wins - this.losses;
        int deltaWinsOthers = otherTeam.getWins() - otherTeam.getLosses();
        if(deltaWinsThis > deltaWinsOthers){
            return true;
        }
        return false;
    }
}