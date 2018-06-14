package ru.zzzadruga;

import java.io.IOException;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

public class StartNode {
    public static void main(String[] args) {
        try (Ignite ignite = Ignition.start("config/cache-node-config.xml")) {
            System.out.println("Press ENTER to exit!");
            System.in.read();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
