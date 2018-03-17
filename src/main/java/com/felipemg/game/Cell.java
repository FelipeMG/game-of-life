package com.felipemg.game;

public enum Cell {
    ALIVE {
        public Cell next(int aliveNeighbors) {
            if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                return DEAD;
            }
            return this;
        }
    },
    DEAD {
        public Cell next(int aliveNeighbors) {
            if (aliveNeighbors == 3) {
                return ALIVE;
            }
            return this;
        }
    };
    public abstract Cell next(int aliveNeighbors);
}