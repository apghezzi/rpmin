package repfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class ProjetoGitHub implements Projeto {

    String Titulo;
    String Usuario;
    String DataCriacao;
    String DataAtual;
    ArrayList URLs;

    ProjetoGitHub(URL busca) throws MalformedURLException, IOException, ParseException {

        System.out.println(busca);
        URL url = new URL("https://api.github.com/repos/alexdantas/yetris");
        URLConnection connection = url.openConnection();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        JSONParser jsonParser = new JSONParser();

        JSONObject jsonObject = (JSONObject) jsonParser.parse(in);

        String titulo = (String) jsonObject.get("name");
        setTitulo(titulo);
        /* Testando titulo
         System.out.println("Titulo: " + getTitulo());
         */

        JSONObject jsonObject2 = (JSONObject) jsonObject.get("owner");

        String usuario = (String) jsonObject2.get("login");
        setUsuario(usuario);
        /* Testando usuario 
         System.out.println("Usuário: " + getUsuario());
         */

        String dataCricao = (String) jsonObject.get("created_at");
        setDataCriacao(dataCricao);
        /* Testando dataCriacao
         System.out.println("Criado em: " + getDataCriacao());
         */

        String dataAtual = (String) jsonObject.get("updated_at");
        setDataAtual(dataAtual);
        /* Testando dataAtual
         System.out.println("Atualizado em: " + getDataAtual());
         */

        URL url2 = new URL("https://api.github.com/repos/alexdantas/yetris/releases");
        URLConnection connection2 = url2.openConnection();

        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(connection2.getInputStream()));

        JSONParser jsonParser2 = new JSONParser();
        ArrayList urls = new ArrayList();
        JSONArray jsonArray = (JSONArray) jsonParser2.parse(in2);
        for (int i = 0, size = jsonArray.size(); i < size; i++) {
            JSONObject jsonObject3 = (JSONObject) jsonArray.get(i);
            urls.add(jsonObject3.get("tarball_url"));
        }

        setListaURLs(urls);
        /* Testando urls
         System.out.println("Releases: " + getListaURLs());
         */
    }

    @Override
    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }

    @Override
    public String getTitulo() {
        return this.Titulo;
    }

    @Override
    public void setUsuario(String usuario) {
        this.Usuario = usuario;
    }

    @Override
    public String getUsuario() {
        return this.Usuario;
    }

    @Override
    public void setDataCriacao(String data) {
        this.DataCriacao = data;
    }

    @Override
    public String getDataCriacao() {
        return this.DataCriacao;
    }

    @Override
    public void setDataAtual(String data) {
        this.DataAtual = data;
    }

    @Override
    public String getDataAtual() {
        return this.DataAtual;
    }

    @Override
    public void setListaURLs(ArrayList urls) {
        this.URLs = urls;
    }

    @Override
    public ArrayList getListaURLs() {
        return this.URLs;
    }
}
