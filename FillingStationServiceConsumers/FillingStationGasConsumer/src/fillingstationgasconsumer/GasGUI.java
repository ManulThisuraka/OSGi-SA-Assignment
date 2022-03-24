package fillingstationgasconsumer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import com.sa.osgi.gas.model.Gas;


import fillingstationgasproducer.FillingStationGasService;

import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class GasGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtGasType;
	private JTextField txtGasQuatity;
	private JTable table;
	int err;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GasGUI frame = new GasGUI();
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
	public GasGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1074, 591);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gas Supplying Service");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(313, 10, 465, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add NewGas Details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(120, 79, 257, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gas Tank Type    :-");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(22, 132, 197, 44);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gas Quantity       :-");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(22, 291, 197, 44);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtGasType = new JTextField();
		txtGasType.setBounds(232, 140, 228, 38);
		contentPane.add(txtGasType);
		txtGasType.setColumns(10);
		
		txtGasQuatity = new JTextField();
		txtGasQuatity.setColumns(10);
		txtGasQuatity.setBounds(232, 299, 228, 38);
		contentPane.add(txtGasQuatity);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(509, 132, 499, 385);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Gas Type", "Quantity", "Total Amount"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(224);
		table.getColumnModel().getColumn(1).setPreferredWidth(217);
		table.getColumnModel().getColumn(2).setPreferredWidth(223);
		
		JButton btnNewButton = new JButton("Add Details");
		btnNewButton.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Get Inputs from text boxes
				String gastype = txtGasType.getText();
				String gasquantity = txtGasQuatity.getText();
				
				// Check for Empty Fields
				if (gastype.isEmpty() || gastype.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill all Text boxes", "Empty Field Alert",
							JOptionPane.OK_OPTION);
					err = 1;
				} else {
					// Check for Number Format Exception
					try {
						// Get Service from Consumer Activator through producer
						double result = fillingstationgasconsumer.Activator.gasBuyServ.buyGas(Integer.parseInt(gastype), Integer.parseInt(gasquantity));

					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Gas Type and Gas Quatity should be Integers",
								"Number Format Exception", JOptionPane.OK_OPTION);
						err = 1;
					}

					// Get list of Employee Records And Show in the table
					List<Gas> gasrecords = fillingstationgasconsumer.Activator.gasBuyServ.buyGas();
					Object[] row = new Object[3];
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for (Gas gasrecord : gasrecords) {
						row[0] = gasrecord.getGasTankString();
						row[1] = gasrecord.getQuantity();
						row[2] = gasrecord.getTotal();
						
						model.addRow(row);
					}
				}

				// If Add Record is Successful, Reset text boxes
				if (err != 1) {
					txtGasType.setText("");
					txtGasQuatity.setText("");
				}
			}
		});
		
		// Load Table when Frame is visible
		List<Gas> gasrecords = fillingstationgasconsumer.Activator.gasBuyServ.buyGas();
		Object[] row = new Object[3];
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Gas gasrecord : gasrecords) {
			row[0] = gasrecord.getGasTankString();
			row[1] = gasrecord.getQuantity();
			row[2] = gasrecord.getTotal();
			
			model.addRow(row);
		}
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(169, 402, 153, 44);
		contentPane.add(btnNewButton);
		
		JButton btnBackToMenu = new JButton("Back To Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBackToMenu.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBackToMenu.setBounds(22, 25, 153, 44);
		contentPane.add(btnBackToMenu);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gas Supplying Details");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(624, 79, 295, 44);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("Select type According to the Preference");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(22, 186, 270, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("1) Buddy");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(32, 212, 84, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("2) Budget");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(32, 235, 84, 24);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("3) Regular");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(32, 257, 84, 24);
		contentPane.add(lblNewLabel_3_2);
	}
}
