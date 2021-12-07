package negocio;
import java.sql.SQLException;
import java.util.List;

import dados.*;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import persistencia.*;

public class Sistema {
	private PacienteDAO pacienteDAO;
	private MedicoDAO medicoDAO;
	private ConsultaDAO consultaDAO;
	private static Sistema instance=null;
	
	private Sistema(String senha)throws ClassNotFoundException,SQLException,SelectException{
		Conexao.setSenha(senha);
		pacienteDAO=PacienteDAO.getInstance();
		medicoDAO=MedicoDAO.getInstance();
		consultaDAO=ConsultaDAO.getInstance();
	}
	
	public static Sistema getInstance(String senha)  {
		if(instance==null) {
			try {
				instance=new Sistema(senha);
			} catch (ClassNotFoundException | SQLException | SelectException e) {
				e.getMessage();
			}
		}
		return instance;
	}
	
	public void inserirPaciente(Paciente p)throws InsertException,SelectException{
		pacienteDAO.insert(p);
	}
	public void inserirMedico(Medico m)throws InsertException,SelectException{
		medicoDAO.insert(m);
	}
	public void inserirConsulta(Consulta c)throws InsertException,SelectException{
		consultaDAO.insert(c);
	}
	
	public List<Paciente> selectAllPaciente() throws SelectException{
		return pacienteDAO.selectAll();
	}
	public List<Medico> selectAllMedico() throws SelectException{
		return medicoDAO.selectAll();
	}
	
	public List<Consulta> selectAllConsulta() throws SelectException{
		return consultaDAO.selectAll();
	}
	
	public Medico selectMedico(int id_medico) throws SelectException {
		return medicoDAO.select(id_medico);
	}
	public Paciente selectPaciente(int id_paciente) throws SelectException {
		return pacienteDAO.select(id_paciente);
	}
	public Consulta selectConsulta(int id_consulta) throws SelectException {
		return consultaDAO.select(id_consulta);
	}
	
	public void deletePaciente(Paciente p)throws DeleteException{
		pacienteDAO.delete(p);
	}
	public void deleteMedico(Medico m)throws DeleteException{
		medicoDAO.delete(m);
	}
	public void deleteConsulta(Consulta c)throws DeleteException{
		consultaDAO.delete(c);
	}
	
	public void atualizarPaciente(Paciente p)throws UpdateException{
		pacienteDAO.update(p);
	}
	public void atualizarMedico(Medico m)throws UpdateException{
		medicoDAO.update(m);
	}
	public void atualizarConsulta(Consulta c)throws UpdateException{
		consultaDAO.update(c);
	}
}




