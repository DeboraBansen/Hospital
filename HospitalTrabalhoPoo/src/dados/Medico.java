package dados;

public class Medico {
	private int id;
	private String nome;
	private int idade;
	private long cpf;
	private String cidade;
	private String especialidade;
	private int id_consulta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public int getId_consulta() {
		return id_consulta;
	}
	public void setId_consulta(int id_consulta) {
		this.id_consulta = id_consulta;
	}
	
	
	public boolean equals(Object o) {
		Medico m=(Medico) (o);
		
		if(m.getId()==this.id) {
			return true;
		}
		return  false;
	}
	
	public String toString() {
		StringBuilder medico=new StringBuilder();
		medico.append("\tid : "+this.id+" \n");
		medico.append("\tNome : "+this.nome+" \n");
		medico.append("\tIdade : "+this.idade+" \n");
		medico.append("\tCPF : "+this.cpf+" \n");
		medico.append("\tCidade : "+this.cidade+" \n");
		medico.append("\tEspecialidade : "+this.especialidade+" \n");
		
		return medico.toString();
	}
	
	
}
