package netology;

import java.io.*;

public class Main {

    public static final String PARENT_PATH = "D://Games//Games";
    public static final String DONE = " created successfully.\n";
    public static final String UNDONE = " didn't create.\n";


    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();

        try {
//        В папке Games создайте несколько директорий: src, res, savegames, temp.
            createDirectory("src", log);

//        В каталоге src создайте две директории: main, test.
            createDirectory("src//main", log);
            createDirectory("src//test", log);

//        В подкаталоге main создайте два файла: Main.java, Utils.java.
            createFile("src//main", "Main.java", log);
            createFile("src//main", "Utils.java", log);

            createDirectory("res", log);

//        В каталог res создайте три директории: drawables, vectors, icons.
            createDirectory("res//drawables", log);
            createDirectory("res//vectors", log);
            createDirectory("res//icons", log);

            createDirectory("savegames", log);

            createDirectory("temp", log);

//        В директории temp создайте файл temp.txt.
            createFile("temp", "temp.txt", log);


//            Файл temp.txt будет использован для записиси в него информации об успешноном или неуспешном создании файлов и директорий.
           try (FileWriter fw = new FileWriter(PARENT_PATH + "//temp" + "//temp.txt", false)) {
                fw.write(log.toString());
            } catch (IOException e){
                e.printStackTrace();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void createFile(String dir, String fileName, StringBuilder result) throws IOException {
        File file = new File(PARENT_PATH + "//" + dir + "//" + fileName);
        result.append("File " + fileName);

        if (file.createNewFile()){
            result.append(DONE);
        } else {
            result.append(UNDONE);
        }
    }

    private static void createDirectory(String dir, StringBuilder result) throws IOException{
        File file = new File(PARENT_PATH + "//" + dir);

        result.append("Directory " + dir);

        if (file.mkdir()){
            result.append(DONE);
        } else {
            result.append(UNDONE);
        }
    }
}

