import java.io.*;
import java.net.*;

public class Aplicacao {

    public static void main(String[] args) {
        int downloaded = 0;
        int download = 0;
        String endereco = "http://repositorio.dados.gov.br/educacao/CADASTRO%20DAS%20IES_2011.csv";

        try {
            URL url1 = new URL(endereco);
            System.out.println("*   Conectando...");
            URLConnection con = url1.openConnection();
            con.connect();
            System.out.println("*   Conectado à : " + url1.getProtocol() + "://" + url1.getHost() + "" + url1.getPath());
            FileOutputStream fileout = new FileOutputStream("c:/CadastroIES.csv");
            System.out.println("*   Baixando " + con.getContentLength() + " bytes");
            InputStream entrada = con.getInputStream();
            int buffer = 2048;
            byte[] bytes = new byte[buffer];
            while((download = entrada.read(bytes)) != -1) {  
                downloaded += download;  
                fileout.write(bytes, 0, download);
                System.out.println("*   Downloaded: "+downloaded);  
            }

            fileout.close();
            System.out.println("*   Arquivo baixado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
