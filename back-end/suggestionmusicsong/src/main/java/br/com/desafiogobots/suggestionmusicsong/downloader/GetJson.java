package br.com.desafiogobots.suggestionmusicsong.downloader;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetJson {

    private static final String TAG = "GetJson";

    public static final String doGet(String caminho) throws IOException {
        String retorno = "";
        try {

            URL url = new URL(caminho);
            int codigoResposta;
            HttpURLConnection con;
            InputStream in;

            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agente", "json");
            con.setDoInput(true);
            con.setDoInput(true);
            con.setReadTimeout(15000);
            con.setConnectTimeout(1500);
            con.connect();

            codigoResposta = con.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST) {

                in = con.getInputStream();
            } else {

                in = con.getErrorStream();
            }

            retorno = converterInputStreamToString(in);


            in.close();
            con.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();
            throw e;

        } catch (IOException io) {

            io.printStackTrace();
            throw io;

        }

        return retorno;
    }


    private static String converterInputStreamToString(InputStream in) throws IOException {

        StringBuffer buffer = new StringBuffer();

        try {

            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(in));
            while ((linha = br.readLine()) != null) {

                buffer.append(linha);
            }

            br.close();

        } catch (IOException e) {

            e.printStackTrace();
            throw e;
        }

        return buffer.toString();
    }

}
