package steps;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import managers.DriverManager;
import pages.CadastroPage;
import pages.InsertTaskPage;
import pages.LoginPage;
import pages.TasksPage;

//Ordenando por ordem alfabética a execução
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

//	@Test
//	public void efetuarLogin() throws InterruptedException {
//
//		login.preencherEmail("teste123@gmail.com");
//		login.preencherSenhal("teste123");
//		login.clicarLogin();
//
//		Thread.sleep(2000);
//
////
////		if (login.validarMensagemUsuarioNaoEncontrado().equalsIgnoreCase("Usuário não cadastrado.")) {
////			login.clicarCadastro();
////			cadastro.preencherEmail("teste123@gmail.com");
////			cadastro.preencherNome("Teste");
////			cadastro.preencherSenha("teste123");
////			cadastro.clicarBotaoCadastrar();
////			
////			try {
////				Thread.sleep(2000);
////			} catch (InterruptedException e) {
////				e.printStackTrace();
////			}
////	
////			Assert.assertEquals(task.validaUsuarioLogado(), "teste123@gmail.com");
////		}
//
//		Assert.assertEquals(task.validaUsuarioLogado(), "teste123@gmail.com");
//
//	}

	@Test
	public void cadastrarTarefas() throws InterruptedException {
		login.realizarLogin("teste123@gmail.com", "teste123");
		
		Thread.sleep(2000);
		
//		task.clicarNovaTarefa();
//		novaTarefa.cadastrarNovaTarefa();
		task.clicarBuscarTarefa("livro");
		
	}

//	@After
//	public void fecharNavegador() {
//		driver.quit();
//	}

}
