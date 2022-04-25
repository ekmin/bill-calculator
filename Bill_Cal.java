import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Bill_Cal extends JFrame {
	JFrame f = new JFrame("Bill Calculator");
	JTextField JT_qty;
	JTextField tf;
	JButton btn_add;
	JTable table = new JTable();
	JScrollPane pane;
	Object[] cols = null;
	int price;
	int total;
	int no = 1;
	int sTotal = 0;
	Font font1 = new Font("SansSerif", Font.BOLD, 18);

	public Bill_Cal() {
		
		String b = "Banana";
		String m = "Mango";
		String o = "Orange";
		String a = "Apple";
		String g = "Grape";
		
		table.getTableHeader().setReorderingAllowed(false);
        table.setEnabled(false);
	    table.getTableHeader().setResizingAllowed(false);

		tf = new JTextField();
		tf.setBounds(125, 468, 300, 44);
		tf.setEditable(false);
		tf.setFont(font1);
		tf.setHorizontalAlignment(JLabel.CENTER);
	    
		JT_qty = new JTextField(20);
		JT_qty.setBounds(329, 38, 95, 45);
		JT_qty.setFont(font1);
		
		btn_add = new JButton("ADD");
		btn_add.setBounds(125, 94, 299, 45);

		cols = new String[] { "No", "Item", "Qty.", "Price", "Total" };

		final DefaultTableModel model = (DefaultTableModel) table.getModel();

		String items[] = { b, m, o, a, g };
		final JComboBox cb = new JComboBox(items);
		cb.setBounds(125, 38, 197, 45);

		model.setColumnIdentifiers(cols);

		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				switch (cb.getSelectedIndex()) {
				case 0:
					price = 10;
					break;
				case 1:
					price = 20;
					break;
				case 2:
					price = 30;
					break;
				case 3:
					price = 40;
					break;
				case 4:
					price = 50;
					break;
				}
				
				total = price * Integer.parseInt(JT_qty.getText());
				
				sTotal += total;
				
				tf.setText("LKR "+ Integer.toString(sTotal) + ".00");
				
				model.addRow(new Object[] { no, cb.getItemAt(cb.getSelectedIndex()), JT_qty.getText(), price, total
				});
				no++;
			}
		});
		pane = new JScrollPane(table);
		pane.setBounds(125, 157, 300, 300);

		add(pane);
		add(JT_qty);
		add(tf);
		add(btn_add);
		add(cb);
    	setLayout(new BorderLayout());
    	setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Color c = Color.decode("#bdb76b");
		getContentPane().setBackground(c);
		setLocationRelativeTo(null);
		setSize(549, 585);

	}

	public static void main(String[] args) {
		new Bill_Cal();
	}
}
