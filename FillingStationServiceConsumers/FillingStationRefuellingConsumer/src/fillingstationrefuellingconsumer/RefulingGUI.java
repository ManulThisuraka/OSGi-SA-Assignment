package fillingstationrefuellingconsumer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.sa.osgi.model.Fuel;

import fillingstationrefuellingproducer.FillingStationRefuellingService;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class RefulingGUI extends JFrame{

	private JPanel contentPane;
	private JTable table;
	private JTextField txtEmpID;
	private JTextField txtEmpName;
	private JTextField txtHours;
	private JTextField txtOTHours;
	int err;
	private final JLabel lblNewLabel = new JLabel("Refueling Service");
	private JTextField txtType;
	private JTable table_1;
	private JTextField txtMethod;
	private JTextField txtOctane;
	private JTextField txtAmount;
	/**
	 * @wbp.nonvisual location=209,684
	 */
	private final JButton button = new JButton("New button");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RefulingGUI frame = new RefulingGUI();
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
	public RefulingGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 632);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(286, 10, 366, 49);
		contentPane.add(lblNewLabel);

		txtType = new JTextField();
		txtType.setBounds(103, 116, 269, 36);
		contentPane.add(txtType);
		txtType.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 384, 769, 187);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Fuel Type", "Octane", "Price (1L)", "Total Price/ Liters"
				}
				));

		txtMethod = new JTextField();
		txtMethod.setColumns(10);
		txtMethod.setBounds(534, 116, 269, 36);
		contentPane.add(txtMethod);

		txtOctane = new JTextField();
		txtOctane.setColumns(10);
		txtOctane.setBounds(103, 250, 269, 36);
		contentPane.add(txtOctane);

		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(534, 250, 269, 36);
		contentPane.add(txtAmount);

		JLabel lblNewLabel_1 = new JLabel("Fuel Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(103, 63, 121, 31);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("1 - Diesel");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(139, 92, 85, 25);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("2 - Petrol");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(253, 92, 85, 25);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1 = new JLabel("Octane Number");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(103, 172, 182, 31);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("Diesel  ( 1-Normal / 2- Super )");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(139, 200, 222, 25);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_1_1 = new JLabel("Petrol  ( 1- 92 Oct. / 2- 95 Oct )");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(139, 225, 232, 25);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Filling Method");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(534, 63, 163, 31);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2_3 = new JLabel("1 - Liters");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(568, 92, 85, 25);
		contentPane.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_1_2 = new JLabel("2 - Cash");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(682, 92, 85, 25);
		contentPane.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Enter how much you want :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(534, 172, 306, 31);
		contentPane.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("Liters or Cash Amount");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_2_1.setBounds(544, 215, 208, 25);
		contentPane.add(lblNewLabel_2_1_2_1);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fuelType = txtType.getText();
				String octane = txtOctane.getText();
				String refuelMethod = txtMethod.getText();
				String capacity = txtAmount.getText();
				
				if (fuelType.isEmpty() || octane.isEmpty() ||refuelMethod.isEmpty() || capacity.isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Fill all Text boxes", "Empty Field Alert",
							JOptionPane.OK_OPTION);
				}else {
					float tot= fillingstationrefuellingconsumer.Activator.fuelAddServ.addFuel(Integer.parseInt(fuelType),Integer.parseInt(octane), Integer.parseInt(refuelMethod), Integer.parseInt(capacity));
					List<Fuel> fuelList = fillingstationrefuellingconsumer.Activator.fuelAddServ.fuelHistory();
					Object[] row = new Object[4];
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					model.setRowCount(0);
					for (Fuel fuelrecord : fuelList) {
						row[0] = fuelrecord.getFuelTypeString();
						row[1] = fuelrecord.getFuelOctaneString();
						row[2] = fuelrecord.getFuelPrice();
						row[3] = fuelrecord.getTotal();
						model.addRow(row);
					}
				}

			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSubmit.setBounds(397, 292, 114, 31);
		contentPane.add(btnSubmit);

		JButton btnBack = new JButton("BackToMenu");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(20, 11, 151, 31);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1_3 = new JLabel("Refuelling History");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1_3.setBounds(342, 343, 240, 31);
		contentPane.add(lblNewLabel_1_3);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(158);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(167);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(137);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(178);
	}


}
