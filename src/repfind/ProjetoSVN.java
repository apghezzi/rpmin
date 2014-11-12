package repfind;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;

public class ProjetoSVN implements Projeto {

    String Titulo;
    String Usuario;
    String DataCriacao;
    String DataAtual;
    ArrayList URLs;

     ProjetoSVN(URL busca) throws MalformedURLException, IOException, ParseException {
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
