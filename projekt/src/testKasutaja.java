import javax.swing.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TestKasutaja {

    public static void main(String[] args) throws IOException {
        Kasutaja buffer = new Kasutaja("none","none");
        boolean userConfirmed= false;
        boolean pwConfirmed = false;
        String kasutajaNimi, parool;

        String[] valikud= {"ei","jah"};
        int kasUus = JOptionPane.showOptionDialog(null,"Kas oled uus kasutaja?","Tee valik",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, valikud,valikud[0] );

        if(kasUus == 0){
            kasutajaNimi = JOptionPane.showInputDialog(null,
                    "Sisesta kasutajanimi ", "Tere tulemast tagasi!",
                    JOptionPane.QUESTION_MESSAGE);
            while(userConfirmed ==false) {
                try (Scanner sc = new Scanner(Paths.get("userdata.txt"), "UTF-8")) {
                    while (sc.hasNextLine()) {
                        String rida = sc.nextLine();
                        String[] andmed = rida.split(" ");
                        String username = andmed[0];
                        if (username.equals(kasutajaNimi)) {
                            userConfirmed = true;
                            break;
                        }
                    }
                }
                if(userConfirmed){break;}
                kasutajaNimi = JOptionPane.showInputDialog(null,
                        "Sisesta kasutajanimi ", "Vale kasutajanimi, proovi uuesti!",
                        JOptionPane.QUESTION_MESSAGE);
            }


            parool = JOptionPane.showInputDialog(null,
                    "Sisesta parool ", "Tere tulemast tagasi!",
                    JOptionPane.QUESTION_MESSAGE);

            while(pwConfirmed == false) {
                try (Scanner sc = new Scanner(Paths.get("userdata.txt"), "UTF-8")) {
                    while (sc.hasNextLine()) {
                        String rida = sc.nextLine();
                        String[] andmed = rida.split(" ");
                        String passwordEnc = andmed[1];
                        String passwordDec = buffer.dekrüpteeri(passwordEnc);
                        if (passwordDec.equals(parool) && kasutajaNimi.equals(andmed[0])) {
                            pwConfirmed = true;
                            break;
                        }
                    }
                }
                if(pwConfirmed){break;}
                parool = JOptionPane.showInputDialog(null,
                        "Sisesta parool ", "Vale parool, proovi uuesti!",
                        JOptionPane.QUESTION_MESSAGE);
            }

        }else{
            kasutajaNimi = JOptionPane.showInputDialog(null,
                    "Loo kasutajanimi ", "Uus kasutaja",
                    JOptionPane.QUESTION_MESSAGE);
            parool = JOptionPane.showInputDialog(null,
                    "Loo parool ", "Uus kasutaja",
                    JOptionPane.QUESTION_MESSAGE);

            Kasutaja kasutaja = new Kasutaja(kasutajaNimi, parool);

            try{
                FileWriter fw = new FileWriter("userdata.txt",true);
                fw.write(kasutaja.getKasutajanimi()+" "+kasutaja.krüpteeriParool()+"\n");
                fw.close();
            }catch (IOException e) {}

        }

    Kasutaja kasutaja = new Kasutaja(kasutajaNimi, parool);
    //Saab kätte kasutaja

    new File(kasutaja.getKasutajanimi() + "userdata.txt").isFile();

    //Vaatab, kas kasutajal juba on fail, vajaduselt tekitab uue
    if (Files.exists(kasutaja.getKasutajanimi() + "userdata.txt")) {
        }
        else {
    File file = new File(kasutaja.getKasutajanimi() + "userdata.txt");
    Reader reader = new InputStreamReader(System.in);
    br = new BufferedReader(reader);

    }

        FileWriter fw = new FileWriter(file,true);
        String str=null;
        BufferedReader br=null;
        BufferedWriter bw=null;
        str = br.readLine();
        fw.write = (str);
        fw.flush();
        fw.close();
    }catch (IOException e) {}

        List<String> fileContent = Files.readAllLines(Paths.get(File.getPath()), Charset.defaultCharset());
        StringBuilder sb = new StringBuilder();
        for (String sõne : fileContent) {
        sb.append(sõne).append(" ");
        }

        JFrame frame = new JFrame(kasutajaNimi + " fail");
        frame.setSize(200, 100);
        JLabel label = new JLabel(sb.toString());
        frame.add(label);
        frame.setVisible(true);

        System.out.println("Autent OK");
        }
