package me.taako.swt.prog2.view;

import me.taako.swt.prog2.model.PuzzleModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PuzzleView extends JFrame {
    private final List<JButton> buttons = new ArrayList<>();
    private final PuzzleModel model;

    public PuzzleView(PuzzleModel model) {
        this.model = model;
        int gridSize = (int) Math.sqrt(model.getSize());

        setLayout(new GridLayout(gridSize, gridSize, 5, 5));
        initButtons();
        setupWindow();
    }

    private void setupWindow() {
        setTitle("Schiebe-Puzzle");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initButtons() {
        int size = model.getSize();
        IntStream.range(0, size)
                .forEach(i -> {
                    JButton button = createButton();
                    buttons.add(button);
                    add(button);
                });

        update();
    }

    private JButton createButton() {
        JButton button = new JButton();
        button.setOpaque(true);
        button.setBorderPainted(false);
        return button;
    }

    public List<JButton> getButtons() {
        return buttons;
    }

    public void update() {
        int size = model.getSize();
        Color correctColor = Color.GREEN;
        Color incorrectColor = Color.ORANGE;

        IntStream.range(0, size)
                .forEach(i -> {
                    JButton button = buttons.get(i);
                    int tile = model.getTile(i);

                    if (tile != size - 1) {
                        button.setText(String.valueOf(tile + 1));
                        button.setBackground(model.isTileCorrect(i)
                                ? correctColor
                                : incorrectColor);
                    } else {
                        button.setText("");
                        button.setBackground(null);
                    }
                });
    }
}
