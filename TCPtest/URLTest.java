package TCPtest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 * 下载URL文件
 *
 * @author xiangxiang
 * @create 06/29/2021 13:20
 */
public class URLTest {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        InputStream is = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=630&spm_id_from=pageDriver");
//            System.out.println(url.getProtocol());
//            System.out.println(url.getHost());
//            System.out.println(url.getPort());
//            System.out.println(url.getPath());
//            System.out.println(url.getFile());
//            System.out.println(url.getQuery());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("url.txt");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
