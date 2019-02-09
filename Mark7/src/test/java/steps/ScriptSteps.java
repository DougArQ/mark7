package steps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import managers.DriverManager;
import pages.CadastroPage;
import pages.InsertTaskPage;
import pages.LoginPage;
import pages.TasksPage;

//Ordenando por ordem alfab�tica a execu��o
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScriptSteps {

	WebDriver driver;
	DriverManager dm = new DriverManager();
	LoginPage login;
	CadastroPage cadastro;
	TasksPage task;
	InsertTaskPage novaTarefa;

	@Before
	public void conectar() {
		driver = dm.selectBrowser("chrome");
		login = new LoginPage(driver);
		cadastro = new CadastroPage(driver);
		task = new TasksPage(driver);
		novaTarefa = new InsertTaskPage(driver);
		
		driver.get("http://mark7.herokuapp.com/login");

	}

//	@Test
//	public void efetuarCadastro() {
//
//		login.clicarCadastro();
//		cadastro.preencherEmail("batistinha@gmail.com");
//		cadastro.preencherNome("Batistinha");
//		cadastro.preencherSenha("bat2019");
//		cadastro.clicarBotaoCadastrar();
//
//		Assert.assertEquals(task.validaUsuarioLogado(), "batistinha@gmail.com");
//	}

	@Test
	public void efetuarLogin() {

		login.preencherEmail("batistinha@gmail.com");
		login.preencherSenhal("bat2019");
		login.clicarLogin();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(task.validaUsuarioLogado(), "batistinha@gmail.com");

	}
	
	@Test
	public void cadastrarTarefas() {
		
		task.clicarNovaTarefa();
		novaTarefa.
		
	}
//
//	@After
//	public void fecharNavegador() {
//		driver.quit();
//	}

}
