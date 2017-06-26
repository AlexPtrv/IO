package DeveloperView;

import DeveloperController.DeveloperController;

import java.io.IOException;
import java.util.Scanner;

public class DeveloperView {
private Scanner scn=new Scanner(System.in);
private static int selection;
private DeveloperController developerController=new DeveloperController();
    void start() throws IOException {
        System.out.println("Загрузка....");
        System.out.println("Меню:");
        menu();
        choiceInMenu();
}
private void menu(){
    System.out.println("1.Добавить разроботчика.\n" + "2.Удалить разработчика.\n" + "3.Изменить разработчика.\n" + "4.Найти по ID разработчика.\n" +
            "5.Показать всех разработчиков.\n" + "6.Выйти.\n");
}
private void choiceInMenu() throws IOException {
        selection = scn.nextInt();
        do {
            switch (selection) {
                case 1:
                    developerController.add();
                    menuOrExit();
                    break;
                case 2:
                    developerController.remove();
                    menuOrExit();
                    break;
                case 3:
                    developerController.update();
                    menuOrExit();
                    break;
                case 4:
                    developerController.getByID();
                    menuOrExit();
                    break;
                case 5:
                    developerController.getAll();
                    menuOrExit();
                    break;
                case 6:
                    exit();
                    break;


}
}while (selection != 6);}

    private void menuOrExit() throws IOException {
        System.out.println("Елси хотите вернутся в меню нажмите 1.\n" + "Если выйти нажмите 2.");

        selection = scn.nextInt();

        do {
            switch (selection) {
                case 1:
                    menu();
                    choiceInMenu();
                    break;
                case 2:
                    exit();
                    break;

                default:
                    menuOrExit();
                    break;
            }
        } while (selection != 2);
    }


    private void exit() {

        System.out.println("Выход...");
        System.exit(0);
    }
}