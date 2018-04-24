package com.jeni.tictactoe;

import javafx.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
    private String value = "X";
    private static final int[][] lines = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    private static String[] player = new String[9];

    @RequestMapping("/")
    public String index() {
        initPlayer();
        return "index.html";
    }

    private void initPlayer() {
        for (int i = 0; i < player.length; i++) {
            player[i] = "";
        }
    }


    @RequestMapping(value = "/ooxxRequest", method = RequestMethod.POST)
    @ResponseBody
    public Pair handler(@RequestParam("num") int num) {
        if (value == "O")
            value = "X";
        else
            value = "O";
        player[num] = value;
        String win = checkWinner(player);

        Pair result = new Pair(value, win);
        return result;
    }

    public String checkWinner(String[] player) {
        String winner = "";
        for (int i = 0; i < lines.length; i++) {
            int j;
            for (j = 0; j < lines[i].length; j++) {
                if (player[lines[i][j]] != value)
                    break;
            }
            if (j == 3) {
                if (value == "O")
                    winner = "O";
                else
                    winner = "X";
            }
        }

        return winner;

    }


}
