import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kasutaja {

    private String kasutajanimi, parool;

    public Kasutaja(String kasutajanimi, String parool) {
        this.kasutajanimi = kasutajanimi;
        this.parool = parool;
    }

    public String getKasutajanimi() {
        return kasutajanimi;
    }

    public String getParool() {
        return parool;
    }

    public String krüpteeriParool() {
        List<String> võti = Arrays.asList("p","o","n","m","l","k","j","i","h","g","f","e","d","c","b","a");
        StringBuilder pw = new StringBuilder(parool);
        String krüpteeritud ="";
        int võtmeLoendur = 0;
        int pwLoendur=0;
        for (int i = 0; i < parool.length(); i++) {
            if(i % 2 == 0){
                krüpteeritud+= võti.get(võtmeLoendur);
                võtmeLoendur++;
            }
            krüpteeritud+= pw.charAt(i);

        }
        return krüpteeritud;
    }

    public String dekrüpteeri(String parool) {
        StringBuilder krüpteeritud= new StringBuilder(parool);
        String algne="";
        for (int i = 0; i < krüpteeritud.length(); i++) {
            if(i % 2 == 0){
                krüpteeritud.deleteCharAt(i);
            }
        }
        algne = krüpteeritud.toString();
        return algne;
    }


    @Override
    public String toString() {
        return "Kasutaja{" +
                "kasutajanimi='" + kasutajanimi + '\'' +
                ", parool='" + parool + '\'' +
                '}';
    }
}
