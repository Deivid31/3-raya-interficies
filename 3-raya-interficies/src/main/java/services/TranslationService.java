package services;

public class TranslationService {
    
    private enum IDIOMAS {
        ES,
        CAT,
        ENG,
        FRA,
        DEU,
        RUS,
        ARAB
    }
    
    /**
     * Se le pasa la clave a traducir y el idioma objetivo
     * y devuelve un String en el lenguaje solicitado.
     * En caso de no existir o el idioma o la clave se  devuelve
     * la clave de nuevo.
     * 
     * @param str Clave
     * @param lang Idioma
     * @return String
     */
    public static String translate(String str, String lang) {
        if (isIdioma(lang)) {
            return "";
        }
        return str;
        
    }
    
    /**
     * Se le pasa un string de un idioma y comprueba si el
     * idioma existe, si existe devuelve 'True', en caso contrario
     * 'false'.
     * 
     * @param lang Idioma
     * @return boolean
     */
    public static boolean isIdioma(String lang) {
            try {
                IDIOMAS.valueOf(lang.toUpperCase());
                return true;
            } catch (IllegalArgumentException ex) {
                return false;
            }
        }
    
    
}
