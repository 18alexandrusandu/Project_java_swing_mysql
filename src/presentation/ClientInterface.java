package presentation;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
public class ClientInterface extends JPanel{
	private JTable table;
	private JButton addClientBtn;
	private JButton editButton;
	private JButton deleteBtn;
	private JButton refreshBtn;
	private JButton MenuBtn;
	
	public JTable getTable() {
		return table;
	}



	
	public void setTable(JTable table) {
		this.table = table;
	}
	
	
	

	public JButton getAddClientBtn() {
		return addClientBtn;
	}




	public void setAddClientBtn(JButton addClientBtn) {
		this.addClientBtn = addClientBtn;
	}




	public JButton getEditButton() {
		return editButton;
	}




	public void setEditButton(JButton editButton) {
		this.editButton = editButton;
	}




	public JButton getDeleteBtn() {
		return deleteBtn;
	}




	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}




	public JButton getRefreshBtn() {
		return refreshBtn;
	}




	public void setRefreshBtn(JButton refreshBtn) {
		this.refreshBtn = refreshBtn;
	}




	public JButton getMenuBtn() {
		return MenuBtn;
	}




	public void setMenuBtn(JButton menuBtn) {
		MenuBtn = menuBtn;
	}




	public ClientInterface() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 91, 403, 150);
		add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
	
		scrollPane.setViewportView(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
	    addClientBtn = new JButton("newClient");
		addClientBtn.setBounds(10, 31, 98, 23);
		add(addClientBtn);
		
	    editButton = new JButton("Edit Client");
	
		editButton.setBounds(134, 31, 104, 23);
		add(editButton);
		
		deleteBtn = new JButton("DeleteClient");
	
		deleteBtn.setBounds(267, 31, 118, 23);
		add(deleteBtn);
		
		JLabel lblNewLabel = new JLabel("Tabel Clienti");
		lblNewLabel.setBounds(35, 60, 70, 14);
		add(lblNewLabel);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(395, 31, 89, 23);
		add(refreshBtn);
		
		MenuBtn = new JButton("Menu");
		MenuBtn.setBounds(338, 252, 89, 23);
		add(MenuBtn);
	}
}
