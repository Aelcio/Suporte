package Ferramentas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Maru
 */
public class RetornaDataAtual {

    public String dataatual() {
        DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return data.format(date);
    }

}
