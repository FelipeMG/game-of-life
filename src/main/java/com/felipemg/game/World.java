package com.felipemg.game;

import com.felipemg.game.util.Printer;

import java.util.ArrayList;
import java.util.List;

public final class World {

    private List<List<Cell>> cells;

    public World(final List<String> world){

    }
    /*
    public World(final File file){
        this(Files.readAllLines())
    }
    */

    private World(final Builder builder){
        this.cells = builder.cells;
    }

    public static class Builder{

        private List<List<Cell>> cells = new ArrayList<List<Cell>>();

        public Builder of(final int width, final int height){
            for (int rows = 1; rows <= height; rows++) {
                List<Cell> deadRow = new ArrayList<Cell>(width);
                for (int cols = 1; cols <= width; cols++) {
                    deadRow.add(Cell.DEAD);
                }
                this.cells.add(deadRow);
            }
            return this;
        }

        public Builder livingCell(final int x, final int y){
            this.cells.get(x-1).set(y-1, Cell.ALIVE);
            return this;
        }

        public World build(){
            return new World(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (List<Cell> list: cells) {
            for (Cell cell: list) {
                if (cell.equals(Cell.ALIVE)){
                    builder.append("*");
                }
                else{
                    builder.append("-");
                }
            }
            builder.append(Printer.NEW_LINE);
        }
        return builder.toString();
    }
}
