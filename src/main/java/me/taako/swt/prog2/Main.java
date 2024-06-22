package me.taako.swt.prog2;

import me.taako.swt.prog2.controller.PuzzleController;
import me.taako.swt.prog2.model.PuzzleModel;
import me.taako.swt.prog2.view.PuzzleView;

public class Main {
    public static void main(String[] args) {
        PuzzleModel model = new PuzzleModel(4, 4);
        PuzzleView view = new PuzzleView(model);
        PuzzleController controller = new PuzzleController(model, view);
        controller.initController();
    }
}