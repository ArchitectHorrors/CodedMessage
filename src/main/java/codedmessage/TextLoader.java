package codedmessage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public final class TextLoader {
    public static byte[] load(TextType type) {
        try (FileInputStream inputStream = new FileInputStream(
                Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(type.toString())).getFile()
        )) {
            return inputStream.readAllBytes();
        } catch (IOException e) {
            return new byte[]{};
        }
    }
}
