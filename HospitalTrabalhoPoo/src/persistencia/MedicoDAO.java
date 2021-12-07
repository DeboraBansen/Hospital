package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Medico;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public class MedicoDAO {
	
	private Conexao conexao;
	private static MedicoDAO instance=null;
	
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
	
	
	private MedicoDAO() throws ClassNotFoundException, SQLException, SelectException {
		Connection conexao=Conexao.getConexao(); 
		
		insert=conexao.prepareStatement("insert into medico values(?,?,?,?,?,?)");
		delete=conexao.prepareStatement("delete from medico where id=?");
		update=conexao.prepareStatement("update medico set nome=?,idade=?,cpf=?,cidade=?,especialidade=? where id=?");
		select=conexao.prepareStatement("select *from medico where id=?");
		selectAll=conexao.prepareStatement("select *from medico ");
		newId=conexao.prepareStatement("select nextval('id_medico')");
		
	}
	
	public static MedicoDAO getInstance()throws ClassNotFoundException,SQLException,SelectException{
		if(instance==null) {
			instance=new MedicoDAO();
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
	
	
	public void insert(Medico medico)throws InsertException{
		try {
			medico.setId(newId());
			insert.setInt(1, medico.getId());
			insert.setString(2, medico.getNome());
			insert.setInt(3, medico.getIdade());
			insert.setLong(4, medico.getCpf());
			insert.setString(5, medico.getCidade());
			insert.setString(6, medico.getEspecialidade());
			insert.executeUpdate();
			
			
		} catch (Exception e) {
			throw new InsertException("Nao foi possivel inserir o medico");
		}
	}
	
	
	public void delete(Medico medico)throws DeleteException{
		try {
			delete.setInt(1, medico.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DeleteException("Erro ao deletar medico");
		}
		
	}	
	
	
	public List<Medico> selectAll() throws SelectException {
		List<Medico> medicos=new ArrayList<Medico>();
		Medico medico=null;
		try {
			ResultSet rs=selectAll.executeQuery();
			while(rs.next()) {
				medico=new Medico();
				medico.setId(rs.getInt("id"));
				medico.setNome(rs.getString("nome"));
				medico.setIdade(rs.getInt("idade"));
				medico.setCpf(rs.getLong("cpf"));
				medico.setCidade(rs.getString("cidade"));
				medico.setEspecialidade(rs.getString("especialidade"));
				medicos.add(medico);
			}
			return medicos;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o medico");
		}
		
	}
	
	
	public void update(Medico medico)throws UpdateException{
		try {
			update.setString(1, medico.getNome());
			update.setInt(2, medico.getIdade());
			update.setLong(3, medico.getCpf());
			update.setString(4, medico.getCidade());
			update.setString(5, medico.getEspecialidade());
			update.setInt(6, medico.getId());
			update.executeUpdate();
	
		} catch (SQLException e) {
			throw new UpdateException("Nao foi possivel atualizar o medico");
		}
		
	}
	
	public Medico select(int id_medico) throws SelectException {
		Medico medico=null;
		
		try {
			select.setInt(1, id_medico);
			ResultSet rs=select.executeQuery();
			if(rs.next()) {
				medico=new Medico();
				medico.setId(rs.getInt("id"));
				medico.setNome(rs.getString("nome"));
				medico.setIdade(rs.getInt("idade"));
				medico.setCpf(rs.getLong("cpf"));
				medico.setCidade(rs.getString("cidade"));
				medico.setEspecialidade(rs.getString("especialidade"));
				
			}
			return medico;
			
		} catch (SQLException e) {
			throw new SelectException("Nao foi possivel encontrar o paciente");
		}
	}
	
}


