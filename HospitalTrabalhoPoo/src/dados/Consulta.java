package dados;
import java.lang.StringBuilder;

public class Consulta {
	private int id;
	private float valor;
	private String data;
	private String hora;
	private String diagnostico;
	private int id_paciente;
	private int id_medico;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String horario) {
		this.hora = horario;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public int getId_paciente() {
		return id_paciente;
	}
	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}
	public int getId_medico() {
		return id_medico;
	}
	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}
	public String toString() {
		StringBuilder consulta=new StringBuilder();
		
		consulta.append("\tId : "+this.id+" \n");
		consulta.append("\t Medico : "+this.id_medico+" \n");
		consulta.append("\t Paciente : "+this.id_paciente+" \n");
		consulta.append("\t Data : "+this.data+" \n");
		consulta.append("\t Horario : "+this.hora+" \n");
		consulta.append("\t Valor : "+this.valor+" \n");
		consulta.append("\t Diagnostico : "+this.diagnostico+" \n");
		
		return consulta.toString();
	}
	
}
