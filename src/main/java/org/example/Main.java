package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Main {
    public static void main(String[] args) {
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        for (int i = 0; i < 1000; i++) {
            Game game = new Game(true, false);
            game.startGame();
            System.out.println(game.isWinResult());
            descriptiveStatistics.addValue(game.isWinResult() ? 1:0);
        }
        System.out.println(descriptiveStatistics.getSum());
    }
}