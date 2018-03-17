package com.felipemg.game;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.felipemg.game.util.Printer;
import org.junit.Before;
import org.junit.Test;

public class WorldTest {

    private StringBuilder builder;

    @Before
    public void init(){
        this.builder = new StringBuilder();
    }

    @Test
    public void deadWorldOf3Times3(){
        World world = new World.Builder().of(3,3).build();
        builder.append("---").append(Printer.NEW_LINE);
        builder.append("---").append(Printer.NEW_LINE);
        builder.append("---").append(Printer.NEW_LINE);
        assertThat(world.toString(), is(builder.toString()));
    }

    @Test
    public void deadWorldOf3Times4(){
        World world = new World.Builder().of(3,4).build();
        builder.append("---").append(Printer.NEW_LINE);
        builder.append("---").append(Printer.NEW_LINE);
        builder.append("---").append(Printer.NEW_LINE);
        builder.append("---").append(Printer.NEW_LINE);
        assertThat(world.toString(), is(builder.toString()));
    }

    @Test
    public void worldOf3Times4WithLivingCellIn2_3(){
        World world = new World.Builder().of(3,4).livingCell(2,3).build();
        builder.append("---").append(Printer.NEW_LINE);
        builder.append("--*").append(Printer.NEW_LINE);
        builder.append("---").append(Printer.NEW_LINE);
        builder.append("---").append(Printer.NEW_LINE);
        assertThat(world.toString(), is(builder.toString()));
    }

    @Test
    public void worldOf3Times4WithLivingCellIn2_3AndIn3_1(){
        World world = new World.Builder().of(3,4)
                .livingCell(2,3)
                .livingCell(3,1)
                .build();
        builder.append("---").append(Printer.NEW_LINE);
        builder.append("--*").append(Printer.NEW_LINE);
        builder.append("*--").append(Printer.NEW_LINE);
        builder.append("---").append(Printer.NEW_LINE);
        assertThat(world.toString(), is(builder.toString()));
    }

}
