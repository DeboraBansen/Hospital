package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Consulta;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class ConsultaDAO {
	
	@SuppressWarnings("unused")
	private Conexao conexao;
	private static ConsultaDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	
	
	
	private ConsultaDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into consulta values(?,?,?,?,?,?,?)");
		delete=conexao.prepareStatement("delete from consulta where id=?");
		update=conexao.prepareStatement("update consulta set valor=?,data=?,hora=?,diagnostico=?,id_medico=?,id_paciente=? where id=?");
		select=conexao.prepareStatement("select *from consulta where id=?");
		selectAll=conexao.prepareStatement("select *from consulta ");
		newId=conexao.prepareStatement("select nextval('id_consulta')");
		
	}
	
	public static ConsultaDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new ConsultaDAO();
		}
		return instance;
	}
	
	
	public int newId()throws SelectException{
		try {
			ResultSet rs=newId.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return 0;
			}
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel criar novo id");
		}
	}
	
	
	public void insert(Consulta consulta)throws InsertException{
		try {
			
			insert.setInt(1, newId());
			insert.setFloat(2, consulta.getValor());
			insert.setString(3,consulta.getData());
			insert.setString(4, consulta.getHora());
			insert.setString(5, consulta.getDiagnostico());
			insert.setInt(6, consulta.getId_medico());
			insert.setInt(7, consulta.getId_paciente());
			insert.executeUpdate();
			
			
		} catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir a consulta");
		}
	}
	
	
	public void delete(Consulta consulta)throws DeleteException{
		try {
			delete.setInt(1, consulta.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteException("Erro ao deletar consulta");
		}
		
	}	
	
	
	public List<Consulta> selectAll() throws SelectException {
		List<Consulta> consultas=new ArrayList<Consulta>();
		Consulta consulta=null;
		try {
			ResultSet rs=selectAll.executeQuery();
			while(rs.next()) {
				consulta=new Consulta();
				consulta.setId(rs.getInt("id"));
				consulta.setValor(rs.getFloat("valor"));
				consulta.setData(rs.getString("data"));
				consulta.setHora(rs.getString("hora"));
				consulta.setDiagnostico(rs.getString("diagnostico"));
				consulta.setId_medico(rs.getInt("id_medico"));
				consulta.setId_paciente(rs.getInt("id_paciente"));
				consultas.add(consulta);
			}
			return consultas;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a consulta");
		}
		
	}
	
	
	public void update(Consulta consulta)throws UpdateException{
		try {
			update.setFloat(1, consulta.getValor());
			update.setString(2, consulta.getData());
			update.setString(3, consulta.getHora());
			update.setString(4, consulta.getDiagnostico());
			update.setInt(5, consulta.getId_medico());
			update.setInt(6, consulta.getId_paciente());
			update.setInt(7, consulta.getId());
			update.executeUpdate();
	
		} catch (SQLException e) {
			throw new UpdateException("Nao foi possivel atualizar consulta");
		}
		
	}
	
	public Consulta select(int id_consulta) throws SelectException {
		Consulta consulta=null;
		
		try {
			select.setInt(1, id_consulta);
			ResultSet rs=select.executeQuery();
			if(rs.next()) {
				consulta=new Consulta();
				consulta.setId(rs.getInt("id"));
				consulta.setValor(rs.getFloat("valor"));
				consulta.setData(rs.getString("data"));
				consulta.setHora(rs.getString("hora"));
				consulta.setDiagnostico(rs.getString("diagnostico"));
				consulta.setId_medico(rs.getInt("id_medico"));
				consulta.setId_paciente(rs.getInt("id_paciente"));
				
			}
			return consulta;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o paciente");
		}
	}
}
