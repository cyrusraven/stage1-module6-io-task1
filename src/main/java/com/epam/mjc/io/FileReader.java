package com.epam.mjc.io;


import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String[] profileData = new String[4];
        String inString;
        try (BufferedReader inStream = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            for (int i = 0; i < 4; i++) {
                inString = inStream.readLine();
                profileData[i] = inString.substring(inString.indexOf(':') + 2).trim();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return new Profile(profileData[0], Integer.parseInt(profileData[1]), profileData[2], Long.parseLong(profileData[3]));
    }
}
