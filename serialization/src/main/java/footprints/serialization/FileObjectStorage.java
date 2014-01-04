package footprints.serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 14-1-4
 * Time: 下午8:55
 */
public abstract class FileObjectStorage implements  ObjectStorage {
    private File file;
    private boolean append;

    public FileObjectStorage(File file, boolean append) {
        this.file = file;
        this.append = append;
    }

    protected void store(byte[] content) throws IOException {
        FileOutputStream fos = new FileOutputStream(file, append);
        fos.write(content, 0, content.length);
    }
}
