package com.jeni.tictactoe;

import javafx.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    private static  Game game = null;
    @RequestMapping("/")
    public String index() {
        game = new Game();
        return "index.html";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.DELETE)
    @ResponseBody
    public String reset() {
        game = new Game();
        String next = game.getNext();
        return next;
    }

    @RequestMapping(value = "/ooxxRequest", method = RequestMethod.POST)
    @ResponseBody
    public Pair handler(@RequestParam("num") int num) {
        Pair result = game.getNextPlayer(num);
        return result;
    }



}
