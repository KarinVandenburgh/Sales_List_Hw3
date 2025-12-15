package karin; 

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;

public class SalesMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField item_field;
	private JTextField cost_field;
	private JTextField Q_field;

	private JTextArea list_area;
	private JTextArea totalArea_lbl;

	private SalesSlip slip;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesMain frame = new SalesMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */

	public SalesMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		slip = new SalesSlip();

		JLabel title_lbl = new JLabel("Sales List");
		title_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		title_lbl.setBounds(175, 11, 67, 29);
		contentPane.add(title_lbl);

		item_field = new JTextField();
		item_field.setBounds(120, 51, 197, 20);
		contentPane.add(item_field);
		item_field.setColumns(10);

		cost_field = new JTextField();
		cost_field.setBounds(120, 82, 96, 20);
		contentPane.add(cost_field);
		cost_field.setColumns(10);

		Q_field = new JTextField();
		Q_field.setBounds(120, 114, 96, 20);
		contentPane.add(Q_field);
		Q_field.setColumns(10);

		JLabel item_lbl = new JLabel("Item:");
		item_lbl.setBounds(63, 54, 47, 14);
		contentPane.add(item_lbl);

		JLabel cost_lbl = new JLabel("Cost: $");
		cost_lbl.setBounds(63, 85, 47, 14);
		contentPane.add(cost_lbl);

		JLabel Q_lbl = new JLabel("Quantity");
		Q_lbl.setBounds(50, 117, 60, 14);
		contentPane.add(Q_lbl);

		JButton addlist_btn = new JButton("Add Item to the Sales List");
		addlist_btn.setBounds(73, 145, 208, 23);
		contentPane.add(addlist_btn);

		list_area = new JTextArea();
		list_area.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(list_area); //**
		scrollPane.setBounds(63, 179, 286, 47);
		contentPane.add(scrollPane);

		totalArea_lbl = new JTextArea();
		totalArea_lbl.setEditable(false);
		totalArea_lbl.setBounds(140, 237, 96, 22);
		contentPane.add(totalArea_lbl);

		JLabel total_lbl = new JLabel("Total Sales:");
		total_lbl.setBounds(50, 242, 80, 14);
		contentPane.add(total_lbl);

		addlist_btn.addActionListener(e -> {

			String name = item_field.getText().trim();

			try {
				double price = Double.parseDouble(cost_field.getText().trim());
				int qty = Integer.parseInt(Q_field.getText().trim());

				SalesItem item = new SalesItem(name, price, qty);
				slip.addItem(item);

				list_area.setText(slip.toString());
				totalArea_lbl.setText(String.format("%.2f", slip.getTotalSales()));

				item_field.setText("");
				cost_field.setText("");
				Q_field.setText("");

			} catch (NumberFormatException ex) {
				list_area.setText("Invalid cost or quantity. Please enter numbers.");
			}
		});
	}
}

