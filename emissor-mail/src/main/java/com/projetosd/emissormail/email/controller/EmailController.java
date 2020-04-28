package com.projetosd.emissormail.email.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.LoggerFactory;

import com.projetosd.emissormail.email.model.Email;
import com.projetosd.emissormail.email.util.EmailUtil;
import com.projetosd.entities.Atendimento;

public class EmailController {
	
	org.slf4j.Logger logger =  LoggerFactory.getLogger(EmailController.class);

	private String host;
	
	private String socketFactoryPort;
	
	private String socketFactoryClass;
	
	private String auth;
	
	private String port;
	
	private String user;
	
	private String password;
	
	private Session session;
	
	private Message message;
	
	private String emailBody;
	
	private Properties emailProp;
	
	public EmailController () {
		emailProp = getProp();
		
		host = emailProp.getProperty("email.host");
		socketFactoryPort = emailProp.getProperty("email.socketFactoryPort");
		socketFactoryClass = emailProp.getProperty("email.socketFactoryClass");
		auth = emailProp.getProperty("email.auth");
		port = emailProp.getProperty("email.port");
		user = emailProp.getProperty("email.user");
		password = emailProp.getProperty("email.password");
		emailBody = emailProp.getProperty("email.password");
		
	}
	
	public Properties getProp() {
        Properties props = new Properties();
        FileInputStream file;
		try {
			file = new FileInputStream("./src/main/resources/email.properties");
			props.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	   return props;
	 }
	
	public void authentication(){
		Properties props = new Properties();

		props.put("mail.smtp.host", host);
		props.put("mail.smtp.socketFactory.port", socketFactoryPort);
		props.put("mail.smtp.socketFactory.class", socketFactoryClass);
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.port", port);

		session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		logger.info("Successfully authenticated email controller");
	}
	
	public void sendMail(Email email) {
		try {
		      Message message = new MimeMessage(session);
		      message.setFrom(new InternetAddress(email.getFrom())); 
		 
		      Address[] toUser = InternetAddress.parse(email.getTo());  
		 
		      message.setRecipients(Message.RecipientType.TO, toUser);
		      message.setSubject(email.getSubject());
		      message.setContent(email.getBody(), "text/html; charset=utf-8");
		      Transport.send(message);
		 
		      logger.info("E-mail sent to: " + email.getTo());
		 
		     } catch (MessagingException e) {
		    	logger.error("E-mail not sent to: " + email.getTo());
		    	logger.error(e.getMessage());
		    }
		  
	}
	
	public void emailProcessor(Atendimento atendimento) {
		Email email = new Email();
		
    	email.setTo(atendimento.getAgendamento().getPaciente().getEmail());
    	email.setSubject(emailProp.getProperty("email.subject"));
    	email.setFrom(emailProp.getProperty("email.from"));
    	
    	emailBody = EmailUtil.emailBody;
    	
    	String[] bodyPieces = this.emailBody.split("@");
		StringBuilder bodyPiecesBuilder = new StringBuilder();
		bodyPiecesBuilder
			.append(bodyPieces[0]).append(atendimento.getAgendamento().getPaciente().getNome())
			.append(bodyPieces[1]).append(atendimento.getAgendamento().getPaciente().getSobrenome())
			.append(bodyPieces[2]).append(EmailUtil.formatDate(atendimento.getDataConfirmacao()))
			.append(bodyPieces[3]).append(atendimento.getAtendente().getNome())
			.append(bodyPieces[4]).append(atendimento.getAtendente().getSobrenome())
			.append(bodyPieces[5]).append(atendimento.getAtendente().getCodigoCracha())
			.append(bodyPieces[6]).append(atendimento.getAgendamento().getPaciente().getNome())
			.append(bodyPieces[7]).append(atendimento.getAgendamento().getPaciente().getSobrenome())
			.append(bodyPieces[8]).append(atendimento.getAgendamento().getPaciente().getSexo())
			.append(bodyPieces[9]).append(atendimento.getAgendamento().getPaciente().isPcd() == true ? "Sim" : "Não")
			.append(bodyPieces[10]).append(atendimento.getAgendamento().getPaciente().getEndereco().getRua())
			.append(bodyPieces[11]).append(atendimento.getAgendamento().getPaciente().getEndereco().getNumero())
			.append(bodyPieces[12]).append(atendimento.getAgendamento().getPaciente().getEndereco().getBairro())
			.append(bodyPieces[13]).append(atendimento.getAgendamento().getPaciente().getEndereco().getCidade())
			.append(bodyPieces[14]).append(atendimento.getAgendamento().getPaciente().getEndereco().getEstado())
			.append(bodyPieces[15]).append(atendimento.getAgendamento().getPaciente().getEndereco().getCep())
			.append(bodyPieces[16]);
		
		email.setBody(bodyPiecesBuilder.toString());
		
    	this.sendMail(email);
		
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getSocketFactoryPort() {
		return socketFactoryPort;
	}

	public void setSocketFactoryPort(String socketFactoryPort) {
		this.socketFactoryPort = socketFactoryPort;
	}

	public String getSocketFactoryClass() {
		return socketFactoryClass;
	}

	public void setSocketFactoryClass(String socketFactoryClass) {
		this.socketFactoryClass = socketFactoryClass;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}


}
