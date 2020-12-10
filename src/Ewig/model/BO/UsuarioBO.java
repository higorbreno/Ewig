package Ewig.model.BO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ewig.model.DAO.UsuarioDAO;
import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.UsuarioVO;

public class UsuarioBO<VO extends UsuarioVO> implements UsuarioInterBO<VO>{
	
	UsuarioDAO<UsuarioVO> dao = new UsuarioDAO<UsuarioVO>();
	
	public void cadastrar(VO us, String tipoUs) {
		/*try {
			//dao.cadastrar(us);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	public void excluir(VO us) {
		//ainda não implementado
	}
	
	public void editar(VO us) {
		//ainda não implementado
	}
	
	public void visulaizarDados(VO us) {
		//ainda não implementado
	}
	
	public UsuarioVO[] listar() {
		UsuarioVO usuario[] = new AvaliadorVO[2]; //número aleatório, implementar de formar dinâmica
		
		//ainda não implementado
		
		return usuario;
	}
	
	public UsuarioVO buscar(VO us, int tipo) {
		try {
		List<UsuarioVO> listaVO = new ArrayList<UsuarioVO>();
			
		ResultSet rs = null;
		rs = dao.buscarPorLogin(us, "Gerente");
		while (rs.next()) {
			System.out.println("Gerente");
			UsuarioVO elemento = new UsuarioVO();
			
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
			
		rs = dao.buscarPorLogin(us, "Autor");
		while (rs.next()) {
			System.out.println("autor");
			UsuarioVO elemento = new UsuarioVO();
			
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
			
		rs = dao.buscarPorLogin(us, "Avaliador");
		while (rs.next()) {
			System.out.println("avaliador");
			UsuarioVO elemento = new UsuarioVO();
			
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
		
		for (UsuarioVO u : listaVO) {
			
			if (tipo == 0) { // busca por LOGIN
				if (vo.getLogin().equals(u.getLogin())) {
					return u;
				}
			}
				else if (tipo == 1) { // busca por ID
					if (vo.getId().equals(u.getId())) {
						return u;
					}
				}
					else if (tipo == 2) { // busca por NOME
						if (vo.getNome().equals(u.getNome())) {
							return u;
						}
					}
		}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	 

	
	public List<UsuarioVO> listarUsuariosSemPermissao(){
		ResultSet rs;
		List<UsuarioVO> list = new ArrayList<UsuarioVO>();
		try {
			rs = dao.listarUsuariosSemPermissao();
			while (rs.next()) {
				UsuarioVO elemento = new UsuarioVO();
				
				elemento.setId(rs.getLong(1));
				elemento.setNome(rs.getString(2));
				elemento.setCpf(rs.getString(3));
				elemento.setEndereco(rs.getString(4));
				elemento.setTelefone(rs.getString(5));
				elemento.setLogin(rs.getString(6));
				elemento.setSenha(rs.getString(7));
				elemento.setPermissaoAcesso(rs.getBoolean(8));
				
				list.add(elemento);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}