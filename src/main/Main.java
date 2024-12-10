package main;

import resources.Loader;

public class Main {
    public static void main(String[] args){
        Loader loader = new Loader();
        loader.load();
        Engine.init();
        Engine.start();     
    }
}