package repfind;

import java.util.Scanner;


public class RepFind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
     /*   System.out.println("Digita as palavras-chave da busca:");
        Scanner scanner = new Scanner(System.in);
        String keyWords = scanner.nextLine();
        System.out.println();
       */ 
        BuscaProjetoGH search = new BuscaProjetoGH();
        
        ProjetoGitHub project = new ProjetoGitHub(search.busca("Tetris"));
      
    }
    
}
