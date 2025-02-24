package services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class TranslationService {

    String language = "ES";

    Map<String, String> arab = new HashMap<>();
    Map<String, String> catalan = new HashMap<>();
    Map<String, String> english = new HashMap<>();
    Map<String, String> spanish = new HashMap<>();
    Map<String, String> french = new HashMap<>();
    Map<String, String> german = new HashMap<>();
    Map<String, String> russian = new HashMap<>();

    public TranslationService() {
        //El constructor únicamente carga los idiomas

        BufferedReader br;
        String linea;
        try {
            //Cargar traducciones arabe
            br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\main\\java\\translations\\arab.csv"), StandardCharsets.UTF_8));
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    arab.put(partes[0], partes[1]);
                }
            }

            //Cargar traducciones catalán
            br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\main\\java\\translations\\cat.csv"), StandardCharsets.UTF_8));
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    catalan.put(partes[0], partes[1]);
                }
            }

            //Cargar traducciones Inglés
            br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\main\\java\\translations\\eng.csv"), StandardCharsets.UTF_8));
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    english.put(partes[0], partes[1]);
                }
            }

            //Cargar traducciones Español
            br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\main\\java\\translations\\es.csv"), StandardCharsets.UTF_8));
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    spanish.put(partes[0], partes[1]);
                }
            }

            //Cargar traducciones Francés
            br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\main\\java\\translations\\fra.csv"), StandardCharsets.UTF_8));
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    french.put(partes[0], partes[1]);
                }
            }

            //Cargar traducciones Alemán
            br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\main\\java\\translations\\ger.csv"), StandardCharsets.UTF_8));
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    german.put(partes[0], partes[1]);
                }
            }
            //Cargar traducciones Ruso
            br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\main\\java\\translations\\rus.csv"), StandardCharsets.UTF_8));
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    russian.put(partes[0], partes[1]);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Se le pasa la clave a traducir y devuelve un String en el
     * lenguaje solicitado. En caso de no existir o el idioma o la clave
     * se devuelve la clave de nuevo.
     *
     * @param str Clave
     * @return String
     */
    public String translate(String str) {
        //TODO: Traducir el string que nos pasen
        switch (language) {
            case "ARAB":
                return arab.getOrDefault(str, str);
            case "CAT":
                return catalan.getOrDefault(str, str);
            case "ENG":
                return english.getOrDefault(str, str);
            case "ES":
                return spanish.getOrDefault(str, str);
            case "FRA":
                return french.getOrDefault(str, str);
            case "GER":
                return german.getOrDefault(str, str);
            case "RUS":
                return russian.getOrDefault(str, str);
            default:
                //Nunca debería llegar
                return str;
        }
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
