package Ewig.model.BO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Ewig.exception.AtributoInvalidoException;
import Ewig.exception.LoginExistenteException;
import Ewig.model.DAO.UsuarioDAO;
import Ewig.model.VO.UsuarioVO;

public class UsuarioBO<VO extends UsuarioVO> implements UsuarioInterBO<VO>{
	
	UsuarioDAO<VO> dao = new UsuarioDAO<VO>();
	
	public void cadastrar(VO us) throws LoginExistenteException { //0 = GERENTE; 1 = AVALIADOR; 2 = AUTOR
		try {	
			if (buscar(us,0).size() == 0) {

					switch (us.getTipoUsuario()) {
					case 0:
						dao.cadastrar(us,"gerente");				
					break;
					case 1:
						dao.cadastrar(us,"avaliador");
					break;
					case 2:
						dao.cadastrar(us,"autor");
					break;
					default:
						System.out.println("Valor invalido em TipoUsuario no Mestre, problema no UsuarioBO.cadastrar");
					}
			}		
			else throw new LoginExistenteException("O login já existe");
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("SQLException em UsuarioBO.cadastrar");
		}	
	}

	public void excluir(VO us) {
		try {
			switch (us.getTipoUsuario()) {
				case 0:
					dao.excluir(us,"gerente");
				break;
				case 1:
					dao.excluir(us,"avaliador");
				break;
				case 2:
					dao.excluir(us,"autor");
				break;
				default:
					System.out.println("Valor invalido em TipoUsuario no Mestre, problema no UsuarioBO.excluir");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(VO us) {
		try {
			System.out.println(us.getTipoUsuario());
			switch (us.getTipoUsuario()) {
				case 0:
					dao.atualizar(us,"gerente");
				break;
				case 1:
					dao.atualizar(us,"avaliador");
				break;
				case 2:
					dao.atualizar(us,"autor");
				break;
				default:
					System.out.println("Valor invalido em TipoUsuario no Mestre, problema no UsuarioBO.editar");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<UsuarioVO> listar(int tipoUsu) { // listar ususarios da tabela... 0=gerente; 1=avaliador; 2=autor; 3=todas
		List<UsuarioVO> listaVO = new ArrayList<UsuarioVO>();
		ResultSet rs = null;
		
		try {
			switch (tipoUsu) {
				case 0:
					rs = dao.listar("gerente");
				break;
				case 1:
					rs = dao.listar("avaliador");
				break;
				case 2:
					rs = dao.listar("autor");
				break;
				case 3:
					listaVO.addAll(listar(0));
					listaVO.addAll(listar(1));
					listaVO.addAll(listar(2));
					return listaVO;
				default:
					System.out.println("Parametro invalido na chamada do metodo listar() de UsuarioBO.java");
			}

			while (rs.next()) {
				UsuarioVO elemento = new UsuarioVO();
			
				elemento.setTipoUsuario(tipoUsu); //0 = gerente; 1 = avaliador; 2 = autor
				elemento.setId(rs.getLong(1));
				elemento.setNome(rs.getString(2));
				elemento.setCpf(rs.getString(3));
				elemento.setEndereco(rs.getString(4));
				elemento.setTelefone(rs.getString(5));
				elemento.setLogin(rs.getString(6));
				elemento.setSenha(rs.getString(7));
				elemento.setPermissaoAcesso(rs.getBoolean(8));
			
				listaVO.add(elemento);
			}
		} catch (SQLException | AtributoInvalidoException e) {
			e.printStackTrace();	
		}
		return listaVO;
	}
	
	
	public List<UsuarioVO> buscar(VO us, int tipoPesq){ 
		List<UsuarioVO> listaVO = new ArrayList<UsuarioVO>();	
		
			switch (tipoPesq) {
				case 0: // busca por LOGIN
					listaVO.addAll(listar(3));
					Iterator<UsuarioVO> iter = listaVO.iterator();
					while(iter.hasNext()) {
						UsuarioVO u = iter.next();
						if(us.getLogin() == null || !u.getLogin().contentEquals(us.getLogin()))
							iter.remove();
					}
					break;
				case 1: // busca por NOME
					listaVO.addAll(listar(3));
					Iterator<UsuarioVO> iter2 = listaVO.iterator();
					while(iter2.hasNext()) {
						UsuarioVO u = iter2.next();
						if(us.getNome() == null || !u.getNome().contentEquals(us.getNome()))
							iter2.remove();
					}
					break;
				case 2: // busca por ID na tabela GERENTE
					listaVO.addAll(listar(0));
					Iterator<UsuarioVO> iter3 = listaVO.iterator();
					while(iter3.hasNext()) {
						UsuarioVO u = iter3.next();
						if(u.getId() != us.getId())
							iter3.remove();
					}	
					break;
				case 3: // busca por ID na tabela AVALIADOR
					listaVO.addAll(listar(1));
					Iterator<UsuarioVO> iter4 = listaVO.iterator();
					while(iter4.hasNext()) {
						UsuarioVO u = iter4.next();
						if(u.getId() != us.getId())
							iter4.remove();
					}
					break;
				case 4: // busca por ID na tabela AUTOR
					listaVO.addAll(listar(2));
					Iterator<UsuarioVO> iter5 = listaVO.iterator();
					while(iter5.hasNext()) {
						UsuarioVO u = iter5.next();
						if(u.getId() != us.getId())
							iter5.remove();
					}
					break;
				default: 
					System.out.println("Parametro invalido na chamada do metodo buscar() de UsuarioBO.java");
			}
		return listaVO;
	}
	
	public List<UsuarioVO> buscarPorNomeECpf(UsuarioVO us, int tipoUsu) {
		List<UsuarioVO> list;
		
		list = listar(tipoUsu);
		if(us.getNome() != null) {
			Iterator<UsuarioVO> iter = list.iterator();
			while(iter.hasNext()) {
				UsuarioVO u = iter.next();
				if(us.getNome() != null && !u.getNome().contains(us.getNome())) {
					iter.remove();
					continue;
				}
				if(us.getCpf() != null && !u.getCpf().equals(us.getCpf())) {
					iter.remove();
					continue;
				}
			}
		}
		
		return list;
	}
	
	public List<UsuarioVO> listarUsuariosSemPermissao() {
		List<UsuarioVO> list = new ArrayList<UsuarioVO>();
		list.addAll(listar(0));
		list.addAll(listar(1));
		list.addAll(listar(2));
		
		Iterator<UsuarioVO> iter = list.iterator();
		while(iter.hasNext()) {
			UsuarioVO usu = iter.next();
			if(usu.getPermissaoAcesso() == true)
				iter.remove();
		}
		return list;
	}
}