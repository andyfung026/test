package com.greencity.study.sendSmsOTP;

import org.springframework.util.StringUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpStreamRequest {

    public static String http(String url, String content) throws MalformedURLException, IOException {
        return http(url, content, null);
    }

    public static String http(String url, String content, String encoding) throws MalformedURLException, IOException {

        if (StringUtils.isEmpty(encoding)) {
            encoding = "utf-8";
        }

        InputStream inStream = null;
        URLConnection conn = null;
        String result = null;
        try {
            conn = new URL(url).openConnection();
            conn.setDoOutput(true);
            conn.setConnectTimeout(30 * 1000);
            conn.setReadTimeout(60 * 1000);
            conn.setDefaultUseCaches(false);
            conn.setUseCaches(false);

            byte[] bytes = content.getBytes(encoding);

            //conn.setRequestProperty("Pragma:", "no-cache");
            conn.setRequestProperty("Cache-Control", "no-cache");
            //conn.setRequestProperty("Content-Type", "application/xmlstream");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(bytes.length));
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.connect();

            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), encoding);
            out.write(content);
            out.flush();
            closeQuietly(out);

            inStream = conn.getInputStream();
            result = inputStream2String(inStream, encoding);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeQuietly(inStream);
            conn = null;
        }
        return result;
    }

    private static String inputStream2String(InputStream is, String encoding) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String result = null;
        try {
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            result = baos.toString(encoding);
        } finally {
            closeQuietly(baos);
        }
        return result;
    }

    private static void closeQuietly(Closeable is) {
        try {
            if (is != null)
                is.close();
        } catch (IOException ioe) {
        }
    }

}
