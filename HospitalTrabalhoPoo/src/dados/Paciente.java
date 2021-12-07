package dados;
import java.lang.StringBuilder;

public class Paciente {
	private int id;
	private String nome;
	private int idade;
	private long cpf;
	private String cidade;
	private String descricao;
	private int id_consulta;
	
	public int getId() {
		return id;
	}
	public void setId(int codigo) {
		this.id = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId_consulta() {
		return id_consulta;
	}
	public void setId_consulta(int id_consulta) {
		this.id_consulta = id_consulta;
	}
	public String toString() {
		StringBuilder paciente=new StringBuilder();
		
		paciente.append("\tId : "+this.id+"\n");
		paciente.append("\tNome : "+this.nome+"\n");
		paciente.append("\tIdade : "+this.idade+"\n");
		paciente.append("\tCPF : "+this.cpf+"\n");
		paciente.append("\tCidade : "+this.cidade+"\n");
		paciente.append("\tDescricao : "+this.descricao+"\n");
		
		return paciente.toString();
	}
	
}
