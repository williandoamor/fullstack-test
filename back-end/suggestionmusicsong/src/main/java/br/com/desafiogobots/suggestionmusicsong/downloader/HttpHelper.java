package br.com.desafiogobots.suggestionmusicsong.downloader;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HttpHelper {

    private final String TAG = "Http";
    private final int TIMEOUT_MILLIS = 15000;
    private String contentType;
    private String charsetToEncode;

    public String doGet(String url) throws IOException {

        return doGet(url, null, "UTF-8");
    }

    public String doGet(String url, Map<String, String> params, String charset) throws IOException {

        String queryString = getQueryString(params);

        if (queryString != null && queryString.trim().length() > 0) {

            url += "?" + queryString;
        }

        URL u = new URL(url);
        HttpURLConnection conn = null;
        String s = null;

        try {

            conn = (HttpURLConnection) u.openConnection();
            if (contentType != null) {

                conn.setRequestProperty("Content-Type", contentType);
            }

            conn.setRequestMethod("GET");
            conn.setConnectTimeout(TIMEOUT_MILLIS);
            conn.setReadTimeout(TIMEOUT_MILLIS);
            conn.connect();
            InputStream in = null;
            int status = conn.getResponseCode();
            if (status >= HttpURLConnection.HTTP_BAD_REQUEST) {

                /*Imprimir o erro no console*/
                System.out.println("Error code: " + status);
                in = conn.getErrorStream();

            } else {

                in = conn.getInputStream();
            }

            s = IOUtils.toString(in, charset);
            in.close();

        } catch (IOException e) {

            throw e;

        } finally {
            if (conn != null) {

                conn.disconnect();
            }
        }

        return s;
    } /*Fim do metodo doGet*/

    /**
     * Retorna a QueryString para 'GET'
     */
    public String getQueryString(Map<String, String> params) throws IOException {

        if (params == null || params.size() == 0) {

            return null;

        }

        String urlParmas = null;
        for (String chave : params.keySet()) {

            Object objValor = params.get(chave);
            if (objValor != null) {

                String valor = objValor.toString();
                if (charsetToEncode != null) {

                    valor = URLEncoder.encode(valor, charsetToEncode);
                }

                urlParmas = urlParmas == null ? "" : urlParmas + "&";
                urlParmas += chave + "=" + valor;
            }
        }

        return urlParmas;
    }

    public void setContentType(String contentType) {

        this.contentType = contentType;
    }

    public void setCharsetToEncode(String encode) {

        this.charsetToEncode = encode;
    }
}
