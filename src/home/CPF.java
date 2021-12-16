package home;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * @author Allan
 */
public class CPF {
    Pessoa p = new Pessoa();
    private static final String Formato = "###.###.###-##";
    
    public CPF(String C) {
        p.setCPF(this.FormatCPF(C, false));
    }
    
    
    public boolean isCPF(){
        
        if (p.getCPF().equals("00000000000") || 
            p.getCPF().equals("11111111111") || 
            p.getCPF().equals("22222222222") || 
            p.getCPF().equals("33333333333") ||
            p.getCPF().equals("44444444444") ||
            p.getCPF().equals("55555555555") ||
            p.getCPF().equals("66666666666") ||
            p.getCPF().equals("77777777777") ||
            p.getCPF().equals("88888888888") ||
            p.getCPF().equals("99999999999") ||
            p.getCPF().length() != 11){
            return false;
        }
        
        char dig10, dig11; 
        int sm, i, r, num, peso; 

        try { 
            // Calculo do primeiro Digito Verificador 
            sm = 0; 
            peso = 10; 
            for (i=0; i<9; i++) { 
                num = (int)(p.getCPF().charAt(i) - 48); 
                sm = sm + (num * peso); 
                peso = peso - 1;
            } 
            r = 11 - (sm % 11); 
            if ((r == 10) || (r == 11)) 
                dig10 = '0'; 
            else 
                dig10 = (char)(r + 48); 

            // Calculo do segundo Digito Verificador 
            sm = 0; 
            peso = 11; 
            for(i=0; i<10; i++) { 
                num = (int)(p.getCPF().charAt(i) - 48);
                sm = sm + (num * peso); 
                peso = peso - 1;
            } 
            r = 11 - (sm % 11); 
            if ((r == 10) || (r == 11)) 
                dig11 = '0'; 
            else 
                dig11 = (char)(r + 48); 

            if ((dig10 == p.getCPF().charAt(9)) && (dig11 == p.getCPF().charAt(10))) 
                return(true); 
            else return(false);
        } catch(Exception e) { 
            return(false); 
        } 
    }

    private String FormatCPF(String C, boolean Mascara){
        if(Mascara){
            return(C.substring(0, 3) + "." + C.substring(3, 6) + "." +
            C.substring(6, 9) + "/" + C.substring(9, 11));
        }else{
            C = C.replace(".","");
            C = C.replace("/","");
            return C;
        }
    }
    
    
    public static DefaultFormatterFactory getFormat(){
        try {
            return new DefaultFormatterFactory(new MaskFormatter(Formato));
        } catch (Exception e) {
            return null;
        }
    }
}
