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
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;

public class RelatorioController {
	GerenteBO geBo = new GerenteBO();
	ObraBO obBo = new ObraBO();
	
	@FXML private DatePicker campoDataInicial;
	@FXML private DatePicker campoDataFinal;
	
	@FXML private CheckBox checkAceito;
	@FXML private CheckBox checkRejeitado;
	
	public void gerarRelatorio() {
		if ((campoDataInicial.getValue() == null) != (campoDataFinal.getValue() == null)) {
			Alert a = new Alert(AlertType.WARNING);
			a.setHeaderText("Por favor, preencha o campo vazio do Filtro por data");
			a.show();
			return;
		}
		else {
			List<ObraVO> obras;
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			
			if (campoDataInicial.getValue() != null && campoDataFinal.getValue() != null) {
				cal1.setTime(Date.from(Instant.from(campoDataInicial.getValue().atStartOfDay(ZoneId.systemDefault()))));
				cal2.setTime(Date.from(Instant.from(campoDataFinal.getValue().atStartOfDay(ZoneId.systemDefault()))));
				
				obras = obBo.buscarPorPeriodo(cal1, cal2);
			}
			else {
				obras = obBo.listar();
				cal1 = null;
				cal2 = null;
			}
			
			Iterator<ObraVO> iter = obras.iterator();
			while(iter.hasNext()) {
				ObraVO ob = iter.next();
				if(ob.getStatus().contentEquals("Em Avaliação"))
					iter.remove();
			}
			
			if(checkAceito.isSelected() != checkRejeitado.isSelected()) {
				if(checkAceito.isSelected()) {
					while(iter.hasNext()) {
						ObraVO ob = iter.next();
						if(!ob.getStatus().contentEquals("Aprovado"))
							iter.remove();
					}
				} 
				else {
					while(iter.hasNext()) {
						ObraVO ob = iter.next();
						if(!ob.getStatus().contentEquals("Rejeitado"))
							iter.remove();
					}
				}
			}
			if (cal1 == null && cal2 == null)
				geBo.gerarRelatorio(obras);
			else
				geBo.gerarRelatorio(obras, cal1, cal2);
		}
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
