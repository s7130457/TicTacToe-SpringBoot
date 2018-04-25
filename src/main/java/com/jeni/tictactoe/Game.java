package com.jeni.tictactoe;

import javafx.util.Pair;

import java.util.Arrays;

public class Game {

    private String now = "X";
    private static String[] player = new String[9];
    private static final int[][] rule = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    public Game() {
        initPlayer();
    }
    private void initPlayer() {
        Arrays.fill(player,"");
    }

    public Pair getNextPlayer(int num) {
        if (now == "O")
            now = "X";
        else
            now = "O";
        player[num] = now;
        String win = checkWinner(player);
        Pair result = new Pair(now, win);
        return result;
    }
    public String checkWinner(String[] player) {
        String winner = "";
        for (int i = 0; i < rule.length; i++) {
            int j;
            for (j = 0; j < rule[i].length; j++) {
                if (player[rule[i][j]] != now)
                    break;
            }
            if (j == 3) {
                if (now == "O")
                    winner = "Winner: O";
                else
                    winner = "Winner: X";
            }
        }
        int tmp;
        for(tmp= 0 ; tmp < player.length ; tmp++) {
            if(player[tmp] == "") {
                break;
            }
        }
        if(tmp == player.length) {
            winner = "平手";
        }
        return winner;
    }

}
