package Managers;

import Utils.ConfigReader;

public class FileManager {
    private static FileManager fileManager=new FileManager();

    private static ConfigReader configReader;
    private FileManager(){}

    public static FileManager getInstance(){
        return fileManager;
    }

    public ConfigReader getConfigReader(){
        return (configReader == null) ? new ConfigReader() : configReader;
    }
}
