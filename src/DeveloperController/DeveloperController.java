package DeveloperController;

import Developer.Developer;
import DeveloperDAO.DeveloperDAO;

import java.io.IOException;
import java.util.Scanner;

public class DeveloperController {
    private Scanner scn = new Scanner(System.in);
    private DeveloperDAO developerDAO = new DeveloperDAO();
    private Developer developer = new Developer();

    public void add() {
        try {
            System.out.println("Введите id :");
            developer.setId(Long.parseLong(scn.next()));
            System.out.println("Введите имя :");
            developer.setFirstName(scn.next());
            System.out.println("Введите фамилию :");
            developer.setSecondName(scn.next());
            System.out.println("Введите опыт работы:");
            developer.setExperience(Integer.parseInt(scn.next()));
            System.out.println("Введите зарплату :");
            developer.setSalary(Integer.parseInt(scn.next()));
            developerDAO.save(developer);
            System.out.println("Разработчик " + developer + " был добавлен.");
        } catch (NumberFormatException e) {
            e.getStackTrace();
            add();
        }
    }

    public void update() throws IOException {
        remove();
        try {
            System.out.println();
            System.out.println("Введите id :");
            developer.setId(Long.parseLong(scn.next()));
            System.out.println("Введите имя :");
            developer.setFirstName(scn.next());
            System.out.println("Введите фамилию :");
            developer.setSecondName(scn.next());
            System.out.println("Введите опыт работы:");
            developer.setExperience(Integer.parseInt(scn.next()));
            System.out.println("Введите зарплату :");
            developer.setSalary(Integer.parseInt(scn.next()));
            developerDAO.save(developer);
        } catch (NumberFormatException e) {
            e.getStackTrace();
            add();

    }}

    public void remove() throws IOException {
developerDAO.remove(developer);
    }

    public void getByID() {
        try {
            System.out.println("Введите ID:");
            developerDAO.getById(Long.parseLong(scn.next()));
        } catch (NumberFormatException e) {
            e.getStackTrace();
            System.out.println("В ID есть только числа!");
            getByID();
        }
    }

    public void getAll() {
        developerDAO.getAll();
    }


}
