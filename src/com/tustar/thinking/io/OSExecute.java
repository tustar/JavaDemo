package com.tustar.thinking.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;

/**
 * Created by tustar on 17-5-10.
 */
public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null) {
                System.out.println(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.out.println(s);
                err = true;
            }
        } catch (Exception e) {
            if (!command.startsWith("CMD /C")) {
                command("CMD /C"  + command);
            } else {
                throw new RuntimeException(e);
            }
        }
        if (err) {
            throw new OSExecuteException("Errors executing " + command);
        }
    }
}
