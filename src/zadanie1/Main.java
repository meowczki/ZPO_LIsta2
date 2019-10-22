package zadanie1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<String> ranking = new ArrayList<>();
        File file = new File("ranking");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            System.out.println("plik ok");
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                ranking.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("nie można otworzyć pliku");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //a
        System.out.println(getPozycja("Hubert Hurkacz", ranking));
        //b
        System.out.println(getLiczbaGraczyZKraju("USA", ranking));
        //c
        System.out.println(Arrays.toString(getOdchylenieSrednia(ranking, 10)));
        //d
        System.out.println(getRoznica("Novak Djokovic", "Roger Federer", ranking));
        //e
        printToFileLiczbaTurnieji("liczbaTurnieji.txt", ranking);
    }

    public static int getRoznica(String imie1, String imie2, List<String> ranking) {
        int i1 = getPozycja(imie1, ranking);
        int i2 = getPozycja(imie2, ranking);
        List<int[]> lista = getListaLiczby(ranking);
        return lista.get(i1 - 1)[2] - lista.get(i2 - 1)[2];

    }

    public static double[] getOdchylenieSrednia(List<String> ranking, int n) {
        List<int[]> lista = getListaLiczby(ranking);
        double srednia = 0;
        double odchylenie = 0;
        int licznik = n;
        int liiii=0;
        for (int[] i : lista) {
            if (licznik-- == 0) {
                break;
            }
            srednia += i[1];
            liiii++;
        }
        srednia /= n;
        licznik = n;
        for (int[] i : lista) {
            if (licznik-- == 0) {
                break;
            }
            odchylenie += Math.pow((i[1] - srednia), 2);
        }
        odchylenie = Math.sqrt(odchylenie / (n - 1));
        return new double[]{odchylenie, srednia};
    }

    public static int getPozycja(String imie, List<String> ranking) {
        List<int[]> lista = getListaLiczby(ranking);
        for (String r : ranking) {
            if (r.contains(imie)) {
                return lista.get(ranking.indexOf(r))[0];
            }
        }
        return 0;
    }

    public static int getLiczbaGraczyZKraju(String kraj, List<String> ranking) {
        int i = 0;
        for (String r : ranking) {
            if (r.contains(kraj)) {
                i++;
            }
        }
        return i;
    }

    public static List<int[]> getListaLiczby(List<String> ranking) {
        List<int[]> lista = new ArrayList<>();
        int[] pozycja = new int[4];
        Pattern p = Pattern.compile("\\d+");
        for (String r : ranking) {
            Matcher m = p.matcher(r);
            for (int i = 0; m.find(); i++) {
                pozycja[i] = Integer.valueOf(m.group());
            }
            lista.add(Arrays.copyOf(pozycja, 4));
        }
        return lista;

    }

    public static void printToFileLiczbaTurnieji(String nazwaPliku, List<String> ranking) {
        List<int[]> lista = getListaLiczby(ranking);
        BufferedWriter outputWriter = null;
        try {
            outputWriter = new BufferedWriter(new FileWriter(nazwaPliku));
            for (int[] l : lista) {
                String line = String.valueOf(l[3]);
                outputWriter.write(line);
                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
