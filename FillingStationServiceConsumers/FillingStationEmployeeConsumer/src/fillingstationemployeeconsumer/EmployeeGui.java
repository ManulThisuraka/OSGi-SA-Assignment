package fillingstationemployeeconsumer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import employeemodel.EmployeeRecord;
import fillingstationemployeeproducer.Activator;
import fillingstationemployeeproducer.FillingStationEmployeeService;
import fillingstationemployeeproducer.FillingStationEmployeeServiceImpl;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class EmployeeGui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtEmpID;
	private JTextField txtEmpName;
	private JTextField txtHours;
	private JTextField txtOTHours;
	int err;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeGui eframe = new EmployeeGui();
					eframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeGui() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 491);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Employee Daily Report");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(301, -17, 410, 90);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(460, 119, 505, 273);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Employee ID", "Employee Name", "Worked Hours", "OT Hours", "Daily Salary" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(119);
		table.getColumnModel().getColumn(1).setPreferredWidth(117);
		table.getColumnModel().getColumn(2).setPreferredWidth(129);
		table.getColumnModel().getColumn(3).setPreferredWidth(136);
		table.getColumnModel().getColumn(4).setPreferredWidth(132);

		JLabel lblNewLabel_1 = new JLabel("Add New Employee Record");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(105, 51, 291, 58);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Enter Employee ID           :-");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 104, 246, 58);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Enter Employee Name     :-");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(10, 178, 246, 58);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Enter Worked Hours        :-");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(10, 259, 246, 58);
		contentPane.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Enter Worked OT Hours  :-");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_3.setBounds(10, 334, 246, 58);
		contentPane.add(lblNewLabel_1_1_3);

		txtEmpID = new JTextField();
		txtEmpID.setBounds(231, 119, 177, 36);
		contentPane.add(txtEmpID);
		txtEmpID.setColumns(10);

		txtEmpName = new JTextField();
		txtEmpName.setColumns(10);
		txtEmpName.setBounds(231, 189, 177, 36);
		contentPane.add(txtEmpName);

		txtHours = new JTextField();
		txtHours.setColumns(10);
		txtHours.setBounds(231, 270, 177, 36);
		contentPane.add(txtHours);

		txtOTHours = new JTextField();
		txtOTHours.setColumns(10);
		txtOTHours.setBounds(231, 344, 177, 36);
		contentPane.add(txtOTHours);

		JButton btnAddView = new JButton("Add Record");
		btnAddView.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Get Inputs from text boxes
				String empID = txtEmpID.getText();
				String EmpName = txtEmpName.getText();
				String Hours = txtHours.getText();
				String OTHours = txtOTHours.getText();

				// Check for Empty Fields
				if (empID.isEmpty() || EmpName.isEmpty() || Hours.isEmpty() || OTHours.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill all Text boxes", "Empty Field Alert",
							JOptionPane.OK_OPTION);
					err = 1;
				} else {
					// Check for Number Format Exception
					try {
						// Get Service from Consumer Activator through producer
						int result = fillingstationemployeeconsumer.Activator.fillstaempserv.addEmployeeRecord(
								Integer.parseInt(empID), EmpName, Integer.parseInt(Hours), Integer.parseInt(OTHours));

					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "ID, Hours and OT Hours should be Integers",
								"Number Format Exception", JOptionPane.OK_OPTION);
						err = 1;
					}

					// Get list of Employee Records And Show in the table
					List<EmployeeRecord> records = fillingstationemployeeconsumer.Activator.fillstaempserv
							.allEmployees();
					Object[] row = new Object[5];
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for (EmployeeRecord emprecord : records) {
						row[0] = emprecord.getEmpId();
						row[1] = emprecord.getName();
						row[2] = emprecord.getHours();
						row[3] = emprecord.getOthours();
						row[4] = emprecord.getSalary();
						model.addRow(row);
					}
				}

				// If Add Record is Successful, Reset text boxes
				if (err != 1) {
					txtEmpID.setText("");
					txtEmpName.setText("");
					txtHours.setText("");
					txtOTHours.setText("");
				}
			}
		});

		// Load Table when Frame is visible
		List<EmployeeRecord> records = fillingstationemployeeconsumer.Activator.fillstaempserv.allEmployees();
		Object[] row = new Object[5];
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (EmployeeRecord emprecord : records) {
			row[0] = emprecord.getEmpId();
			row[1] = emprecord.getName();
			row[2] = emprecord.getHours();
			row[3] = emprecord.getOthours();
			row[4] = emprecord.getSalary();
			model.addRow(row);
		}

		btnAddView.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddView.setBounds(170, 402, 126, 42);
		contentPane.add(btnAddView);

		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);

			}
		});
		btnBackToMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBackToMenu.setBounds(23, 15, 163, 42);
		contentPane.add(btnBackToMenu);
		
		JLabel lblNewLabel_1_2 = new JLabel("Daily Report");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(636, 51, 170, 58);
		contentPane.add(lblNewLabel_1_2);
	}
}
