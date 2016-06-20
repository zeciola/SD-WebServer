package umc.sd.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conta {
	
	private int idConta;
	private String nome;
	private String senha;
	private double saldo;
	
	
	
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public int getIdConta() {
		return idConta;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	

	/**
	 * Atualiza o BD retirando o valor quantia do saldo atual da conta
	 * 
	 * @param quantia 	a quantia desejada para realizar o saque
	 * @return		Boolean indicando se opera��o obteve sucesso
	 */
	public boolean saque(double quantia) {
		recuperar();
		
		System.out.println("Dentro do metodo saque!!!!!!!!!!!!!!!!!!!!");
		
		System.out.println("Seu id �: "+ idConta);
		
		//Conta conta = new Conta();
		
		System.out.println("este � o saldo"+getSaldo());
		
		//quantia = conta.getSaldo();
		
		System.out.println("Sua quantia �: "+ quantia);
		
		if((saldo >= quantia)&&(saldo > 0)){
			
			System.out.println("Dentro do if saque");
			
			Connection con = null;
			
			PreparedStatement pstmt = null;
			
			try{
				System.out.println("dentro do try saque");
				
				con = this.getConexao();
				
				pstmt = con.prepareStatement("update conta set saldo = saldo - ? WHERE idconta = ? and senha = ?");
				
				pstmt.setDouble(1, quantia);
				pstmt.setInt(2, this.getIdConta());
				pstmt.setString(3, this.getSenha());
				pstmt.execute();
				
				con.close();
				
			}
			catch(Exception erro){
				System.out.println("Falha de conex�o: "+ erro.getMessage());
				erro.printStackTrace();
			}
			return true;
		}
		else{			
			return false;
		}
		
	}
	

	/**
	 * Atualiza o BD adicionando a quantia do dep�sito ao saldo atual da conta
	 * 
	 * @param quantia	A quantia a ser adicionada ao saldo
	 * @return		Boolean indicando se opera��o obteve sucesso
	 */
	public boolean deposito(double quantia) {
		System.out.println("Dentro do m�todo deposito()");	
		recuperar();
		if(quantia > 0){
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
				con = this.getConexao();
				
				pstmt = con.prepareStatement("update conta set saldo = saldo + ? WHERE idconta = ? and senha = ?");
				
				pstmt.setDouble(1, quantia);
				pstmt.setInt(2, this.getIdConta());
				pstmt.setString(3, this.getSenha());
				pstmt.execute();
				
				con.close();
			}catch(Exception erro){
				System.out.println("Falha erro: "+erro.getMessage());
				erro.printStackTrace();
			}
			
			return true;
		}else{
			return false;
		}
	}
	
	/*	Cadastro  */
	
	public boolean cadastrar (String nome, String senha ){
		
		Connection con = null;
		
		PreparedStatement pstmt = null;
		
		try {
			
			con = this.getConexao();
			
			pstmt = con.prepareStatement("insert into conta values (nextval('serial'), ?, 0, ?))");

			pstmt.setString(1, nome);
			
			pstmt.setString(2, senha);
			
			pstmt.execute();
			
			con.close();
			
			return true;
		
		}
		catch(Exception erro) {
			System.out.println("Falha de conex�o: " + erro.getMessage());
			erro.printStackTrace();
			return false;
		}
	}
	
	
	//Recuperar idconta
	public Integer cadastrarNovo (String nome, String senha, int id){
		
		System.out.println("passei aki 1");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int e = 0;
		
		try {
			
			con = this.getConexao();
			
			pstmt = con.prepareStatement("insert into conta values (nextval('serial'), ?, 0, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, nome);
			
			pstmt.setString(2, senha);
			
			pstmt.executeUpdate();
			
			con.close();
			
			System.out.println("passei aki 2");
			
			ResultSet res = pstmt.getGeneratedKeys();
			
			 if (res.next()) {
				 
	                e = res.getInt("idconta");
	                
	                System.out.println("idconta dentro do if: " + e);
	                
	                System.out.println("passei aki 3");
			 }
			 
			 System.out.println("passei aki 4");
			 
			 
			return e;
			
		}
		catch(Exception erro){
			
			System.out.println("Falha de conex�o: " + erro.getMessage());
			erro.printStackTrace();
			return 0;
			
		}
		
	}
	
	/**
	 * Consulta no BD as informa��es da conta dado o valor salvo no atributo id
	 * @return		Boolean indicando se opera��o obteve sucesso
	 */
	public boolean recuperar() {
		
		System.out.println("Dentro do m�todo recuperar()");
		
		boolean resultado = false;
		Connection con = null;
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
        
        try {
        	con = this.getConexao();
        	
        	stmt = con.prepareStatement("SELECT nome,saldo FROM conta WHERE idconta = ? and senha = ?");
        	

			stmt.setInt(1, this.getIdConta());
			stmt.setString(2, this.getSenha());
			
			rs = stmt.executeQuery();

			if (rs.next()) {
				this.setIdConta(rs.getInt("idconta"));
				this.setNome(rs.getString("nome"));
				this.setSaldo(rs.getDouble("saldo"));
				this.setSenha(rs.getString("senha"));
				
				System.out.println("Seu saldo �:"+getSaldo());
				
				resultado = true;
			}
			
			con.close();
			
        } catch (Exception erro) {
        	System.out.println("Erro no m�todo recuperar: " + erro.getMessage());
			erro.printStackTrace();
        }
		
        return resultado;
	}
	
	
	/**
	 * Realiza a conex�o com o banco de dados
	 * @return	O objeto da conex�o, null se houver erro
	 */
	private Connection getConexao() {
		Connection con = null;

        try{
           String url ="jdbc:postgresql://localhost:5432/dbbanco";
           String usuario="postgres";
           String senha = "postgres";
           Class.forName("org.postgresql.Driver");
           con = DriverManager.getConnection(url,usuario,senha);
           
           System.out.println("A conex�o com o banco foi realizada com sucesso (dbbanco)");
           
        }catch(Exception e) {
            System.out.println("Falha de conex�o: " + e.getMessage());
        }

        return con;
	}
	
}
