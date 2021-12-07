package principal;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dados.Paciente;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import negocio.Sistema;

public class TabelaPaciente extends AbstractTableModel{
	private String[] colunasAtributo= {"Id","Nome","Idade","CPF","Cidade","Descricao"};
	
	private Sistema sistema=Sistema.getInstance("postgres");
	
	public String getColumnName(int column) {
		return colunasAtributo[column];
	}
	
	@Override
	public int getRowCount() {
		try {
			return sistema.selectAllPaciente().size();
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
				
				return sistema.selectAllPaciente().get(rowIndex).getId();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 1: {
			try {
				return sistema.selectAllPaciente().get(rowIndex).getNome();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 2: {
			try {
				return sistema.selectAllPaciente().get(rowIndex).getIdade();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 3: {
			try {
				return sistema.selectAllPaciente().get(rowIndex).getCpf();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 4: {
			try {
				return sistema.selectAllPaciente().get(rowIndex).getCidade();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		case 5: {
			try {
				return sistema.selectAllPaciente().get(rowIndex).getDescricao();
			} catch (SelectException e) {
				e.getMessage();
			}
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}
	
	public void adicionarPaciente(Paciente paciente) throws InsertException, SelectException {
		sistema.inserirPaciente(paciente);

	}
	public void alterarPaciente(Paciente p) throws UpdateException {
		sistema.atualizarPaciente(p);
		fireTableStructureChanged();

	}

	public void removerPaciente(int id) throws SelectException, DeleteException {
		Paciente p=new Paciente();
		p.setId(id);
		for(Paciente paciente: sistema.selectAllPaciente()) {
			if(paciente.equals(p)) {
				p=paciente;
			}
		}
		sistema.deletePaciente(p);
		fireTableStructureChanged();
	}
	
	public List<Paciente> selectAllPaciente() {
		try {
			return sistema.selectAllPaciente();
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	public Paciente selectPaciente(int id) {
		try {
			return sistema.selectPaciente(id);
		} catch (SelectException e) {
			e.getMessage();
		}
		return null;
	}
	
}
