import javax.swing.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Userdata {

    Kasutaja kasutaja = new Kasutaja(kasutajaNimi, parool);
    //Saab kätte kasutaja

    Path path = Paths.get(filePathString);
    //Vaatab, kas kasutajal juba on fail, vajaduselt tekitab uue

            if (Files.exists(kasutaja.getKasutajanimi() + "userdata.txt")) {
    }
            else {
        File file = new File(kasutaja.getKasutajanimi() + "userdata.txt");
        Reader reader = new InputStreamReader(System.in);
        br = new BufferedReader(reader);
        String str = null;
    }

    // Faili kirjutamine
            do{
        System.out.println("Enter 'q' for quit!!");
        str = br.readLine();
        FileWriter fw=new FileWriter(file,true);
        bw = new BufferedWriter(fw);
        bw.write(str);
        System.out.println(str);
    }while(!(str.equalsIgnoreCase("q")));

    List<String> fileContent = Files.readAllLines(Paths.get(file.getPath()), Charset.defaultCharset());
    StringBuilder sb = new StringBuilder();
            for (String sõne : fileContent) {
        sb.append(sõne).append(" ");
    }

    JFrame frame = new JFrame(kasutajaNimi + " fail");
            frame.setSize(200, 100);
    JLabel label = new JLabel(sb.toString())
            frame.add(label);
            frame.setVisible(true);

            System.out.println("Autent OK");
}
}
