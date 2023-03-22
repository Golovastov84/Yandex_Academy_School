package main.kontur;

import java.util.*;

public class PremierLeague {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 2 <= numberCommands <= 20
        int numberCommands = scan.nextInt();
        ArrayList<FootballTeam> footballTeams = new ArrayList<>();
        String commandLine = scan.nextLine();
        for (int i = 0; i < numberCommands; i++) {
            commandLine = scan.nextLine();
            String[] tokens = commandLine.split("\\s+", 2);
            footballTeams.add(new FootballTeam(tokens[0], Integer.valueOf(tokens[1])));
        }
        Collections.sort(footballTeams,
        Comparator.comparing(FootballTeam::getNumberPoints, Comparator.reverseOrder()).thenComparing(FootballTeam::getNameTeam,
        Comparator.naturalOrder()));
        commandLine = scan.nextLine();
        String[] lastMatch = commandLine.split("-", 2);

        StringBuilder positionAfterMatch = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            positionAfterMatch.append(positionCalculationAfterMatch(footballTeams, lastMatch, i)).append(" ");
        }
        System.out.println(positionAfterMatch.toString().trim());
        scan.close();
    }

    public static int positionCalculationAfterMatch(ArrayList<FootballTeam> footballTeams, String[] lastMatch,
                                                    int result){
        ArrayList<FootballTeam> localFootballTeams = new ArrayList<>();
        for (FootballTeam foot : footballTeams) {
            localFootballTeams.add(new FootballTeam(foot.getNameTeam(), foot.getNumberPoints()));
        }
        int position = 0;
        for (int i = 0; i < localFootballTeams.size(); i++) {
            switch (result) {
                // win
                case 0 -> {
                        if (localFootballTeams.get(i).getNameTeam().equals(lastMatch[0])) {
                            localFootballTeams.get(i).setNumberPoints(localFootballTeams.get(i).getNumberPoints() + 3);
                        }
                }
                // draw
                case 1 -> {
                        if (localFootballTeams.get(i).getNameTeam().equals(lastMatch[0])) {
                            localFootballTeams.get(i).setNumberPoints(localFootballTeams.get(i).getNumberPoints() + 1);
                        } else if (localFootballTeams.get(i).getNameTeam().equals(lastMatch[1])) {
                            localFootballTeams.get(i).setNumberPoints(localFootballTeams.get(i).getNumberPoints() + 1);
                        }
                    }
                // defeat
                case 2 -> {
                    if (localFootballTeams.get(i).getNameTeam().equals(lastMatch[1])) {
                        localFootballTeams.get(i).setNumberPoints(localFootballTeams.get(i).getNumberPoints() + 3);
                        }
                    }
                }
            }
        Collections.sort(localFootballTeams,
        Comparator.comparing(FootballTeam::getNumberPoints, Comparator.reverseOrder()).thenComparing(FootballTeam::getNameTeam,
        Comparator.naturalOrder()));
        for (int j = 0; j < localFootballTeams.size(); j++) {
            if(localFootballTeams.get(j).getNameTeam().equals(lastMatch[0])){
                position = j + 1;
            }
        }
        return position;
    }


    public static class FootballTeam {
        String nameTeam;
        int numberPoints;

        public FootballTeam(String nameTeam, int numberPoints) {
            this.nameTeam = nameTeam;
            this.numberPoints = numberPoints;
        }

        public String getNameTeam() {
            return nameTeam;
        }

        public void setNameTeam(String nameTeam) {
            this.nameTeam = nameTeam;
        }

        public int getNumberPoints() {
            return numberPoints;
        }

        public void setNumberPoints(int numberPoints) {
            this.numberPoints = numberPoints;
        }

        @Override
        public int hashCode(){
            return Objects.hash(nameTeam, numberPoints);
        }
    }
}

