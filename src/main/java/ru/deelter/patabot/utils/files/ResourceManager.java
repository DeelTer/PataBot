package ru.deelter.patabot.utils.files;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.deelter.patabot.PataBot;
import ru.deelter.patabot.console.ConsoleLogger;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class ResourceManager {

    public static void saveResource(@NotNull String resourcePath, boolean replace) {
        if (resourcePath.equals("")) throw new IllegalArgumentException("ResourcePath cannot be null or empty");

        resourcePath = resourcePath.replace('\\', '/');
        InputStream in = getResource(resourcePath);
        if (in == null) throw new IllegalArgumentException("The embedded resource '" + resourcePath + "' cannot be found in ");

        File outFile = new File(PathManager.getDataFolder(), resourcePath);
        int lastIndex = resourcePath.lastIndexOf('/');

        File outDir = new File(PathManager.getDataFolder(), resourcePath.substring(0, Math.max(lastIndex, 0)));
        if (!outDir.exists()) outDir.mkdirs();
        try {
            if (!outFile.exists() || replace) {
                OutputStream out = new FileOutputStream(outFile);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0)
                    out.write(buf, 0, len);
                out.close();
                in.close();
            } else {
                ConsoleLogger.warn("Could not save " + outFile.getName() + " to " + outFile + " because " + outFile.getName() + " already exists.");
            }
        } catch (IOException ex) {
            ConsoleLogger.warn("Could not save " + outFile.getName() + " to " + outFile);
        }
    }

    @Nullable
    public static InputStream getResource(@NotNull String filename) {
        try {
            URL url = PataBot.class.getClassLoader().getResource(filename);
            if (url == null) return null;

            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            return connection.getInputStream();
        } catch (IOException ex) {
            return null;
        }
    }
}
