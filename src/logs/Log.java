package logs;

import java.io.FileWriter;
import java.io.IOException;

public class Log {
    public static void writeToFile(String[] strList){
        try (FileWriter writer = new FileWriter("log.txt",false)){
            var i = 0;
            for(var s: strList){
                i++;
                writer.write(i+". ID="+s+"\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
