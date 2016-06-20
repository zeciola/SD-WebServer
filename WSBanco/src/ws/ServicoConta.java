package ws;

import umc.sd.banco.Conta;

public class ServicoConta {
	
	public String[] consultarDadosConta(int idConta, String senha) {
		System.out.println("Dentro do m�todo consultarDadosConta ");
		String[] dadosConta = null;
			
		try {
			Conta conta = new Conta();
			conta.setId(idConta);
			conta.setSenha(senha);
			
			if (conta.recuperar()) {
				dadosConta = new String[2];
				dadosConta[0] = conta.getNome();
				dadosConta[1] = Double.toString(conta.getSaldo());
				System.out.println("Dentro do if consultarConta	");
			} else {
				System.out.println("N�o foi poss�vel recuperar a conta com o id " + idConta);
			}
		
		}catch (Exception erro) {
			System.out.println("Erro no servi�o consultarDadosConta: " + erro.getMessage());
		}
			
		return dadosConta;		
	}

	
	
	//Cadastrar

	public boolean cadastroConta(String nome, String senha) {

		System.out.println("Dentro do m�todo cadastroConta ");
		
		Conta conta = new Conta();
		
		
		try {
			
			if (conta.cadastrar(nome, senha)) {
				
				System.out.println("A conta foi cadastrada com sucesso!");
				
				return true;
				
			} 
			else {
				
				System.out.println("Conta n�o foi cadastrada!!!");
				
				return false;
			}
		
		}
		catch (Exception erro) {
			
			System.out.println("Erro no servi�o de cadastro conta(cadastroConta): " + erro.getMessage());
			
		}
			
		return false;
		
	}
	
	public Integer cadastroContaNovo(String nome, String senha, int idConta) {
		
		System.out.println("Dentro do m�todo cadastroContaNovo");
		
		
		
		try {
			
			//Conta conta = new Conta();
			
			//int i = conta.cadastrarNovo(nome, senha);
			return 0;
		
		}
		catch (Exception erro) {
			
			System.out.println("Erro no servi�o cadastroConta: " + erro.getMessage());
		}
		return 0;
	}
	
	
	public boolean saqueConta(double valor, int idConta, String senha) {
		
		System.out.println("Dentro do m�todo saqueConta!!!!!!!!!!!!!!!!!!!!");
		
		System.out.println("Sua senha �: "+ senha);
		
		System.out.println("Seu id �: "+ idConta);
		
		System.out.println("Seu saldo �: "+ valor);
		
		
		Conta conta = new Conta();
		
		conta.setId(idConta);
		
		conta.setSenha(senha);
		
		
		try {
			if (conta.saque(valor)) {
				
				System.out.println("Saque realizado com sucesso!");
				
				return true;
				
			}
			
			else {
				
				System.out.println("Saque n�o foi realizado!");
				
				return false;
			}
		
		}
		catch (Exception e) {
			
			System.out.println("Erro no servi�o saque de conta(saqueConta): " + e.getMessage());
			
		}
			
		return false;		
	}
	
	public boolean depositoConta(double valor, int idConta, String senha) {
		
		System.out.println(" A senha: "+senha);
		System.out.println("Dentro do m�todo depositoConta!!!!!!!!!!! ");
		
		Conta conta = new Conta();
		
		conta.setId(idConta);
		conta.setSenha(senha);

		try {
				if (conta.deposito(valor)) {
					
					System.out.println("Deposito foi realizado.");
					return true;
					
				} else {
					System.out.println("Deposito n�o foi realizado.");
					return false;
				}

		}catch (Exception e) {
			System.out.println("Erro no servi�o depositoConta: " + e.getMessage());
		}
			
		return false;		
	}
	

}
