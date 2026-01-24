package HospitalManagementSystem;

import HospitalManagementSystem.menu.HospitalMenu;
import HospitalManagementSystem.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new HospitalMenu();
        menu.run();
    }
}
