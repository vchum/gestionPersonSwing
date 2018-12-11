package ui;

import java.awt.BorderLayout;
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

public class MyPersonUpdate extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMarque;
	private JTextField textFieldModele;
	private JTextField textFieldAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PersonSqlService bs = null;
			PersonDTO be = null;
			MyPersonUpdate dialog = new MyPersonUpdate(bs, be);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MyPersonUpdate(IService<PersonDTO> bs, PersonDTO be) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textFieldMarque = new JTextField();
			textFieldMarque.setBounds(37, 38, 86, 20);
			contentPanel.add(textFieldMarque);
			textFieldMarque.setColumns(10);
		}
		{
			textFieldModele = new JTextField();
			textFieldModele.setBounds(37, 81, 86, 20);
			contentPanel.add(textFieldModele);
			textFieldModele.setColumns(10);
		}
		{
			textFieldAge = new JTextField();
			textFieldAge.setBounds(37, 134, 86, 20);
			contentPanel.add(textFieldAge);
			textFieldAge.setColumns(10);
		}
		
		textFieldMarque.setText(be.getNom());
		textFieldModele.setText(be.getPrenom());
		textFieldAge.setText(String.valueOf(be.getAge()));
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						be.setNom(textFieldMarque.getText());
						be.setPrenom(textFieldModele.getText());
						be.setAge(Integer.valueOf(textFieldAge.getText()));
						try {
							bs.update(be);
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
