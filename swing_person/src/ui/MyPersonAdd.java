package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Persistence.exception.DaoException;
import model.PersonDTO;
import service.PersonSqlService;
import service.IService;

public class MyPersonAdd extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMarque;
	private JTextField textFieldModele;
	private JTextField textFieldAnnee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			PersonSqlService bs = null;
			MyPersonAdd dialog = new MyPersonAdd(bs);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MyPersonAdd(IService<PersonDTO> bs) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			textFieldMarque = new JTextField();
			textFieldMarque.setBounds(64, 30, 86, 20);
			contentPanel.add(textFieldMarque);
			textFieldMarque.setColumns(10);
		}
		
		textFieldModele = new JTextField();
		textFieldModele.setBounds(64, 81, 86, 20);
		contentPanel.add(textFieldModele);
		textFieldModele.setColumns(10);
		{
			textFieldAnnee = new JTextField();
			textFieldAnnee.setBounds(64, 137, 86, 20);
			contentPanel.add(textFieldAnnee);
			textFieldAnnee.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						PersonDTO be = new PersonDTO("50", textFieldMarque.getText(), textFieldModele.getText(), Integer.valueOf(textFieldAnnee.getText()));
						try {
							bs.add(be);
						} catch (DaoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
					}
				});
				
				
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						dispose();
					}
				});
			}
		}
	} 
}
