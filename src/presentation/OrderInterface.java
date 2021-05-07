package presentation;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class OrderInterface extends JPanel{
	private JTable table;
	private JButton addBtn;
	private JButton editBtn;
	private JButton deleteBtn;
	private JButton refreshBtn;
	private JButton menuBtn;
	
	
	public JButton getAddBtn() {
		return addBtn;
	}
	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}
	public JButton getEditBtn() {
		return editBtn;
	}
	public void setEditBtn(JButton editBtn) {
		this.editBtn = editBtn;
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
		return menuBtn;
	}
	public void setMenuBtn(JButton menuBtn) {
		menuBtn = menuBtn;
	}
	public OrderInterface() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 417, 139);
		add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		addBtn = new JButton("Add Order");
		addBtn.setBounds(10, 27, 89, 23);
		add(addBtn);
		
		editBtn = new JButton("Edit Order");
		editBtn.setBounds(130, 27, 89, 23);
		add(editBtn);
		
		deleteBtn = new JButton("Delete Order");
		deleteBtn.setBounds(240, 27, 95, 23);
		add(deleteBtn);
		
		JLabel lblNewLabel = new JLabel("Orders List");
		lblNewLabel.setBounds(27, 63, 73, 14);
		add(lblNewLabel);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(351, 27, 89, 23);
		add(refreshBtn);
		
	    menuBtn = new JButton("Menu");
		menuBtn.setBounds(334, 249, 89, 23);
		add(menuBtn);
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}

}
