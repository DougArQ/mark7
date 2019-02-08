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
		
		String msg =  lp.validarMensagemUsuarioNaoEncontrado();

		lp.preencherEmail("batistinha@gmail.com");
		lp.preencherSenhal("bat2019");
		lp.clicarLogin();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println( lp.validarMensagemUsuarioNaoEncontrado());
		Assert.assertEquals("Usuário não cadastrado.", lp.validarMensagemUsuarioNaoEncontrado());
//		
//		if (msg=="Usuário não cadastrado.") {
//			
//		}

	}

	@After
	public void fecharNavegador() {
		driver.quit();
	}

}
