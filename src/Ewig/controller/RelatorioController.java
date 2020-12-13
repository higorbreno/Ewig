package Ewig.controller;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Ewig.model.BO.GerenteBO;
import Ewig.model.BO.ObraBO;
import Ewig.model.VO.ObraVO;
import Ewig.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RelatorioController {
	GerenteBO geBo = new GerenteBO();
	ObraBO obBo = new ObraBO();
	
	@FXML private DatePicker campoDataInicial;
	@FXML private DatePicker campoDataFinal;
	
	@FXML private CheckBox checkAceito;
	@FXML private CheckBox checkRejeitado;
	
	@FXML private TextField campoNomeArquivo;
	
	public void gerarRelatorio() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.setTime(Date.from(Instant.from(campoDataInicial.getValue().atStartOfDay(ZoneId.systemDefault()))));
		cal2.setTime(Date.from(Instant.from(campoDataFinal.getValue().atStartOfDay(ZoneId.systemDefault()))));
		
		List<ObraVO> obras = obBo.buscarPorPeriodo(cal1, cal2);
		
		if(checkAceito.isSelected() != checkRejeitado.isSelected()) {
			if(checkAceito.isSelected()) {
				Iterator<ObraVO> iter = obras.iterator();
				while(iter.hasNext()) {
					ObraVO ob = iter.next();
					if(!ob.getStatus().contentEquals("Aprovado"))
						iter.remove();
				}
			} else {
				Iterator<ObraVO> iter = obras.iterator();
				while(iter.hasNext()) {
					ObraVO ob = iter.next();
					if(!ob.getStatus().contentEquals("Rejeitado"))
						iter.remove();
				}
			}
		}
		
		geBo.gerarRelatorio(obras, campoNomeArquivo.getText(), cal1, cal2);
	}
	
	public void irVoltarMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
