package com.bbusa.bbusa.Entity;

public enum BeltColor {
    WHITE(0), ORANGE(1), YELLOW(2), GREEN(3), PURPLE(4), BLUE(5),
    BROWN(6), RED(7), REDDOUBLESTRIPE(8), REDBLACK(9), BLACKFIRSTDEGREE(10),
    BLACKSECONDDEGREE(11), BLACKTHIRDDEGREE(12);

    private int value;
    BeltColor(int index){
        this.value = index;
    }
    public int getValue(){return value;}
}
