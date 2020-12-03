package Ewig.model.VO;

public class AutorVO extends UsuarioVO{
	private ObraVO[] obras;
	
	public AutorVO() {
		
	}
	
	public AutorVO (String login, String senha, int tipoAcesso, String nome, String cpf, String endereco, String telefone) {
		super(login, senha, tipoAcesso, nome, cpf, endereco, telefone);
		//setObras(obras);
	}
	
	public ObraVO[] getObras() {
		return obras;
	}
	
	public void setObras(ObraVO[] obras) {
		if(obras != null){
			this.obras = obras;
		} else {
			System.out.println("Vetor de obras nulo");
		}	
	}
}