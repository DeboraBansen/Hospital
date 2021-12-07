package principal;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dados.Medico;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class TabelaMedico extends AbstractTableModel{
	
	private String[] colunasAtributo= {"Id","Nome","Idade","CPF","Cidade","Especialidade"};
	
	private Sistema sistema=Sistema.getInstance("postgres");
	
	public String getColumnName(int column) {
		return colunasAtributo[column];
	}
	
	@Override
	public int getRowCount() {
		try {
			return	sistema.selectAllMedico().size();
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
				return sistema.selectAllMedico().get(rowIndex).getId();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 1: {
			try {
				return sistema.selectAllMedico().get(rowIndex).getNome();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 2: {
			try {
				return sistema.selectAllMedico().get(rowIndex).getIdade();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 3: {
			try {
				return sistema.selectAllMedico().get(rowIndex).getCpf();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 4: {
			try {
				return sistema.selectAllMedico().get(rowIndex).getCidade();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 5: {
			try {
				return sistema.selectAllMedico().get(rowIndex).getEspecialidade();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}
	
	public void adicionarMedico(Medico medico) throws InsertException, SelectException {
		sistema.inserirMedico(medico);
		fireTableStructureChanged();

	}
	
	public void alterarMedico(Medico m) throws UpdateException {
		sistema.atualizarMedico(m);
		fireTableStructureChanged();
	}
	
	public void removerMedico(int id) throws SelectException, DeleteException {
		Medico m=new Medico();
		m.setId(id);
		for(Medico medico: sistema.selectAllMedico()) {
			if(medico.equals(m)) {
				m=medico;
			}
		}
		sistema.deleteMedico(m);
		fireTableStructureChanged();
	}
	
	public List<Medico> selectAllMedico() throws SelectException {
		return sistema.selectAllMedico();

	}

	public Medico selectMedico(int id)  {
		try {
			return sistema.selectMedico(id);
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;

	}
	
}
