import junit.framework.TestCase;
import main.kontur.PremierLeague;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PremierLeagueTest extends TestCase {
    ArrayList<PremierLeague.FootballTeam> footballTeams;
    String[] lastMatch;
    @Override
    protected void setUp() throws Exception {
        int numberCommands = 7;
        footballTeams = new ArrayList<>();
        footballTeams.add(new PremierLeague.FootballTeam("ZENIT", 65));
        footballTeams.add(new PremierLeague.FootballTeam("SOCHI", 56));
        footballTeams.add(new PremierLeague.FootballTeam("DINAMO", 53));
        footballTeams.add(new PremierLeague.FootballTeam("CSKA", 50));
        footballTeams.add(new PremierLeague.FootballTeam("KRASNODAR", 49));
        footballTeams.add(new PremierLeague.FootballTeam("LOKOMOTIV", 48));
        footballTeams.add(new PremierLeague.FootballTeam("AKHMAT", 41));
        Collections.sort(footballTeams,
        Comparator.comparing(PremierLeague.FootballTeam::getNumberPoints, Comparator.reverseOrder()).thenComparing(PremierLeague.FootballTeam::getNameTeam,
        Comparator.naturalOrder()));
        lastMatch = new String[2];
        lastMatch[0] = "KRASNODAR";
        lastMatch[1] = "AKHMAT";
        StringBuilder positionAfterMatch = new StringBuilder();



    }

    public void testCalculateDuration() {

        StringBuilder positionAfterMatch = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            positionAfterMatch.append(PremierLeague.positionCalculationAfterMatch(footballTeams, lastMatch, i)).append(" ");
        }
// метод проведения теста
        String actual = positionAfterMatch.toString().trim();
        String expected = "4 5 5";
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
// метод удаления данных
    }
}
