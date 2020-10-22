import java.io.*;
import java.net.*;

public class Aplicacao {

    public static void main(String[] args) {
        int downloaded = 0;
        int download = 0;
        String endereco = "http://repositorio.dados.gov.br/educacao/CADASTRO%20DAS%20IES_2011.csv";

        try {
            URL url = new URL(endereco);
            System.out.println("*   Conectando...");
            URLConnection connec = url.openConnection();
            connec.connecnect();
            System.out.println("*   Conectado à : " + url.getProtocol() + "://" + url.getHost() + "" + url.getPath());
            FileOutputStream fileout = new FileOutputStream("c:/CadastroIES.csv");
            System.out.println("*   Baixando " + connec.getContentLength() + " bytes");
            InputStream entrada = connec.getInputStream();
            int buffer = 2048;
            byte[] bytes = new byte[buffer];
            while((download = entrada.read(bytes)) != -1) {  
                downloaded += download;  
                fileout.write(bytes, 0, download);
                System.out.println("*   Downloaded: "+downloaded);  
            }

            fileout.close();
            System.out.println("*   Arquivo baixado!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
