package utileria;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reloj {
    
    public void currentHour(javax.swing.JLabel Label){
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        Label.setText(formato.format(LocalDateTime.now()).toUpperCase());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
        
    }
    
}
