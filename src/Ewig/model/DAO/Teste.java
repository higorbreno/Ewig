package Ewig.model.DAO;

import Ewig.model.VO.AutorVO;

public class Teste {
	public static void main(String args[]) {
		AutorVO autor = new AutorVO("higorbreno", "abacaxi", 10, "Higor Breno", "65257925095", "Rua Poeta Manuel Calixto", "84991234567");
		AutorDAO aDao = new AutorDAO();
		aDao.cadastrar(autor);
		
	}
}
