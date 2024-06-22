package me.taako.swt.prog2.controller;

import me.taako.swt.prog2.model.PuzzleModel;
import me.taako.swt.prog2.view.PuzzleView;

import javax.swing.*;
import java.util.List;
import java.util.stream.IntStream;

public class PuzzleController {
    private final PuzzleModel model;
    private final PuzzleView view;

    public PuzzleController(PuzzleModel model, PuzzleView view) {
        this.model = model;
        this.view = view;
    }

    public void initController() {
        List<JButton> buttons = view.getButtons();
        IntStream.range(0, buttons.size())
                .forEach(i -> buttons.get(i)
                        .addActionListener(e -> handleButtonClick(i)));
    }

    private void handleButtonClick(int index) {
        int size = model.getSize();
        int sqrtSize = (int) Math.sqrt(size);
        int emptyTile = size - 1;

        if (index % sqrtSize != 0 && model.getTile(index - 1) == emptyTile) {
            model.swapTiles(index, index - 1);
        } else if ((index + 1) % sqrtSize != 0 && model.getTile(index + 1) == emptyTile) {
            model.swapTiles(index, index + 1);
        } else if (index >= sqrtSize && model.getTile(index - sqrtSize) == emptyTile) {
            model.swapTiles(index, index - sqrtSize);
        } else if (index < size - sqrtSize && model.getTile(index + sqrtSize) == emptyTile) {
            model.swapTiles(index, index + sqrtSize);
        }

        view.update();

        if (model.isSolved()) {
            JOptionPane.showMessageDialog(view, "Puzzle gelöst!");
        }
    }
}