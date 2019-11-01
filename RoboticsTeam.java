public class RoboticsTeam implements IContestant{
    String school;
    String specialFeature;
    double previousMatchScore;

    public RoboticsTeam(String school, String specialFeature, double previousMatchScore){
        this.school = school;
        this.specialFeature = specialFeature;
        this.previousMatchScore = previousMatchScore;
    }

    public boolean expectToBeat(RoboticsTeam anotherTeam){
        return (this.previousMatchScore > anotherTeam.previousMatchScore);
    }
}
