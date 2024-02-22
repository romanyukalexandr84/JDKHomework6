package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Main {
    private static final int NUMBER_OF_GAMES = 1000;

    //метод запуска цикла игр и вывода статистики
    private static void cycleGame (boolean playerChangedDoor) {
        String str = playerChangedDoor ? "поменявшего" : "не менявшего";
        DescriptiveStatistics playerStats = new DescriptiveStatistics();
        for (int i = 0; i < NUMBER_OF_GAMES; i++) {
            Game game = new Game(playerChangedDoor, false);
            game.startGame();
            playerStats.addValue(game.isWinResult() ? 1:0);
        }
        System.out.println("Количество побед для игрока " + str + " изначальный выбор = "
                + playerStats.getSum());
        System.out.println("Количество поражений для игрока " + str + " изначальный выбор = "
                + (NUMBER_OF_GAMES - playerStats.getSum()));
        System.out.println("Процент побед для игрока " + str + " изначальный выбор = "
                + Math.round(playerStats.getSum() / NUMBER_OF_GAMES * 100) + "%\n");
    }

    public static void main(String[] args) {
        cycleGame(true);
        cycleGame(false);
    }
}