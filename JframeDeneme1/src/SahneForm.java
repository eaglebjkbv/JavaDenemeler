import javax.swing.*;
import java.awt.*;

public class SahneForm extends JPanel {
    public SahneForm(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        Button btnKaydet=new Button();
        add(btnKaydet);
    }
}
