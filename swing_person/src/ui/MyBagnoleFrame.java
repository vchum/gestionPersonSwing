package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entity.FileConfig;
import model.BagnoleModel;
import model.PersonDTO;
import process.FileConfigList;
import process.MyPersonFactory2;
import service.IService;

public class MyBagnoleFrame {

	private JFrame frame;
	private JScrollPane scrollPane;
	private int id;
	private PersonDTO be;
	IService<PersonDTO> iservice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyBagnoleFrame window = new MyBagnoleFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public MyBagnoleFrame() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		FileConfigList fcl = new FileConfigList();
		List<FileConfig> listConfig = fcl.getConfigList();		
	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(294, 36, 89, 23);
		frame.getContentPane().add(btnAdd);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 247, 206);
		frame.getContentPane().add(scrollPane);

		JList<PersonDTO> list = new JList<PersonDTO>();
		scrollPane.setViewportView(list);		

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(294, 86, 89, 23);
		frame.getContentPane().add(btnUpdate);

		btnUpdate.setEnabled(false);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(294, 134, 89, 23);
		frame.getContentPane().add(btnRemove);
		
		btnRemove.setEnabled(false);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setMaximumRowCount(2);
		comboBox.setBounds(300, 197, 80, 20);
		frame.getContentPane().add(comboBox);
		
		comboBox.addItem(listConfig.get(0).getService());
		comboBox.addItem(listConfig.get(1).getService());	
		comboBox.setSelectedIndex(-1);
		
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub				
				
				if(comboBox.getSelectedItem() == listConfig.get(0).getService()) {
					
					try {
						
						process.CfgManager.verif = true;						
						frame.setTitle(listConfig.get(0).getService());						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
					
				}
				else {
					try {
						process.CfgManager.verif = false;
						frame.setTitle(listConfig.get(1).getService());
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				try {
					iservice = MyPersonFactory2.newInstance();
					//iservice = process.CfgManager.getInstance().loadCfg();					
					list.setModel(new BagnoleModel(iservice.list()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
								
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				id = list.getSelectedIndex();

				be = list.getModel().getElementAt(id);
				btnUpdate.setEnabled(true);
				btnRemove.setEnabled(true);
			}
		});
		
		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				MyBagnoleAdd bad = new MyBagnoleAdd(iservice);
				bad.setModal(true);
				bad.setVisible(true);

				try {
					list.setModel(new BagnoleModel(iservice.list()));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				btnUpdate.setEnabled(false);
				btnRemove.setEnabled(false);
				
				list.clearSelection();	

			}
		});

		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyBagnoleUpdate bup = new MyBagnoleUpdate(iservice, be);

				bup.setModal(true);
				bup.setVisible(true);
							
				try {
					list.setModel(new BagnoleModel(iservice.list()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				btnUpdate.setEnabled(false);
				btnRemove.setEnabled(false);
				
				list.clearSelection();	
				
			}
		});

		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub


				int a = JOptionPane.showConfirmDialog(frame,"Confirmer la suppression?");  
				if(a == JOptionPane.YES_OPTION){  
					try {
						iservice.delete(be.getId());
						list.setModel(new BagnoleModel(iservice.list()));
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				list.clearSelection();	
				btnUpdate.setEnabled(false);
				btnRemove.setEnabled(false);
			}
		});

	}
}
