package com.greatwideweb.samples.superputty;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.Charset.forName;
import static java.nio.file.Files.createFile;
import static java.nio.file.Files.write;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.Paths.get;


public class SuperPuttyBuilderRunner {


    private static final String
            OUTPUT_FILENAME = "session.xml", DELIMITER = ",", INPUT_FILE = "work.csv", UTF_8 = "UTF-8";

    public static void main(String[] args) {

        String line;
        List <String> sessions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {

            while ((line = br.readLine()) != null) {
                sessions.add(SessionStringCreator.parse((new SessionData(line.split(DELIMITER)))));
            }

            Path path = get(OUTPUT_FILENAME);
            if (!Files.exists(path, NOFOLLOW_LINKS)) { createFile(path); }
            write(path, sessions, forName(UTF_8));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
