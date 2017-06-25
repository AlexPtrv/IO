package DeveloperDAO;

import Developer.Developer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeveloperDAO implements InterfaceDAO {
    private File file = new File("developers.txt");
    private File tempFile = new File("removeDev.txt");


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
            System.out.println("Разработчик " + developer + " был добавлен.");
        } catch (NumberFormatException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Developer developer) {
        //remove();
        // save();
    }

    @Override
    public void remove(Developer developer) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<String>();
        String currentLine;
        try {
            while ((currentLine = bufferedReader.readLine()) != null) {
                if (currentLine.isEmpty()) {
                    continue;
                }
                list.add(currentLine);
            }
            System.out.println(list);
            list.remove(developer);
            try (FileWriter fileWriter = new FileWriter(tempFile, true)) {
                for (String line : list) {
                    fileWriter.write(line);
                    fileWriter.write(System.getProperty("line.separator"));

                }
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedReader.close();
        if (!file.delete()) {
            System.out.println("Не удалось удалить файл1");
            return;
        }
        if (!tempFile.renameTo(file)) {
            System.out.println("Could not rename file");
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
                if (Long.parseLong(arrayOfSplit[0]) == id) {
                    developer.setId(Long.valueOf(arrayOfSplit[0]));
                    developer.setFirstName(arrayOfSplit[1]);
                    developer.setSecondName(arrayOfSplit[2]);
                    developer.setExperience(Integer.valueOf(arrayOfSplit[3]));
                    developer.setSalary(Integer.valueOf(arrayOfSplit[4]));
                    System.out.println(developer);

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
