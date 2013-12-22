package footprints.asynclogger.impl;

import footprints.asynclogger.LogConsumer;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-22
 * Time: 下午7:57
 */
@Service
public class FileLogConsumer implements LogConsumer {
    public static final String DEFAULT_LOG_PATH = "/tmp/logs/asynclogger";
    private File file;

    public FileLogConsumer() {
        this(null);
    }

    public FileLogConsumer(String path) {
        if (path == null || "".equals(path)) {
            path = DEFAULT_LOG_PATH;
        }
        file = new File(path);
    }

    @Override
    public void consume(LogEvent logEvent) {
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(logEvent.getMsg() + "\n");
            Throwable tx = logEvent.getTx();
            if (tx != null) {
                tx.printStackTrace(new PrintWriter(fw));
            }
            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
