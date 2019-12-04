package Printer;

public enum Colors {
    DEFAULT("\033[0m"),
    RED("\033[0;31m"),
    BLUE("\033[0;34m"),
    CIAN("\033[0;36m"),
    GREEN("\033[0;32m"),
    WHITE("\033[0;37m");

    private String color;

    Colors(String s) {
        this.color = s;
    }

    public String getColor(){
        return  color;
    }
}
