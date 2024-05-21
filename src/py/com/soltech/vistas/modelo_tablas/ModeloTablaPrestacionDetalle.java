package py.com.soltech.vistas.modelo_tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import py.com.soltech.modelo.entidades.Funcionario;
import py.com.soltech.modelo.entidades.ServicioDetalle;

public class ModeloTablaPrestacionDetalle extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnas = { "DESCRIPCION", "COSTO"};
	private List<ServicioDetalle> lista = new ArrayList<>();
	
	public void setLista(List<ServicioDetalle> lista) {
		this.lista = lista;
		fireTableDataChanged();
	}
	
	@Override
	public String getColumnName(int c) {
		return columnas[c];
	}
	
	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public Object getValueAt(int r, int c) {
		switch (c) {
		case 0:
			return lista.get(r).getDescripcion();
		case 1:
			return lista.get(r).getCosto();
		default:
			return null;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int c) {
		if(lista.size()>0){
			return getValueAt(0, c).getClass();
		}
		return super.getColumnClass(c);
	}
	
}



