package principal;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dados.Consulta;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class TabelaConsulta extends AbstractTableModel {
	private String[] colunasAtributo= {"Id","Id_Medico","Id_Paciente","Data","Hora","Diagnostico","Valor"};
	
	private Sistema sistema=Sistema.getInstance("postgres");
	
	public String getColumnName(int column) {
		return colunasAtributo[column];
	}
	
	@Override
	public int getRowCount() {
		try {
			return sistema.selectAllConsulta().size();
		} catch (SelectException e) {
			e.getMessage();
		}
		return 0;
	}

	@Override
	public int getColumnCount() {
		return colunasAtributo.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0: {
			try {
				return sistema.selectAllConsulta().get(rowIndex).getId();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 1: {
			try {
				return sistema.selectAllConsulta().get(rowIndex).getId_medico();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 2: {
			try {
				return sistema.selectAllConsulta().get(rowIndex).getId_paciente();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 3: {
			try {
				return sistema.selectAllConsulta().get(rowIndex).getData();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 4: {
			try {
				return sistema.selectAllConsulta().get(rowIndex).getHora();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 5: {
			try {
				return sistema.selectAllConsulta().get(rowIndex).getDiagnostico();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 6: {
			try {
				return sistema.selectAllConsulta().get(rowIndex).getValor();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}
	
	public void adicionarConsulta(Consulta consulta) throws InsertException, SelectException {
		sistema.inserirConsulta(consulta);
	}
	public void alterarConsulta(Consulta c) throws UpdateException {
		sistema.atualizarConsulta(c);
		fireTableStructureChanged();

	}

	public void removerConsulta(int id) throws DeleteException, SelectException {
		Consulta c=new Consulta();
		c.setId(id);
		for(Consulta consulta: sistema.selectAllConsulta()) {
			if(consulta.equals(c)) {
				c=consulta;
			}
		}
		sistema.deleteConsulta(c);
		fireTableStructureChanged();
	}
	
	public List<Consulta> selectAllConsulta() {
		try {
			return sistema.selectAllConsulta();
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	public Consulta selectConsulta(int id) {
		try {
			return sistema.selectConsulta(id);
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	

}
