package home;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Allan
 */
public class Data {
    private Timestamp data;
    public static final String BarraSemHora="dd/MM/yyyy";
    public static final String BarraComHora="dd/MM/yyyy hh:mm";
    public static final String HifenSemHora="yyyy-MM-dd";
    public static final String HifenComHora="yyyy-MM-dd hh:mm:ss";

    public Data() {
        Timestamp timestamp = null;  
        try { 
            Timestamp agora = new Timestamp(System.currentTimeMillis());
            SimpleDateFormat formatoData = new SimpleDateFormat(HifenComHora);
            Calendar c = Calendar.getInstance();  
            c.setTime(formatoData.parse(agora.toString()));  
            timestamp = new Timestamp(c.getTimeInMillis());  
        } catch (Exception e) { 
            System.err.println(e.getMessage());
        }
        this.data = timestamp;
    }
    
    public Data(String Data,String Format) {
//        if(Format.isEmpty())
//            Format=BarraComHora;
             
        Timestamp timestamp = null;
        try {  
            SimpleDateFormat formatoData = new SimpleDateFormat(Format);  
            Calendar c = Calendar.getInstance();  
            c.setTime(formatoData.parse(Data));  
            timestamp = new Timestamp(c.getTimeInMillis());  
        } catch (Exception e) { 
            System.err.println(e.getMessage());
        }  
        this.data = timestamp;
    }
    
    public Timestamp getTimestamp() {
        return data;
    }
    
    public int getDia(){
        return Integer.parseInt(this.data.toString().split(" ")[0].split("-")[2]);
    }
    
    public int getMes(){
        return Integer.parseInt(this.data.toString().split(" ")[0].split("-")[1]);
    }
    
    public int getAno(){
        return Integer.parseInt(this.data.toString().split(" ")[0].split("-")[0]);
    }    
}
