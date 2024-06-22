package me.taako.swt.prog2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PuzzleModel {
    private final int size;
    private final List<Integer> tiles;

    public PuzzleModel(int rows, int cols) {
        this.size = rows * cols;
        this.tiles = new ArrayList<>(size);
        initTiles();
        shuffleTiles();
    }

    private void initTiles() {
        IntStream.range(0, size)
                .forEach(tiles::add);
    }

    private void shuffleTiles() {
        Collections.shuffle(tiles);
    }

    public int getTile(int index) {
        return tiles.get(index);
    }

    public int getSize() {
        return size;
    }

    public boolean isTileCorrect(int index) {
        return tiles.get(index) == index;
    }

    public boolean isSolved() {
        return IntStream.range(0, size)
                .allMatch(this::isTileCorrect);
    }

    public void swapTiles(int index1, int index2) {
        Collections.swap(tiles, index1, index2);
    }
}
