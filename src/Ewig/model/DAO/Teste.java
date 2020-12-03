package Ewig.model.DAO;

import java.sql.SQLException;
import java.util.List;

import Ewig.model.VO.AutorVO;

public class Teste {
	public static void main(String args[]) {
		//AutorVO autor = new AutorVO("higorbreno", "abacaxi", 10, "Higor Breno", "65257925095", "Rua Poeta Manuel Calixto", "84991234567");
		//AutorVO autor2 = new AutorVO("feliperibeiro", "banana", 5, "Felipe Ribeiro", "57193522019", "Rua Paulo Ferreira Maia", "84987654321");
		try {
			AutorDAO aDao = new AutorDAO();
			//aDao.cadastrar(autor);
			//aDao.cadastrar(autor2);
			//System.out.println("Id: " + autor.getId());
			//System.out.println("Id2: " + autor2.getId());
			//List<AutorVO> autores = aDao.listar();
			//for(AutorVO a : autores) {
				//a.setEndereco("Rua da mãe joana");
				//aDao.atualizar(a);
			//}
			AutorVO au = new AutorVO();
			au = aDao.buscarPorNome("Hig");
			System.out.println(au.getNome());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fim do Programa.");
	}
}
