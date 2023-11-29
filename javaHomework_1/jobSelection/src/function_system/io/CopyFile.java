package function_system.io;

import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CopyFile
{
    public void copy(String file, String copyFile)
    {


        InputStream is = null;

        try {
            is = new FileInputStream(file);
            byte[] buffer = new byte[10 * 1024];
            int len = 0;
            String str = "";
            while ((len = is.read(buffer)) != -1)
            {
                str = str + new String(buffer, 0, len, "utf-8");
            }

            is.close();

            File sf = new File(copyFile);
            OutputStream os = new FileOutputStream(sf);
            os.write(str.getBytes());
            os.close();
            System.out.println("拷贝数据成功");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void copyPicture(String url, String fileName, String savepath)
    {
        try {
            URL fileUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) fileUrl.openConnection();
            connection.setConnectTimeout(3 * 1000);
            InputStream is = connection.getInputStream();
            byte[] buffer = new byte[10 * 1024];
            File sf = new File(savepath);

            if (!sf.exists())
            {
                sf.mkdirs();
            }

            String downFile = sf.getPath() + "\\" + fileName + ".png";
            OutputStream os = new FileOutputStream(downFile);
            int len = 0;
            while ((len = is.read(buffer)) != -1)
            {
                os.write(buffer, 0, len);
            }
            System.out.println("下载成功");
            Desktop.getDesktop().open(sf);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
