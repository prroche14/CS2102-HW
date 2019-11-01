//Claire Dollins (username: cmdollins) and Patrick Roche (username: prroche)

import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {


    //RoboticsTeam examples
    RoboticsTeam knightsRobotics = new RoboticsTeam
            ("North Andover", "passiveTranmsission", 24);
    RoboticsTeam paralax = new RoboticsTeam
            ("Phillips Academy", "eightBarLinkages", -3);
    RoboticsTeam roboDogs = new RoboticsTeam
            ("Bancroft", "strongDriveTrain", 12);
    RoboticsTeam hopkinetics = new RoboticsTeam
            ("Hopkinton", "laserBeams", 12);
    RoboticsTeam bigMeatyClaws = new RoboticsTeam
            ("North Andover", "bigMeatyClaw", 17);
    RoboticsTeam fuzzyWuzzy = new RoboticsTeam
            ("West Idaho Regional", "greasedBearings", 23);
    RoboticsTeam blankDot = new RoboticsTeam
            ("Singapore STEM Academy", "passiveTransmission", 0);

    //RoboticsResult examples
    RoboticsResult gooseEggMatch = new RoboticsResult
            (roboDogs, paralax,
                    0, 0, false,
                    0,0, true);
    RoboticsResult bothFieldsExceedMatch = new RoboticsResult
            (bigMeatyClaws, fuzzyWuzzy,
                    28, 11, true,
                    15, 7, false);
    RoboticsResult highPointsMatch = new RoboticsResult
            (blankDot, paralax,
                    17, 7, false,
                    14, 4, true);
    RoboticsResult highTasksMatch = new RoboticsResult
            (blankDot, paralax,
                    14, 9, false,
                    1, 4, true);

    RoboticsResult grandFinalsMatch1 = new RoboticsResult
            (knightsRobotics, paralax,
                    16, 6, false,
                    16, 7, true);
    RoboticsResult grandFinalsMatch2 = new RoboticsResult
            (knightsRobotics, paralax,
                    10, 4, false,
                    7, 8, false);
    RoboticsResult grandFinalsMatch3 = new RoboticsResult
            (knightsRobotics, paralax,
                    14, 6, false,
                    6, 1, true);

    //Match examples for robotics
    Match validRoboticsTestMatch = new Match(knightsRobotics, paralax, grandFinalsMatch1);
    Match edgeRoboticsTestMatch = new Match(knightsRobotics, paralax, grandFinalsMatch2);
    Match invalidRoboticsTestMatch = new Match(blankDot, paralax, highPointsMatch);

    //expectToBeat test cases for robotics teams

    //tests a team with a positive score against a negative team
    @Test
    public void testKnightsExpectToBeatParalax() { assertTrue(knightsRobotics.expectToBeat(paralax)); }

    //tests a team with a negative score against a positive team
    @Test
    public void testParalaxExpectToBeatKnights() { assertFalse(paralax.expectToBeat(knightsRobotics)); }

    //tests a team with a zero score against a negative team
    @Test
    public void testBlankDotExpectToBeatParalax() { assertTrue(blankDot.expectToBeat(paralax)); }

    //tests a team with a negative score against a zero team
    @Test
    public void testParalaxExpectToBeatBlankDot() { assertFalse(paralax.expectToBeat(blankDot)); }

    //tests a positive-scored team against a lower-scored team
    @Test
    public void testKnightsExpectToBeatFuzzyWuzzy() { assertTrue(knightsRobotics.expectToBeat(fuzzyWuzzy)); }

    //tests a positive-scored team against a higher-scored team
    @Test
    public void testFuzzyWuzzyExpectToBeatKnights() {
        assertFalse(fuzzyWuzzy.expectToBeat(knightsRobotics));
    }

    @Test
    //tests a team against another with the same score
    public void testRoboDogsExpectToBeatHopkinetics() { assertFalse(roboDogs.expectToBeat(hopkinetics)); }

    //tests a team against another with the same score
    @Test
    public void testHopkineticsExpectToBeatRoboDogs() { assertFalse(hopkinetics.expectToBeat(roboDogs)); }

    //teams a team against itself
    @Test
    public void testKnightsExpectToBeatItself() { assertFalse(knightsRobotics.expectToBeat(knightsRobotics)); }

    //tests for isValid method on robotics results

    //tests a robotics result in which both team's points and scores are within the boundaries
    @Test
    public void testUnambiguousResult() {
        assertTrue(grandFinalsMatch3.isValid());
    }

    //tests a robotics result in which both team's points and tasks are 0
    @Test
    public void testAllZeroes() {
        assertTrue(gooseEggMatch.isValid());
    }

    //tests a robotics result where one team has 16 points and less than 8 tasks
    @Test
    public void testAPointsEdgeCase() {
        assertTrue(grandFinalsMatch1.isValid());
    }

    //tests a robotics result where one team has 8 tasks and less than 16 points
    @Test
    public void testATasksEdgeCase() { assertFalse(grandFinalsMatch2.isValid()); }

    //tests a robotics result where one team's points exceeds 16
    @Test
    public void pointsExceedMatch() {
        assertFalse(highPointsMatch.isValid());
    }

    //tests a robotics result where one team's tasks exceed 8
    @Test
    public void tasksExceedMatch() {
        assertFalse(highTasksMatch.isValid());
    }

    //tests a match where one team's values both exceed their limits
    @Test
    public void testOverscoreResult() {
        assertFalse(bothFieldsExceedMatch.isValid());
    }


    //tests getScore on robotics results

    //tests getScore when a robotics team falls and has points and tasks that sum to less than 5
    @Test
    public void testParalaxInFinals() {
        assertEquals(18, grandFinalsMatch1.getScore(1,2,true),0.1);
    }

    //tests getScore when a team falls and has points and tasks that sum to 5
    @Test
    public void testParalaxInHighTask() {
        assertEquals(0, highTasksMatch.getScore(1,4,true),0.1);
    }

    //tests getScore on a team that does not fall down
    @Test
    public void testKnightsInFinals1() { assertEquals(22, grandFinalsMatch1.getScore(16,6,false),0.1); }

    //tests get score on a team who falls down and has points and tasks that add to more than 5
    @Test
    public void testParalaxInFinals3() {
        assertEquals(2, grandFinalsMatch3.getScore(6,1,true),0.1);
    }


    //tests getWinner method on robotics results

    //tests a Robotics result where team1 is the winner
    @Test
    public void testGrandFinalsMatch3(){ assertEquals(knightsRobotics, grandFinalsMatch3.getWinner());}

    //tests a Robotics match where the winner is decided by a fall status
    @Test
    public void testGrandFinalsMatch1(){ assertEquals(knightsRobotics, grandFinalsMatch1.getWinner());}

    //tests a robotics match where team2 is the winner
    @Test
    public void testGrandFinalsMatch2(){ assertEquals(paralax, grandFinalsMatch2.getWinner());}

    //tests winner method on robotics matches

    //tests a robotics a valid robotics match
    @Test
    public void testRoboValidWinner(){ assertEquals(knightsRobotics, validRoboticsTestMatch.winner());}

    //tests a robotics an edge case robotics match
    @Test
    public void testRoboEdgeWinner(){ assertEquals(null, edgeRoboticsTestMatch.winner());}

    //tests a robotics an invalid robotics match
    @Test
    public void testRoboInvalidWinner(){ assertEquals(null, invalidRoboticsTestMatch.winner());}

    //RugbyTeam examples
    RugbyTeam team1 = new RugbyTeam("blue","USA",true,7,0);
    RugbyTeam team2 = new RugbyTeam("red","Canada",false,10,1);
    RugbyTeam team3 = new RugbyTeam("purple","Mexico",true,11,2);
    RugbyTeam team4 = new RugbyTeam("black","Brazil",false,2,12);
    RugbyTeam team5 = new RugbyTeam("green","England",true,0,3);

    //RugbyResult examples
    RugbyResult game1 = new RugbyResult(team1,team2,120,100);
    RugbyResult game2 = new RugbyResult(team5,team3,100,90);
    RugbyResult game3 = new RugbyResult(team4,team2,120,130);
    RugbyResult game4 = new RugbyResult(team1,team5,175,200);
    RugbyResult game5 = new RugbyResult(team4,team3,200,110);

    //Match examples for rugby
    Match match1 = new Match(team1,team2,game1);
    Match match2 = new Match(team5, team3,game2);
    Match match3 = new Match(team4,team2,game3);
    Match match4 = new Match(team1,team5,game4);
    Match match5 = new Match(team4,team3,game5);

    
    //Tests for isValid method

    //Testing isValid when both teams have too many points
    @Test
    public void testGame4IsValid(){ assertFalse(game4.isValid());}

    //Testing isValid when only one team has too many points
    @Test
    public void testGame5IsValid(){ assertFalse(game5.isValid());}

    // Testing isValid when both teams have a valid amount of points
    @Test
    public void testGame1IsValid(){assertTrue(game1.isValid());}

    //testing isValid when both teams have a valid amount of points
    @Test
    public void testGame2IsValid(){ assertTrue(game2.isValid());}

    //testing isValid when both teams have a valid amount of points
    @Test
    public void testGame3IsVaild(){ assertTrue(game3.isValid());}



    //Tests for isRitual method

    //Testing isRitual when the team has a ritual
    @Test
    public void testTeam1IsRitual(){ assertTrue(team1.isRitual());}

    //Testing IsRitual when the team has no ritual
    @Test
    public void testTeam2IsRitual() { assertFalse(team2.isRitual());}


    //Tests for getWins method

    //testing getWins when the team has 7 wins
    @Test
    public void testTeam1GetWins() { assertEquals(7,team1.getWins());}

    //testing getWins when the team has 10 wins
    @Test
    public void testTeam2GetWins(){ assertEquals(10,team2.getWins());}

    //testing getWins when the team has no wins
    @Test
    public void testTeam5Getwins() { assertEquals(0,team5.getWins());}



    //Tests for getLosses Method

    //testing getLosses when the team has 2 losses
    @Test
    public void testTeam3GetLosses(){ assertEquals(2,team3.getLosses());}

    //testing getLosses when the team has 12 losses
    @Test
    public void testTeam4GetLosses () {assertEquals(12,team4.getLosses());}

    //testing getLosses when the team has no losses
    @Test
    public void testTeam1GetLosses() {assertEquals(0,team1.getLosses());}



    //Tests for expectToBeat method on Rugby teams

    //testing expectedToBeat when the team has a ritual and the other dose not
    @Test
    public void testTeam1ExpectToBeatTeam2() {assertTrue(team1.expectToBeat(team2));}

    //testing expectedToBeat when the team as no ritual and the other team dose
    @Test
    public void testTeam2ExpectToBeatTeam1() {assertFalse(team2.expectToBeat(team1));}

    //testing expectedToBeat when neither team has a ritual
    @Test
    public void testTeam4ExpectToBeatTeam2() {assertFalse(team4.expectToBeat(team2));}

    //testing expectedToBeat when both teams have a ritual
    @Test
    public void testTeam5ExpectToBeatTeam3() {assertFalse(team5.expectToBeat(team3));}



    //Tests for getWinner method on rugby results

    //testing getWinner when both scores are valid
    @Test
    public void testGetWinnerGame1() {assertEquals(team1,game1.getWinner());}

    //testing getWinner when both scores are valid
    @Test
    public void testGetWinnerGame2() {assertEquals(team5,game2.getWinner());}

    //testing getWinner when both scores are valid
    @Test
    public void testGetWinnerGame3() {assertEquals(team2,game3.getWinner());}

    //testing getWinner when both scores are invalid
    @Test
    public void testGetWinnerGame4() {assertEquals(team5,game4.getWinner());}

    // testing getWinner when only one score is valid and the other is invalid
    @Test
    public void testGetWinnerGame5() {assertEquals(team4,game5.getWinner());}



    //Tests for winner method on rugby

    //testing winner when both scores are valid
    @Test
    public void testWinnerMatch1(){ assertEquals(team1,match1.winner());}

    //testing winner when both scores are valid
    @Test
    public void testWinnerMatch2() {assertEquals(team5,match2.winner());}

    //testing winner when both scores are valid
    @Test
    public void testWinnerMatch3() {assertEquals(team2,match3.winner());}

    //testing winner when both scores are invalid
    @Test
    public void testWinnerMatch4() {assertEquals(null,match4.winner());}

    // testing winner when only one score is valid and the other is invalid
    @Test
    public void testWinnerMatch5() {assertEquals(null,match5.winner());}

}
