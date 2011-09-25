package visao;

import javax.swing.table.DefaultTableModel;

public class BotiqueTableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
	return false;
    }
    
    public BotiqueTableModel(Object[][] arg1, String[] arg2) {
	super(arg1, arg2);
    }
    
}
