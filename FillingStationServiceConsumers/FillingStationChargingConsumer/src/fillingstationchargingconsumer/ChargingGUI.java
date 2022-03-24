package fillingstationchargingconsumer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sa.osgi.charge.model.Charge;


import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ChargingGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtCapacity;
	private JTextField txtHours;
	private JTable table;
	int err;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChargingGUI frame = new ChargingGUI();
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
	public ChargingGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 596);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(565, 189, 465, 333);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Charging Type", "Hours Charged", "Total Price" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(220);
		table.getColumnModel().getColumn(1).setPreferredWidth(216);
		table.getColumnModel().getColumn(2).setPreferredWidth(194);

		JLabel lblNewLabel = new JLabel("Electrical Charging Service");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(280, 27, 565, 57);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Add New Charging Details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(105, 134, 344, 57);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Charging Capacity      :-");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(65, 203, 254, 35);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Charging Hours           :-");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(65, 356, 254, 35);
		contentPane.add(lblNewLabel_2_1);

		txtCapacity = new JTextField();
		txtCapacity.setBounds(342, 201, 161, 47);
		contentPane.add(txtCapacity);
		txtCapacity.setColumns(10);

		txtHours = new JTextField();
		txtHours.setColumns(10);
		txtHours.setBounds(342, 344, 161, 47);
		contentPane.add(txtHours);

		JButton btnAddDetails = new JButton("Add Details");
		btnAddDetails.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get Inputs from text boxes
				String chargeCapacity = txtCapacity.getText();
				String chargeHours = txtHours.getText();

				// Check for Empty Fields
				if (chargeCapacity.isEmpty() || chargeHours.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill all Text boxes", "Empty Field Alert",
							JOptionPane.OK_OPTION);
					err = 1;
				} else {
					// Check for Number Format Exception
					try {
						// Get Service from Consumer Activator through producer
						double result = fillingstationchargingconsumer.Activator.chargeBuyServ
								.addCharge(Integer.parseInt(chargeCapacity), Integer.parseInt(chargeHours));

					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Charging type and hours should be Integers",
								"Number Format Exception", JOptionPane.OK_OPTION);
						err = 1;
					}

					// Get list of Employee Records And Show in the table
					List<Charge> chargerecords = fillingstationchargingconsumer.Activator.chargeBuyServ.chargeHistory();
					Object[] row = new Object[3];
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for (Charge chargerecord : chargerecords) {
						row[0] = chargerecord.getChargingTypeString();
						row[1] = chargerecord.getChargingHr();
						row[2] = chargerecord.getTotal();

						model.addRow(row);
					}
				}

				// If Add Record is Successful, Reset text boxes
				if (err != 1) {
					txtCapacity.setText("");
					txtHours.setText("");
				}
			}
		});

		// Load Table when Frame is visible
		List<Charge> chargerecords = fillingstationchargingconsumer.Activator.chargeBuyServ.chargeHistory();
		Object[] row = new Object[3];
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Charge chargerecord : chargerecords) {
			row[0] = chargerecord.getChargingTypeString();
			row[1] = chargerecord.getChargingHr();
			row[2] = chargerecord.getTotal();

			model.addRow(row);
		}

		btnAddDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddDetails.setBounds(204, 439, 153, 47);
		contentPane.add(btnAddDetails);


		

		JButton btnBackToMenu = new JButton("Back To Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBackToMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBackToMenu.setBounds(30, 27, 153, 47);
		contentPane.add(btnBackToMenu);
		
		JLabel lblNewLabel_3 = new JLabel("1) Full (100%)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(75, 269, 108, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("2) Half (50%)");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(75, 293, 108, 40);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Charging Details");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(698, 134, 344, 57);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Select type According to the Preference");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(65, 248, 270, 24);
		contentPane.add(lblNewLabel_4);
	}
}
