package DeveloperDAO;

import Developer.Developer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class DeveloperDAO implements InterfaceDAO {
    private File file = new File("developers.txt");
    private File tempFile = new File("removeDev.txt");
    private Scanner scn=new Scanner(System.in);


    @Override
    public void save(Developer developer) {
        String devToString = "";

        devToString += developer.getId() + ",";
        devToString += developer.getFirstName() + ",";
        devToString += developer.getSecondName() + ",";
        devToString += developer.getExperience() + ",";
        devToString += developer.getSalary() + "\n";
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)) {
            fileOutputStream.write(devToString.getBytes());
        } catch (NumberFormatException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Developer developer) throws IOException {
        remove(developer);

    }

    @Override
    public void remove(Developer developer) throws IOException {
        List<String> list=new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                if (currentLine.isEmpty()) {
                    continue;
                }
                list.add(currentLine);
            }

try {

    list.remove(Integer.parseInt(scn.next()));
}catch (NumberFormatException e){
    System.out.println("Введите индекс!");remove(developer);}
    catch (IndexOutOfBoundsException i){
        System.out.println("Под таким индексом нет разработчика!");remove(developer);
    }
            try (FileWriter fileWriter=new FileWriter(tempFile,true)){
                for (String line:list) {

                    fileWriter.write(line);
                    fileWriter.write(System.getProperty("line.separator"));
                } fileWriter.flush();
            }
            catch (IOException e){e.getStackTrace();
            }
              fileReader.close();
            bufferedReader.close();
            if (!file.delete()){
                System.out.println("Не удалось удалить файл!");
                return;
            }
            if (!tempFile.renameTo(file)){
                System.out.println("Could not rename file");
            }

        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Developer getById(Long id) {

        Developer developer = new Developer();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                String[] arrayOfSplit = line.split(",");
                while (Long.parseLong(arrayOfSplit[0]) != id) {
                    if (Long.parseLong(arrayOfSplit[0]) == id) {
                        developer.setId(Long.valueOf(arrayOfSplit[0]));
                        developer.setFirstName(arrayOfSplit[1]);
                        developer.setSecondName(arrayOfSplit[2]);
                        developer.setExperience(Integer.valueOf(arrayOfSplit[3]));
                        developer.setSalary(Integer.valueOf(arrayOfSplit[4]));
                        System.out.println(developer);

                    } else {
                        System.out.println("Такого разработчика нету!");


                    }
                }

            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return developer;
    }

    @Override
    public Collection getAll() {
        Developer developer = new Developer();
        List<String> list = new ArrayList<String>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                String[] arrayOfSplit = line.split(",");
                developer.setId(Long.valueOf(arrayOfSplit[0]));
                developer.setFirstName(arrayOfSplit[1]);
                developer.setSecondName(arrayOfSplit[2]);
                developer.setExperience(Integer.valueOf(arrayOfSplit[3]));
                developer.setSalary(Integer.valueOf(arrayOfSplit[4]));
                list.add(String.valueOf(developer));


            }
            System.out.println(list);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}