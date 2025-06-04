public class Validador {
    
    public static boolean validarEmail(String email){
        int arroba = email.indexOf('@');

        if(arroba == -1 || email.indexOf('@', arroba + 1) != -1){
            return false;
        }

        if(arroba < 4) return false;

        if (!(email.endsWith(".com") || email.endsWith(".com.br"))) return false;

        return true;
    }

    public static boolean validarSenha(String senha){
        
        if (senha.length() <=8 ) return false;

        int n = 0;
        boolean especial = false;

        for(char c : senha.toCharArray()) {
            if (Character.isDigit(c)) n++;
            if (!Character.isLetterOrDigit(c)) especial = true;
        }

        return n >= 2 && especial;
    }

}
