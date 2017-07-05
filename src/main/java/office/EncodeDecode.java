package office;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Muneer on 05-07-2017.
 */
public class EncodeDecode {
    public static void main(String[] args) {
        String s = "1) Use EncodeDecode.encode(byteArrayOutputStream) to encode your byteArrayOutputStream to base64String \n"
                + "2) Use EncodeDecode.decode(base64String) to decode the base64String back to byteArrayOutputStream";
        ByteArrayOutputStream byteArrayOutputStream = getByteArrayOutputStream(s);

        String base64String = encode(byteArrayOutputStream);
        System.out.println("base64String: " + base64String + "\n");
        byteArrayOutputStream = decode(base64String);

        s = byteArrayOutputStream.toString();
        System.out.println(s);
    }

    private static String encode(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            byte[] bytes = byteArrayOutputStream.toByteArray();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            String s = IOUtils.toString(byteArrayInputStream, "UTF-8");
            return new BASE64Encoder().encode(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ByteArrayOutputStream decode(String base64String) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bytes = new BASE64Decoder().decodeBuffer(base64String);
            byteArrayOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }

    private static ByteArrayOutputStream getByteArrayOutputStream(String s) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
            byte[] bytes = IOUtils.toByteArray(byteArrayInputStream);
            byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }
}
