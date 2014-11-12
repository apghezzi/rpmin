package repfind;

import java.util.ArrayList;

interface Projeto {

    void setTitulo(String titulo);
    String getTitulo();
    
    void setUsuario(String usuario);
    String getUsuario();
    
    void setDataCriacao(String data);
    String getDataCriacao();
    
    void setDataAtual(String data);
    String getDataAtual();
    
    void setListaURLs(ArrayList urls);
    ArrayList getListaURLs();
    

}
