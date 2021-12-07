package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import dados.Consulta;
import dados.Medico;
import dados.Paciente;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;


public class Hospital extends JFrame{
	private JPanel painel=new JPanel();
	//paineis medico
	private TabelaMedico tabelaMedico=new TabelaMedico();
	private JScrollPane painelScrollTabelaMedicos =new JScrollPane();
	private JTable mostrarMedicos;
	private JPanel painelCadastrarMedico=new JPanel();
	private JPanel painelAlterarMedico=new JPanel();
	private JPanel painelAltera=new JPanel();
	private JPanel painelRemoverMedico=new JPanel();
	private JLabel nomeMedico=new JLabel("Digite o nome do medico:");
	private JLabel idadeMedico=new JLabel("Digite a idade do medico:");
	private JLabel cpfMedico=new JLabel("Digite o CPF do medico:");
	private JLabel cidadeMedico=new JLabel("Digite a cidade do medico:");
	private JLabel especialidadeMedico=new JLabel("Digite a especialidade do medico:");
	private JLabel escolhaIdMedico=new JLabel("Escolha o id do medico que deseja alterar:");
	private JLabel escolhaIdRemoverMedico=new JLabel("Escolha o id do medico que deseja remover:");
	private JTextField textoNomeMedico =new JTextField();
	private JTextField textoIdadeMedico =new JTextField();
	private JTextField textoCpfMedico =new JTextField();
	private JTextField textoCidadeMedico =new JTextField();
	private JTextField textoEspecialidadeMedico =new JTextField();
	private JTextField textoIdMedico =new JTextField();
	private JTextField textoIdRemoverMedico =new JTextField();
	private JLabel nomeMedicoAlterar=new JLabel("Digite o nome do medico:");
	private JLabel idadeMedicoAlterar=new JLabel("Digite a idade do medico:");
	private JLabel cpfMedicoAlterar=new JLabel("Digite o CPF do medico:");
	private JLabel cidadeMedicoAlterar=new JLabel("Digite a cidade do medico:");
	private JLabel especialidadeMedicoAlterar=new JLabel("Digite a especialidade do medico:");
	private JTextField textoNomeMedicoAlterar =new JTextField();
	private JTextField textoIdadeMedicoAlterar =new JTextField();
	private JTextField textoCpfMedicoAlterar =new JTextField();
	private JTextField textoCidadeMedicoAlterar =new JTextField();
	private JTextField textoEspecialidadeMedicoAlterar =new JTextField();
	private JButton botaoOk=new JButton("OK");
	private JButton botaoOkAlterar=new JButton("OK");
	private JButton botaoMedicoAlterado=new JButton("Alterar");
	private JButton botaoOkRemove=new JButton("OK");
	private JButton botaoAdicionarMedico=new JButton("Cadastrar Medico");
	private JButton botaoAlterarMedico=new JButton("Alterar Medico");
	private JButton botaoRemoverMedico=new JButton("Remover Medico");
	private JButton botaoMostrarMedicos=new JButton("Mostrar Medicos");
	
	//paineis paciente
	private TabelaPaciente tabelaPaciente=new TabelaPaciente();
	private JScrollPane painelScrollTabelaPacientes =new JScrollPane();
	private JTable mostrarPacientes;
	private JPanel painelCadastrarPaciente=new JPanel();
	private JPanel painelAlterarPaciente=new JPanel();
	private JPanel painelAlteraPaci=new JPanel();
	private JPanel painelRemoverPaciente=new JPanel();
	private JLabel nomePaciente=new JLabel("Digite o nome do paciente:");
	private JLabel idadePaciente=new JLabel("Digite a idade do paciente:");
	private JLabel cpfPaciente=new JLabel("Digite o CPF do paciente:");
	private JLabel cidadePaciente=new JLabel("Digite a cidade do paciente:");
	private JLabel descricaoPaciente=new JLabel("Digite a descricao do paciente:");
	private JLabel escolhaIdPaciente=new JLabel("Escolha o id do paciente que deseja alterar:");
	private JLabel escolhaIdRemoverPaciente=new JLabel("Escolha o id do paciente que deseja remover:");
	private JTextField textoNomePaciente =new JTextField();
	private JTextField textoIdadePaciente =new JTextField();
	private JTextField textoCpfPaciente=new JTextField();
	private JTextField textoCidadePaciente =new JTextField();
	private JTextField textoDescricaoPaciente =new JTextField();
	private JTextField textoIdPaciente =new JTextField();
	private JTextField textoIdRemoverPaciente =new JTextField();
	private JLabel nomePacienteAlterar=new JLabel("Digite o nome do paciente:");
	private JLabel idadePacienteAlterar=new JLabel("Digite a idade do paciente:");
	private JLabel cpfPacienteAlterar=new JLabel("Digite o CPF do paciente:");
	private JLabel cidadePacienteAlterar=new JLabel("Digite a cidade do paciente:");
	private JLabel descricaoPacienteAlterar=new JLabel("Digite a descricao do paciente:");
	private JTextField textoNomePacienteAlterar =new JTextField();
	private JTextField textoIdadePacienteAlterar =new JTextField();
	private JTextField textoCpfPacienteAlterar =new JTextField();
	private JTextField textoCidadePacienteAlterar =new JTextField();
	private JTextField textoDescricaoPacienteAlterar =new JTextField();
	private JButton botaoOkPaciente=new JButton("OK");
	private JButton botaoOkPaciAlterar=new JButton("OK");
	private JButton botaoPacienteAlterado=new JButton("Alterar");
	private JButton botaoOkPaciRemove=new JButton("OK");
	private JButton botaoAdicionarPaciente=new JButton("Cadastrar Paciente");
	private JButton botaoAlterarPaciente=new JButton("Alterar Paciente");
	private JButton botaoRemoverPaciente=new JButton("Remover Paciente");
	private JButton botaoMostrarPacientes=new JButton("Mostrar Pacientes");
	
