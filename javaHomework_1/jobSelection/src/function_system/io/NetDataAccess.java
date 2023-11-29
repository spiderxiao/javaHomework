package function_system.io;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public class NetDataAccess
{
    public static void getHttpResult(String uri, BackForResult back)
    {
        new Thread()
        {
            public void run()
            {
                try {
                    URL url = new URL(uri);
                    HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                    InputStream is = new GZIPInputStream(connect.getInputStream());
                    String result = "";
                    byte[] buffer = new byte[10 * 1024];
                    int len;
                    while ((len = is.read(buffer)) != -1)
                    {
                        result = result + new String(buffer, 0, len, "utf-8");
                    }
                    is.close();
                    back.backForResult(result);




                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }.start();
    }


}
interface BackForResult
{
    void backForResult(String result);
}
