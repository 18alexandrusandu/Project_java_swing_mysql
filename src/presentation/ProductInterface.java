package presentation;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ProductInterface extends JPanel{
	private JTable table;
	JButton addButon = new JButton("Add Product");
	JButton editBtn = new JButton("Edit Product");
	JButton deleteBtn = new JButton("Delete Product");
	JButton refreshButton = new JButton("Refresh");
	JButton menuBtn = new JButton("Menu");
	
	
	
	
	
	
	
	
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public ProductInterface() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 64, 380, 179);
		add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		JLabel lblNewLabel = new JLabel("Product Table");
		lblNewLabel.setBounds(44, 39, 100, 14);
		add(lblNewLabel);
		
	    addButon = new JButton("Add Product");
		addButon.setBounds(10, 5, 100, 23);
		add(addButon);
		
		editBtn = new JButton("Edit Product");
		editBtn.setBounds(120, 5, 104, 23);
		add(editBtn);
		
	    deleteBtn = new JButton("Delete Product");
		deleteBtn.setBounds(234, 5, 108, 23);
		add(deleteBtn);
		
	    refreshButton = new JButton("Refresh");
		refreshButton.setBounds(361, 5, 89, 23);
		add(refreshButton);
		
		menuBtn = new JButton("Menu");
		menuBtn.setBounds(361, 255, 89, 23);
		add(menuBtn);
	}
	public JButton getAddButon() {
		return addButon;
	}
	public void setAddButon(JButton addButon) {
		this.addButon = addButon;
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
	public JButton getRefreshButton() {
		return refreshButton;
	}
	public void setRefreshButton(JButton refreshButton) {
		this.refreshButton = refreshButton;
	}
	public JButton getMenuBtn() {
		return menuBtn;
	}
	public void setMenuBtn(JButton menuBtn) {
		this.menuBtn = menuBtn;
	}
}
