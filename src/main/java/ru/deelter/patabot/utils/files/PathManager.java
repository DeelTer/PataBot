package ru.deelter.patabot.utils.files;

import ru.deelter.patabot.PataBot;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class PathManager {

    private static String resourcePath;

    public static void setupPaths() {
        setupMainPath(); // Main directory
        DirectoryManager.createDirectory("money"); // ./money directory
    }

    public static void setupMainPath() {
        URI uri = null;
        try {
            uri = PataBot.class.getProtectionDomain().getCodeSource().getLocation().toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (uri == null) throw new RuntimeException("URI is null");

        resourcePath = new File(uri).getParent();
        System.out.println("Load main path: " + resourcePath); // DEBUG
    }

    public static File getMainPath() {
        return new File(resourcePath);
    }
}
