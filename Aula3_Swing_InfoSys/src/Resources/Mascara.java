package Resources;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class Mascara {
    public static DefaultFormatterFactory getCpfMask() {
        MaskFormatter mask = null;
        
        try {
            mask = new MaskFormatter("###.###.###-##");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            return null;
        }
        
        return(new DefaultFormatterFactory(mask,mask));
    }
    
    public static DefaultFormatterFactory getFoneFixoMask() {
        MaskFormatter mask = null;
        
        try {
            mask = new MaskFormatter("(##) ####.####");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            return null;
        }
        
        return(new DefaultFormatterFactory(mask,mask));
    }
    
    public static DefaultFormatterFactory getCelularMask() {
        MaskFormatter mask = null;
        
        try {
            mask = new MaskFormatter("(##) #####.####");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            return null;
        }
        
        return(new DefaultFormatterFactory(mask,mask));
    }
    
    public static DefaultFormatterFactory getValorMask() {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        df.setRoundingMode(RoundingMode.HALF_UP);
        NumberFormatter nf = new NumberFormatter(df);
        nf.setAllowsInvalid(false);
        nf.setMinimum(0.00);
        nf.setMaximum(999999999.99);
        return (new DefaultFormatterFactory(nf));
    }
}
