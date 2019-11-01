import java.util.LinkedList;

public class AdvancedRound extends AbsRound{

    LinkedList<IContestant> contestants;

    public AdvancedRound (LinkedList<Match> matches, LinkedList<IContestant> contestants){
        super(matches);
        this.contestants = contestants;

    }
}