	//paineis consulta
	private TabelaConsulta tabelaConsulta=new TabelaConsulta();
	private JScrollPane painelScrollTabelaConsultas =new JScrollPane();
	private JTable mostrarConsultas;
	private JPanel painelCadastrarConsulta=new JPanel();
	private JPanel painelAlterarConsu=new JPanel();
	private JPanel painelAlterarConsulta=new JPanel();
	private JPanel painelRemoverConsulta=new JPanel();
	private JLabel escolhaMedico=new JLabel("Digite o codigo do Medico:");
	private JLabel escolhaPaciente=new JLabel("Digite o codigo do paciente:");
	private JLabel dataConsulta=new JLabel("Digite a data da consulta:");
	private JLabel horarioConsulta=new JLabel("Digite o horario da consulta:");
	private JLabel diagnosticoConsulta=new JLabel("Digite o diagnotico:");
	private JLabel valorConsulta=new JLabel("Digite o valor da consulta:");
	private JLabel escolhaIdConsulta=new JLabel("Escolha o id da consulta que deseja alterar:");
	private JLabel escolhaIdRemoverConsulta=new JLabel("Escolha o id da coonsulta que deseja remover:");
	private JTextField textoEscolhaMedico =new JTextField();
	private JTextField textoEscolhaPaciente =new JTextField();
	private JTextField textoDataConsulta =new JTextField();
	private JTextField textoHorarioConsulta=new JTextField();
	private JTextField textoDiagnosticoConsulta =new JTextField();
	private JTextField textoValorConsulta =new JTextField();
	private JTextField textoIdConsulta =new JTextField();
	private JTextField textoIdRemoverConsulta =new JTextField();
	private JLabel escolhaMedicoAlterar=new JLabel("Digite o codigo do Medico:");
	private JLabel escolhaPacienteAlterar=new JLabel("Digite o codigo do paciente:");
	private JLabel dataConsultaAlterar=new JLabel("Digite a data da consulta:");
	private JLabel horarioConsultaAlterar=new JLabel("Digite o horario da consulta:");
	private JLabel diagnosticoConsultaAlterar=new JLabel("Digite o diagnotico:");
	private JLabel valorConsultaAlterar=new JLabel("Digite o valor da consulta:");
	private JTextField textoEscolhaMedicoAlterar =new JTextField();
	private JTextField textoEscolhaPacienteAlterar =new JTextField();
	private JTextField textoDataConsultaAlterar =new JTextField();
	private JTextField textoHorarioConsultaAlterar=new JTextField();
	private JTextField textoDiagnosticoConsultaAlterar =new JTextField();
	private JTextField textoValorConsultaAlterar =new JTextField();
	private JButton botaoOkConsulta=new JButton("OK");
	private JButton botaoOkConsuAlterar=new JButton("OK");
	private JButton botaoConsultaAlterado=new JButton("Alterar");
	private JButton botaoOkConsuRemove=new JButton("OK");
	private JButton botaoAdicionarConsulta=new JButton("Cadastrar Consulta");
	private JButton botaoAlterarConsulta=new JButton("Alterar Consulta");
	private JButton botaoRemoverConsulta=new JButton("Remover Consulta");
	private JButton botaoMostrarConsultas=new JButton("Mostrar Consultas");
	
	
	public Hospital() {
		setTitle("Sistema Hospitalar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 1200, 700);
		
		setContentPane(painel);
		painel.setLayout(null);
		
		///////////////M E D I C O S------------------------------------------------
		painelScrollTabelaMedicos.setBounds(30, 30, 300, 300);
		JLabel titleMedicos=new JLabel("M E D I C O S");
		titleMedicos.setBounds(120, 10, 80, 15);
		painel.add(titleMedicos);
		painel.add(painelScrollTabelaMedicos);
		botaoMostrarMedicos.setBounds(30, 400, 157, 25);
		painel.add(botaoMostrarMedicos);
		botaoAdicionarMedico.setBounds(30, 500, 157, 25);
		painel.add(botaoAdicionarMedico);
		botaoAlterarMedico.setBounds(30, 450, 157, 25);
		painel.add(botaoAlterarMedico);
		botaoRemoverMedico.setBounds(30, 550, 157, 25);
		painel.add(botaoRemoverMedico);
		
		
		
		//////MOSTRAR MEDICOS---------------------------------------------------------------
		
		mostrarMedicos=new JTable(tabelaMedico);
		mostrarMedicos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mostrarMedicos.getColumnModel().getColumn(0).setMaxWidth(40);
		mostrarMedicos.getColumnModel().getColumn(1).setPreferredWidth(150);
		mostrarMedicos.getColumnModel().getColumn(2).setPreferredWidth(40);
		mostrarMedicos.getColumnModel().getColumn(3).setPreferredWidth(90);
		mostrarMedicos.getColumnModel().getColumn(4).setPreferredWidth(130);
		mostrarMedicos.getColumnModel().getColumn(5).setPreferredWidth(150);
		
		botaoMostrarMedicos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabelaMedicos.setViewportView(mostrarMedicos);
			}
		});
		painelScrollTabelaMedicos.setViewportView(mostrarMedicos);
		
		////////CADASTRAR MEDICOS--------------------------------------------------------
		
		painelCadastrarMedico.setBounds(30, 30, 300, 300);
		painelCadastrarMedico.setLayout(null);
		
		nomeMedico.setBounds(30, 20, 200, 15);
		painelCadastrarMedico.add(nomeMedico);
		textoNomeMedico.setBounds(30, 40, 200, 20);
		painelCadastrarMedico.add(textoNomeMedico);
		
		idadeMedico.setBounds(30, 60, 200, 15);
		painelCadastrarMedico.add(idadeMedico);
		textoIdadeMedico.setBounds(30, 80, 200, 20);
		painelCadastrarMedico.add(textoIdadeMedico);
		
		cpfMedico.setBounds(30, 100, 200, 15);
		painelCadastrarMedico.add(cpfMedico);
		textoCpfMedico.setBounds(30, 120, 200, 20);
		painelCadastrarMedico.add(textoCpfMedico);
		
		cidadeMedico.setBounds(30, 140, 200, 15);
		painelCadastrarMedico.add(cidadeMedico);
		textoCidadeMedico.setBounds(30, 160, 200, 20);
		painelCadastrarMedico.add(textoCidadeMedico);
		
		especialidadeMedico.setBounds(30, 180, 200, 15);
		painelCadastrarMedico.add(especialidadeMedico);
		textoEspecialidadeMedico.setBounds(30, 200, 200, 20);
		painelCadastrarMedico.add(textoEspecialidadeMedico);
	
		botaoOk.setBounds(80, 230, 100, 20);
		painelCadastrarMedico.add(botaoOk);
		
		botaoOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				try {
					Medico m=new Medico();
					m.setNome(textoNomeMedico.getText());
					m.setIdade(Integer.parseInt(textoIdadeMedico.getText()));
					m.setCpf(Long.parseLong(textoCpfMedico.getText()));
					m.setCidade(textoCidadeMedico.getText());
					m.setEspecialidade(textoEspecialidadeMedico.getText());
					tabelaMedico.adicionarMedico(m);
				} catch (InsertException | SelectException |NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao adicionar Medico", JOptionPane.ERROR_MESSAGE);
				}

				textoNomeMedico.setText("");
				textoIdadeMedico.setText("");
				textoCpfMedico.setText("");
				textoCidadeMedico.setText("");
				textoEspecialidadeMedico.setText("");
				
			}
		});
		
		botaoAdicionarMedico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabelaMedicos.setViewportView(painelCadastrarMedico);
					
			}
		});
		
		///////ALTERAR MEDICOS-------------------------------------------------------	
		
		painelAltera.setBounds(30, 30, 300, 300);
		painelAltera.setLayout(null);
		
		nomeMedicoAlterar.setBounds(30, 20, 200, 15);
		painelAltera.add(nomeMedicoAlterar);
		textoNomeMedicoAlterar.setBounds(30, 40, 200, 20);
		painelAltera.add(textoNomeMedicoAlterar);
		
		idadeMedicoAlterar.setBounds(30, 60, 200, 15);
		painelAltera.add(idadeMedicoAlterar);
		textoIdadeMedicoAlterar.setBounds(30, 80, 200, 20);
		painelAltera.add(textoIdadeMedicoAlterar);
		
		cpfMedicoAlterar.setBounds(30, 100, 200, 15);
		painelAltera.add(cpfMedicoAlterar);
		textoCpfMedicoAlterar.setBounds(30, 120, 200, 20);
		painelAltera.add(textoCpfMedicoAlterar);
		
		cidadeMedicoAlterar.setBounds(30, 140, 200, 15);
		painelAltera.add(cidadeMedicoAlterar);
		textoCidadeMedicoAlterar.setBounds(30, 160, 200, 20);
		painelAltera.add(textoCidadeMedicoAlterar);
		
		especialidadeMedicoAlterar.setBounds(30, 180, 200, 15);
		painelAltera.add(especialidadeMedicoAlterar);
		textoEspecialidadeMedicoAlterar.setBounds(30, 200, 200, 20);
		painelAltera.add(textoEspecialidadeMedicoAlterar);
		
		botaoMedicoAlterado.setBounds(80, 230, 100, 20);
		painelAltera.add(botaoMedicoAlterado);
		
		botaoMedicoAlterado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Medico m=new Medico();
					m.setId(Integer.parseInt(textoIdMedico.getText()));
					m.setNome(textoNomeMedicoAlterar.getText());
					m.setIdade(Integer.parseInt(textoIdadeMedicoAlterar.getText()));
					m.setCpf(Long.parseLong(textoCpfMedicoAlterar.getText()));
					m.setCidade(textoCidadeMedicoAlterar.getText());
					m.setEspecialidade(textoEspecialidadeMedicoAlterar.getText());
					tabelaMedico.alterarMedico(m);
				} catch (UpdateException|NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar medico", JOptionPane.ERROR_MESSAGE);
				}
				
				painelScrollTabelaMedicos.setViewportView(mostrarMedicos);	
				
			}
		});
		
		//painel pega id do medico que vai ser alterado
		painelAlterarMedico.setBounds(30, 30, 300, 300);
		painelAlterarMedico.setLayout(null);
		
		escolhaIdMedico.setBounds(20, 20, 300, 15);
		painelAlterarMedico.add(escolhaIdMedico);
		textoIdMedico.setBounds(30, 50, 200, 25);
		painelAlterarMedico.add(textoIdMedico);
		
		botaoOkAlterar.setBounds(80, 90, 100, 20);
		painelAlterarMedico.add(botaoOkAlterar);
		
		
		botaoOkAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					textoNomeMedicoAlterar.setText(tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())).getNome());
					textoIdadeMedicoAlterar.setText(String.valueOf(tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())).getIdade()));
					textoCpfMedicoAlterar.setText(String.valueOf(tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())).getCpf()));
					textoCidadeMedicoAlterar.setText(tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())).getCidade());
					textoEspecialidadeMedicoAlterar.setText(tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())).getEspecialidade());


					painelScrollTabelaMedicos.setViewportView(painelAltera);
					
					tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())).setId(tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())).getId());
					tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())).setNome(textoNomeMedicoAlterar.getText());
					tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())).setIdade(Integer.parseInt(textoIdadeMedicoAlterar.getText()));
					tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())).setCpf(Long.parseLong(textoCpfMedicoAlterar.getText()));
					tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())).setCidade(textoCidadeMedicoAlterar.getText());
					tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())).setEspecialidade(textoCidadeMedicoAlterar.getText());
					
					tabelaMedico.alterarMedico(tabelaMedico.selectMedico(Integer.parseInt(textoIdMedico.getText())));
				} catch (NumberFormatException | UpdateException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar medico", JOptionPane.ERROR_MESSAGE);
				}
				
						
				
			}
		});
		
    	
		
		botaoAlterarMedico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabelaMedicos.setViewportView(painelAlterarMedico);		
			}
		});
		
		
		//////REMOVER MEDICO-----------------------------------------------------------------------
		
		painelRemoverMedico.setBounds(30, 30, 300, 300);
		painelRemoverMedico.setLayout(null);
		
		escolhaIdRemoverMedico.setBounds(20, 20, 300, 15);
		painelRemoverMedico.add(escolhaIdRemoverMedico);
		textoIdRemoverMedico.setBounds(30, 50, 200, 25);
		painelRemoverMedico.add(textoIdRemoverMedico);
		
		botaoOkRemove.setBounds(80, 90, 100, 20);
		painelRemoverMedico.add(botaoOkRemove);
		
		botaoOkRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tabelaMedico.removerMedico(Integer.parseInt(textoIdRemoverMedico.getText()));
					painelScrollTabelaMedicos.setViewportView(mostrarMedicos);
					textoIdRemoverMedico.setText("");
				} catch (NumberFormatException | SelectException | DeleteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao remover medico", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		botaoRemoverMedico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabelaMedicos.setViewportView(painelRemoverMedico);
			}
		});
		
		
		/////////////////////// ---------- P A C I E N T E S ----------- ///////////////////////////////////////////////////
		
		painelScrollTabelaPacientes.setBounds(380, 30, 300, 300);
		JLabel titlePaciente=new JLabel("P A C I E N T E S");
		titlePaciente.setBounds(430, 10, 100, 15);
		painel.add(titlePaciente);
		painel.add(painelScrollTabelaPacientes);
		botaoMostrarPacientes.setBounds(380, 400, 157, 25);
		painel.add(botaoMostrarPacientes);
		botaoAdicionarPaciente.setBounds(380, 500, 157, 25);
		painel.add(botaoAdicionarPaciente);
		botaoAlterarPaciente.setBounds(380, 450, 157, 25);
		painel.add(botaoAlterarPaciente);
		botaoRemoverPaciente.setBounds(380, 550, 157, 25);
		painel.add(botaoRemoverPaciente);
		
	//////MOSTRAR PACIENTES---------------------------------------------------------------
		
			mostrarPacientes=new JTable(tabelaPaciente);
			mostrarPacientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			mostrarPacientes.getColumnModel().getColumn(0).setMaxWidth(40);
			mostrarPacientes.getColumnModel().getColumn(1).setMinWidth(150);
			mostrarPacientes.getColumnModel().getColumn(2).setMinWidth(40);
			mostrarPacientes.getColumnModel().getColumn(3).setMinWidth(90);
			mostrarPacientes.getColumnModel().getColumn(4).setMinWidth(130);
			mostrarPacientes.getColumnModel().getColumn(5).setMinWidth(250);
			
			
			botaoMostrarPacientes.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					painelScrollTabelaPacientes.setViewportView(mostrarPacientes);
				}
			});
			painelScrollTabelaPacientes.setViewportView(mostrarPacientes);
			
		
		/////CADASTRAR PACIENTE///////////////-----------------------------
		
		painelCadastrarPaciente.setBounds(30, 30, 300, 300);
		painelCadastrarPaciente.setLayout(null);
		
		nomePaciente.setBounds(30, 20, 200, 15);
		painelCadastrarPaciente.add(nomePaciente);
		textoNomePaciente.setBounds(30, 40, 200, 20);
		painelCadastrarPaciente.add(textoNomePaciente);
		
		idadePaciente.setBounds(30, 60, 200, 15);
		painelCadastrarPaciente.add(idadePaciente);
		textoIdadePaciente.setBounds(30, 80, 200, 20);
		painelCadastrarPaciente.add(textoIdadePaciente);
		
		cpfPaciente.setBounds(30,100, 200, 15);
		painelCadastrarPaciente.add(cpfPaciente);
		textoCpfPaciente.setBounds(30, 120, 200, 20);
		painelCadastrarPaciente.add(textoCpfPaciente);
		
		cidadePaciente.setBounds(30, 140, 200, 15);
		painelCadastrarPaciente.add(cidadePaciente);
		textoCidadePaciente.setBounds(30, 160, 200, 20);
		painelCadastrarPaciente.add(textoCidadePaciente);
		
		descricaoPaciente.setBounds(30, 180, 200, 15);
		painelCadastrarPaciente.add(descricaoPaciente);
		textoDescricaoPaciente.setBounds(30, 200, 200, 20);
		painelCadastrarPaciente.add(textoDescricaoPaciente);
		
		botaoOkPaciente.setBounds(80, 230, 100, 20);
		painelCadastrarPaciente.add(botaoOkPaciente);
		
		botaoOkPaciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Paciente p=new Paciente();
					p.setNome(textoNomePaciente.getText());
					p.setCpf(Long.parseLong(textoCpfPaciente.getText()));
					p.setIdade(Integer.parseInt(textoIdadePaciente.getText()));
					p.setCidade(textoCidadePaciente.getText());
					p.setDescricao(textoDescricaoPaciente.getText());
					
					tabelaPaciente.adicionarPaciente(p);

					textoNomePaciente.setText("");
					textoCpfPaciente.setText("");
					textoIdadePaciente.setText("");
					textoCidadePaciente.setText("");
					textoDescricaoPaciente.setText("");
					
				} catch (InsertException | SelectException|NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao adicionar Paciente", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		botaoAdicionarPaciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabelaPacientes.setViewportView(painelCadastrarPaciente);
				
			}
		});
		
		///////////ALTERAR PACIENTE /////////----------------------
		

		painelAlteraPaci.setBounds(30, 30, 300, 300);
		painelAlteraPaci.setLayout(null);
		
		nomePacienteAlterar.setBounds(30, 20, 200, 15);
		painelAlteraPaci.add(nomePacienteAlterar);
		textoNomePacienteAlterar.setBounds(30, 40, 200, 20);
		painelAlteraPaci.add(textoNomePacienteAlterar);
		
		idadePacienteAlterar.setBounds(30, 60, 200, 15);
		painelAlteraPaci.add(idadePacienteAlterar);
		textoIdadePacienteAlterar.setBounds(30, 80, 200, 20);
		painelAlteraPaci.add(textoIdadePacienteAlterar);
		
		cpfPacienteAlterar.setBounds(30,100, 200, 15);
		painelAlteraPaci.add(cpfPacienteAlterar);
		textoCpfPacienteAlterar.setBounds(30, 120, 200, 20);
		painelAlteraPaci.add(textoCpfPacienteAlterar);
		
		cidadePacienteAlterar.setBounds(30, 140, 200, 15);
		painelAlteraPaci.add(cidadePacienteAlterar);
		textoCidadePacienteAlterar.setBounds(30, 160, 200, 20);
		painelAlteraPaci.add(textoCidadePacienteAlterar);
		
		descricaoPacienteAlterar.setBounds(30, 180, 200, 15);
		painelAlteraPaci.add(descricaoPacienteAlterar);
		textoDescricaoPacienteAlterar.setBounds(30, 200, 200, 20);
		painelAlteraPaci.add(textoDescricaoPacienteAlterar);
		
		
		botaoPacienteAlterado.setBounds(80, 230, 100, 20);
		painelAlteraPaci.add(botaoPacienteAlterado);
		
		botaoPacienteAlterado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Paciente p=new Paciente();
					p.setId(Integer.parseInt(textoIdPaciente.getText()));
					p.setNome(textoNomePacienteAlterar.getText());
					p.setCpf(Long.parseLong(textoCpfPacienteAlterar.getText()));
					p.setIdade(Integer.parseInt(textoIdadePacienteAlterar.getText()));
					p.setCidade(textoCidadePacienteAlterar.getText());
					p.setDescricao(textoDescricaoPacienteAlterar.getText());
					
					tabelaPaciente.alterarPaciente(p);
					
					painelScrollTabelaPacientes.setViewportView(mostrarPacientes);
					
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar paiente", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		//painel pega id do paciente que vai ser alterado
		painelAlterarPaciente.setBounds(30, 30, 300, 300);
		painelAlterarPaciente.setLayout(null);
		
		escolhaIdPaciente.setBounds(20, 20, 300, 15);
		painelAlterarPaciente.add(escolhaIdPaciente);
		textoIdPaciente.setBounds(30, 50, 200, 25);
		painelAlterarPaciente.add(textoIdPaciente);
		
		botaoOkPaciAlterar.setBounds(80, 90, 100, 20);
		painelAlterarPaciente.add(botaoOkPaciAlterar);
		
		
		botaoOkPaciAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					textoNomePacienteAlterar.setText(tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())).getNome());
					textoIdadePacienteAlterar.setText(String.valueOf(tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())).getIdade()));
					textoCpfPacienteAlterar.setText(String.valueOf(tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())).getCpf()));
					textoCidadePacienteAlterar.setText(tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())).getCidade());
					textoDescricaoPacienteAlterar.setText(tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())).getDescricao());


					painelScrollTabelaPacientes.setViewportView(painelAlteraPaci);
					
					tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())).setId(tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())).getId());
					tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())).setNome(textoNomePacienteAlterar.getText());
					tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())).setIdade(Integer.parseInt(textoIdadePacienteAlterar.getText()));
					tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())).setCpf(Long.parseLong(textoCpfPacienteAlterar.getText()));
					tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())).setCidade(textoCidadePacienteAlterar.getText());
					tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())).setDescricao(textoCidadePacienteAlterar.getText());
					
					
					tabelaPaciente.alterarPaciente(tabelaPaciente.selectPaciente(Integer.parseInt(textoIdPaciente.getText())));
				} catch (NumberFormatException | UpdateException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar paiente", JOptionPane.ERROR_MESSAGE);
				}
						
						
				
			}
		});
		
    	
		
		botaoAlterarPaciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabelaPacientes.setViewportView(painelAlterarPaciente);		
				textoIdPaciente.setText("");
			}
		});
		
		
		
		
		
		//////////REMOVER PACIENTE//////////////-----------------------
		
		painelRemoverPaciente.setBounds(30, 30, 300, 300);
		painelRemoverPaciente.setLayout(null);
		
		escolhaIdRemoverPaciente.setBounds(20, 20, 300, 15);
		painelRemoverPaciente.add(escolhaIdRemoverPaciente);
		textoIdRemoverPaciente.setBounds(30, 50, 200, 25);
		painelRemoverPaciente.add(textoIdRemoverPaciente);
		
		botaoOkPaciRemove.setBounds(80, 90, 100, 20);
		painelRemoverPaciente.add(botaoOkPaciRemove);
		
		botaoOkPaciRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tabelaPaciente.removerPaciente(Integer.parseInt(textoIdRemoverPaciente.getText()));
					
					painelScrollTabelaPacientes.setViewportView(mostrarPacientes);
					
					textoIdRemoverPaciente.setText("");
				} catch (NumberFormatException | SelectException | DeleteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao remover paciente", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		botaoRemoverPaciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabelaPacientes.setViewportView(painelRemoverPaciente);
			}
		});
		
		
		

		/////////////////////// ---------- C O N S U L T A S ----------- ///////////////////////////////////////////////////


		painelScrollTabelaConsultas.setBounds(750, 30, 300, 300);
		JLabel titleConsulta=new JLabel("C O N S U L T A S");
		titleConsulta.setBounds(850, 10, 100, 15);
		painel.add(titleConsulta);
		painel.add(painelScrollTabelaConsultas);
		botaoMostrarConsultas.setBounds(750, 400, 157, 25);
		painel.add(botaoMostrarConsultas);
		botaoAdicionarConsulta.setBounds(750, 500, 157, 25);
		painel.add(botaoAdicionarConsulta);
		botaoAlterarConsulta.setBounds(750, 450, 157, 25);
		painel.add(botaoAlterarConsulta);
		botaoRemoverConsulta.setBounds(750, 550, 157, 25);
		painel.add(botaoRemoverConsulta);
		
		
		
		/////////////////////mostrar consultas------------------------------------
		
		
		mostrarConsultas=new JTable(tabelaConsulta);
		mostrarConsultas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mostrarConsultas.getColumnModel().getColumn(0).setMaxWidth(40);
		mostrarConsultas.getColumnModel().getColumn(1).setPreferredWidth(90);
		mostrarConsultas.getColumnModel().getColumn(2).setPreferredWidth(90);
		mostrarConsultas.getColumnModel().getColumn(3).setPreferredWidth(90);
		mostrarConsultas.getColumnModel().getColumn(4).setPreferredWidth(150);
		mostrarConsultas.getColumnModel().getColumn(5).setPreferredWidth(250);

		botaoMostrarConsultas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabelaConsultas.setViewportView(mostrarConsultas);
			}
		});
		painelScrollTabelaConsultas.setViewportView(mostrarConsultas);



		/////////////////////////////////ADICIONAR CONSULTAS------------------------------------------
		painelCadastrarConsulta.setBounds(30, 30, 300, 300);
		painelCadastrarConsulta.setLayout(null);

		escolhaMedico.setBounds(30, 20, 200, 15);
		painelCadastrarConsulta.add(escolhaMedico);
		textoEscolhaMedico.setBounds(30, 40, 200, 20);
		painelCadastrarConsulta.add(textoEscolhaMedico);

		escolhaPaciente.setBounds(30, 60, 200, 15);
		painelCadastrarConsulta.add(escolhaPaciente);
		textoEscolhaPaciente.setBounds(30, 80, 200, 20);
		painelCadastrarConsulta.add(textoEscolhaPaciente);

		dataConsulta.setBounds(30,100, 200, 15);
		painelCadastrarConsulta.add(dataConsulta);
		textoDataConsulta.setBounds(30, 120, 200, 20);
		painelCadastrarConsulta.add(textoDataConsulta);

		horarioConsulta.setBounds(30, 140, 200, 15);
		painelCadastrarConsulta.add(horarioConsulta);
		textoHorarioConsulta.setBounds(30, 160, 200, 20);
		painelCadastrarConsulta.add(textoHorarioConsulta);

		diagnosticoConsulta.setBounds(30, 180, 200, 15);
		painelCadastrarConsulta.add(diagnosticoConsulta);
		textoDiagnosticoConsulta.setBounds(30, 200, 200, 20);
		painelCadastrarConsulta.add(textoDiagnosticoConsulta);

		valorConsulta.setBounds(30, 220, 200, 15);
		painelCadastrarConsulta.add(valorConsulta);
		textoValorConsulta.setBounds(30, 240, 200, 20);
		painelCadastrarConsulta.add(textoValorConsulta);

		botaoOkConsulta.setBounds(80, 260, 100, 20);
		painelCadastrarConsulta.add(botaoOkConsulta);

		botaoOkConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Consulta c=new Consulta();
					c.setId_medico(Integer.parseInt(textoEscolhaMedico.getText()));
					c.setId_paciente(Integer.parseInt(textoEscolhaPaciente.getText()));
					c.setData(textoDataConsulta.getText());
					c.setValor(Float.parseFloat(textoValorConsulta.getText()));
					c.setHora(textoHorarioConsulta.getText());
					c.setDiagnostico(textoDiagnosticoConsulta.getText());

					tabelaConsulta.adicionarConsulta(c);

					textoEscolhaMedico.setText("");
					textoDataConsulta.setText("");
					textoEscolhaPaciente.setText("");
					textoHorarioConsulta.setText("");
					textoDiagnosticoConsulta.setText("");
					textoValorConsulta.setText("");

				} catch (InsertException | SelectException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao adicionar consulta", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		botaoAdicionarConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabelaConsultas.setViewportView(painelCadastrarConsulta);

			}
		});


		///////////////////////////ALTERAR CONSULTAS------------------------------------------------

		painelAlterarConsu.setBounds(30, 30, 300, 300);
		painelAlterarConsu.setLayout(null);

		escolhaMedicoAlterar.setBounds(30, 20, 200, 15);
		painelAlterarConsu.add(escolhaMedicoAlterar);
		textoEscolhaMedicoAlterar.setBounds(30, 40, 200, 20);
		painelAlterarConsu.add(textoEscolhaMedicoAlterar);

		escolhaPacienteAlterar.setBounds(30, 60, 200, 15);
		painelAlterarConsu.add(escolhaPacienteAlterar);
		textoEscolhaPacienteAlterar.setBounds(30, 80, 200, 20);
		painelAlterarConsu.add(textoEscolhaPacienteAlterar);

		dataConsultaAlterar.setBounds(30,100, 200, 15);
		painelAlterarConsu.add(dataConsultaAlterar);
		textoDataConsultaAlterar.setBounds(30, 120, 200, 20);
		painelAlterarConsu.add(textoDataConsultaAlterar);

		horarioConsultaAlterar.setBounds(30, 140, 200, 15);
		painelAlterarConsu.add(horarioConsultaAlterar);
		textoHorarioConsultaAlterar.setBounds(30, 160, 200, 20);
		painelAlterarConsu.add(textoHorarioConsultaAlterar);

		diagnosticoConsultaAlterar.setBounds(30, 180, 200, 15);
		painelAlterarConsu.add(diagnosticoConsultaAlterar);
		textoDiagnosticoConsultaAlterar.setBounds(30, 200, 200, 20);
		painelAlterarConsu.add(textoDiagnosticoConsultaAlterar);

		valorConsultaAlterar.setBounds(30, 220, 200, 15);
		painelAlterarConsu.add(valorConsultaAlterar);
		textoValorConsultaAlterar.setBounds(30, 240, 200, 20);
		painelAlterarConsu.add(textoValorConsultaAlterar);

		botaoConsultaAlterado.setBounds(80, 265, 100, 20);
		painelAlterarConsu.add(botaoConsultaAlterado);

		botaoConsultaAlterado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					Consulta c=new Consulta();
					c.setId(Integer.parseInt(textoIdConsulta.getText()));
					c.setId_medico(Integer.parseInt(textoEscolhaMedicoAlterar.getText()));
					c.setId_paciente(Integer.parseInt(textoEscolhaPacienteAlterar.getText()));
					c.setData(textoDataConsultaAlterar.getText());
					c.setValor(Float.parseFloat(textoEscolhaPacienteAlterar.getText()));
					c.setHora(textoHorarioConsultaAlterar.getText());
					c.setDiagnostico(textoDiagnosticoConsultaAlterar.getText());

					tabelaConsulta.alterarConsulta(c);
					

					painelScrollTabelaConsultas.setViewportView(mostrarConsultas);
					
					textoIdConsulta.setText("");
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar consulta", JOptionPane.ERROR_MESSAGE);
				}
				

			}
		});

		//painel pega id da consulta que vai ser alterado
		painelAlterarConsulta.setBounds(30, 30, 300, 300);
		painelAlterarConsulta.setLayout(null);

		escolhaIdConsulta.setBounds(20, 20, 300, 15);
		painelAlterarConsulta.add(escolhaIdConsulta);
		textoIdConsulta.setBounds(30, 50, 200, 25);
		painelAlterarConsulta.add(textoIdConsulta);

		botaoOkConsuAlterar.setBounds(80, 90, 100, 20);
		painelAlterarConsulta.add(botaoOkConsuAlterar);


		botaoOkConsuAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					textoEscolhaPacienteAlterar.setText(String.valueOf(tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).getId_paciente()));
					textoEscolhaMedicoAlterar.setText(String.valueOf(tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).getId_medico()));
					textoDataConsultaAlterar.setText(tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).getData());
					textoHorarioConsultaAlterar.setText(tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).getHora());
					textoDiagnosticoConsultaAlterar.setText(tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).getDiagnostico());
					textoValorConsultaAlterar.setText(String.valueOf(tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).getValor()));


					painelScrollTabelaConsultas.setViewportView(painelAlterarConsu);
					
					tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).setId(tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).getId());
					tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).setId_medico(Integer.parseInt(textoEscolhaMedicoAlterar.getText()));
					tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).setId_paciente(Integer.parseInt(textoEscolhaPacienteAlterar.getText()));
					tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).setData(textoDataConsultaAlterar.getText());
					tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).setHora(textoDataConsultaAlterar.getText());
					tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).setDiagnostico(textoDiagnosticoConsultaAlterar.getText());
					tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())).setValor(Float.parseFloat(textoValorConsultaAlterar.getText()));
					
					
					tabelaConsulta.alterarConsulta(tabelaConsulta.selectConsulta(Integer.parseInt(textoIdConsulta.getText())));
				} catch (NumberFormatException | UpdateException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao alterar consulta", JOptionPane.ERROR_MESSAGE);
				}


			}
		});



		botaoAlterarConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabelaConsultas.setViewportView(painelAlterarConsulta);		
			}
		});




		///////////////////////////////REMOVER CONSULTAS////--------------------------------------


		painelRemoverConsulta.setBounds(30, 30, 300, 300);
		painelRemoverConsulta.setLayout(null);

		escolhaIdRemoverConsulta.setBounds(20, 20, 300, 15);
		painelRemoverConsulta.add(escolhaIdRemoverConsulta);
		textoIdRemoverConsulta.setBounds(30, 50, 200, 25);
		painelRemoverConsulta.add(textoIdRemoverConsulta);

		botaoOkConsuRemove.setBounds(80, 90, 100, 20);
		painelRemoverConsulta.add(botaoOkConsuRemove);

		botaoOkConsuRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tabelaConsulta.removerConsulta(Integer.parseInt(textoIdRemoverConsulta.getText()));
					
					painelScrollTabelaConsultas.setViewportView(mostrarConsultas);
					textoIdRemoverConsulta.setText("");
					
					
				} catch (NumberFormatException | DeleteException | SelectException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro ao remover consulta", JOptionPane.ERROR_MESSAGE);
				}
				

			}
		});

		botaoRemoverConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painelScrollTabelaConsultas.setViewportView(painelRemoverConsulta);
			}
		});


		
	}
	
	
	
	
	public static void main(String[] args) {
		Hospital frame=new Hospital();
		frame.setVisible(true);

	}

}
