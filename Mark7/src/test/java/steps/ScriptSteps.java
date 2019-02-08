package steps;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import managers.DriverManager;
import pages.CadastroPage;
import pages.LoginPage;

public class ScriptSteps {

	WebDriver driver;
	DriverManager dm = new DriverManager();
	LoginPage lp;
	CadastroPage cp;

	@Before
	public void conectar() {
		driver = dm.selectBrowser("chrome");
		lp = new LoginPage(driver);
		cp = new CadastroPage(driver);
		driver.get("http://mark7.herokuapp.com/login");

	}

//		@Test
//		 public void efetuarCadastro(String nome, String email, String senha) {
//			
//			nome = "Carlos Batista";
//			email = "batistinha@gmail.com";
//			senha = "bat2019";
//			 cp.regNome().sendKeys(nome);
//			 cp.regEmail().sendKeys(email);
//			 cp.regSenha().sendKeys(senha);
//			 cp.btnCadastrar().click();
//			 	  
//			  			  
//			 }

	@Test
	public void efetuarLogin() {
		
		lp.preencherEmail("batistinha@gmail.com");
		lp.preencherSenhal("bat2019");
		lp.clicarLogin();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (lp.validarMensagemUsuarioNaoEncontrado() == "Usuário não cadastrado.") {
			System.out.println("Entrou if");
			
			lp.clicarCadastro();
			cp.preencherEmail("batistinha@gmail.com");
			cp.preencherNome("Batistinha");
			cp.preencherSenha("bat2019");
			cp.clicarBotaoCadastrar();			
		}
		System.out.println("Entrou else");
	}
//
//	@After
//	public void fecharNavegador() {
//		driver.quit();
//	}

}
