package week4.maiin;

import week4.menu.HospitalMenu;
import week4.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new HospitalMenu();
        menu.run();
    }
}
