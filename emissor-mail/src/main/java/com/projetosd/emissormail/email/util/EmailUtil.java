package com.projetosd.emissormail.email.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailUtil {
	
	public static String emailBody = "<h4>Prezado <strong>@ @</strong>, tudo bem?</h4>\r\n" + 
			"\r\n" + 
			"<p>Segue as informa&ccedil;&otilde;es referentes ao seu atendimento para o teste de COVID-19</p>\r\n" + 
			"\r\n" + 
			"<div>\r\n" + 
			"<div style=\"background:#eee;border:1px solid #ccc;padding:5px 10px;\">\r\n" + 
			"<p><strong>Data de atendimento:</strong>&nbsp;@&nbsp;</p>\r\n" + 
			"\r\n" + 
			"<p><strong>Atendente:</strong>&nbsp;@ @&nbsp; &nbsp;<strong>Identifica&ccedil;&atilde;o:</strong>&nbsp;@</p>\r\n" + 
			"\r\n" + 
			"<p><strong>Paciente:</strong>&nbsp;@ @&nbsp; &nbsp; &nbsp;<strong>Sexo: </strong>@&nbsp; &nbsp;<strong>PCD:</strong>&nbsp; @</p>\r\n" + 
			"\r\n" + 
			"<p style=\"text-align:justify\"><strong>Endere&ccedil;o:</strong>&nbsp; @&nbsp; &nbsp; &nbsp; &nbsp;<strong>N&ordm;:</strong>&nbsp;@&nbsp; &nbsp; &nbsp; &nbsp;<strong>Bairro:</strong>&nbsp;@&nbsp;&nbsp;</p>\r\n" + 
			"\r\n" + 
			"<p style=\"text-align:justify\"><strong>Cidade: </strong>@&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<strong>UF:&nbsp;</strong>@&nbsp; &nbsp; &nbsp;&nbsp;<strong>CEP:</strong>&nbsp;@</p>\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"\r\n" + 
			"<p>&nbsp;</p>\r\n" + 
			"\r\n" + 
			"<div style=\"background:#eee;border:1px solid #ccc;padding:5px 10px;\">\r\n" + 
			"<p>Atenciosamente,</p>\r\n" + 
			"\r\n" + 
			"<p><strong>Departamento de Teste</strong></p>\r\n" + 
			"\r\n" + 
			"<p>www.teste.com | (81) 9999-9999</p>\r\n" + 
			"</div>\r\n" + 
			"";
	
		public static String formatDate(Date date) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			return df.format(date);
		}

}
