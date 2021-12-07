package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Paciente;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class PacienteDAO {
	
	private Conexao conexao;
	private static PacienteDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	
	
	private PacienteDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into paciente values(?,?,?,?,?,?)");
		delete=conexao.prepareStatement("delete from paciente where id=?");
		update=conexao.prepareStatement("update paciente set nome=?,idade=?,cpf=?,cidade=?,descricao=? where id=?");
		select=conexao.prepareStatement("select *from paciente where id=?");
		selectAll=conexao.prepareStatement("select *from paciente ");
		newId=conexao.prepareStatement("select nextval('id_paciente')");
		
	}
	
	public static PacienteDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new PacienteDAO();
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
	
	
	public void insert(Paciente paciente)throws InsertException{
		try {
			paciente.setId(newId());
			insert.setInt(1, paciente.getId());
			insert.setString(2, paciente.getNome());
			insert.setInt(3, paciente.getIdade());
			insert.setLong(4, paciente.getCpf());
			insert.setString(5, paciente.getCidade());
			insert.setString(6, paciente.getDescricao());
			insert.executeUpdate();
			
			
		} catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir a paciente");
		}
	}
	
	
	public void delete(Paciente paciente)throws DeleteException{
		try {
			delete.setInt(1, paciente.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteException("Erro ao deletar paciente");
		}
		
	}	
	
	
	public List<Paciente> selectAll() throws SelectException {
		List<Paciente> pacientes=new ArrayList<Paciente>();
		Paciente paciente=null;
		try {
			ResultSet rs=selectAll.executeQuery();
			while(rs.next()) {
				paciente=new Paciente();
				paciente.setId(rs.getInt("id"));
				paciente.setNome(rs.getString("nome"));
				paciente.setIdade(rs.getInt("idade"));
				paciente.setCpf(rs.getLong("cpf"));
				paciente.setCidade(rs.getString("cidade"));
				paciente.setDescricao(rs.getString("descricao"));
				pacientes.add(paciente);
			}
			return pacientes;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar a paciente");
		}
		
	}
	
	
	public void update(Paciente paciente)throws UpdateException{
		try {
			update.setString(1, paciente.getNome());
			update.setInt(2, paciente.getIdade());
			update.setLong(3, paciente.getCpf());
			update.setString(4, paciente.getCidade());
			update.setString(5, paciente.getDescricao());
			update.setInt(6, paciente.getId());
			update.executeUpdate();
	
		} catch (SQLException e) {
			throw new UpdateException("Nao foi possivel atualizar paciente");
		}
		
	}
	
	public Paciente select(int id_paciente) throws SelectException {
		Paciente paciente=null;
		
		try {
			select.setInt(1, id_paciente);
			ResultSet rs=select.executeQuery();
			if(rs.next()) {
				paciente=new Paciente();
				paciente.setId(rs.getInt("id"));
				paciente.setNome(rs.getString("nome"));
				paciente.setIdade(rs.getInt("idade"));
				paciente.setCpf(rs.getLong("cpf"));
				paciente.setCidade(rs.getString("cidade"));
				paciente.setDescricao(rs.getString("descricao"));
				
			}
			return paciente;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o paciente");
		}
	}
	
}
