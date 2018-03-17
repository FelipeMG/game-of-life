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

    //World.of(3,3).livingCell(1,2).livingCell(1,3).livingCell(1,4).build();

    public static class Builder{

        private List<List<Cell>> cells;

        public Builder of(final int width, final int height){
            List<Cell> deadRow = new ArrayList<Cell>(width);
            for (int cols = 1; cols <= width; cols++) {
                deadRow.add(Cell.DEAD);
            }
            for (int rows = 1; rows < height; rows++) {
                this.cells.add(deadRow);
            }
            return this;
        }

        public Builder livingCell(final int x, final int y){
            this.cells.get(x).set(y, Cell.ALIVE);
            return this;
        }

        public World build(){
            return new World(this);
        }
    }
}
