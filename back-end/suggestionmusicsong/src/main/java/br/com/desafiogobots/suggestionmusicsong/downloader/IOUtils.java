package br.com.desafiogobots.suggestionmusicsong.downloader;

import java.io.*;
import java.net.URL;

public class IOUtils {


    /**
     * Converte a InputStream para String utilizando o charset informado
     *
     * @param in
     * @param charset UTF-8 ou ISO-8859-1
     * @return
     * @throws IOException
     */
    public static String toString(InputStream in, String charset) throws IOException {

        byte[] bytes = toBytes(in);
        String texto = new String(bytes);
        return texto;
    }

    /**
     * @param in
     * @return
     */

    public static byte[] toBytes(InputStream in) throws IOException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {

                bos.write(buffer, 0, len);
            }

            byte[] bytes = bos.toByteArray();
            return bytes;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        } finally {

            try {
                bos.close();

                in.close();
            } catch (IOException e) {

                e.printStackTrace();
                throw e;
            }

        }

    }/*Fim do metodo toBytes*/


    public static void writeString(OutputStream out, String string) throws IOException {

        writeBytes(out, string.getBytes());
    }

    public static void writeBytes(OutputStream out, byte[] bytes) throws IOException {

        try {

            out.write(bytes);
            out.flush();
            out.close();

        } catch (IOException e) {

            e.printStackTrace();
            throw e;
        }

    }/*Fim do metodo writeBytes*/

    /**
     * Salva o texto em arquivo
     *
     * @param file
     * @param string
     */
    public static void writeString(File file, String string) throws IOException {

        writeBytes(file, string.getBytes());
    }

    public static void writeBytes(File file, byte[] bytes) throws IOException {

        try {

            FileOutputStream out = new FileOutputStream(file);
            out.write(bytes);
            out.flush();
            out.close();

        } catch (IOException e) {

            e.printStackTrace();
            throw e;
        }
    }


    public static boolean downloadToFile(String url, File file) {

        try {

            InputStream in = new URL(url).openStream();
            byte[] bytes = IOUtils.toBytes(in);
            IOUtils.writeBytes(file, bytes);
            System.out.println("downloadToFile " + file);

            return true;

        } catch (IOException e) {

            System.out.println(" IOUtils - erro em downloadToFile " + e.getMessage());
            return false;
        }
    }
}
