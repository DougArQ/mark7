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
//	public void realizarCadastroUsuario() {
//
//		login.clicarCadastro();
//		cadastro.realizarCadastroUsuario("batistinha@gmail.com", "Batistinha", "bat2019");
//		Assert.assertEquals(task.validaUsuarioLogado(), "batistinha@gmail.com");
//	}
//
//	@Test
//	public void efetuarLogin() throws InterruptedException {
//
//		login.realizarLogin("teste123@gmail.com", "teste123");
//		
//		Thread.sleep(2000);
//
//		if (login.validarMensagemUsuarioNaoEncontrado().equalsIgnoreCase("Usuário não cadastrado.")) {
//			login.clicarCadastro();
//			
//			cadastro.realizarCadastroUsuario("batistinha@gmail.com", "Batistinha", "bat2019");
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			Assert.assertEquals(task.validaUsuarioLogado(), "batistinha@gmail.com");
//		}
//
//		Assert.assertEquals(task.validaUsuarioLogado(), "batistinha@gmail.com");
//
//	}
//
//	@Test
//	public void cadastrarTarefas() throws InterruptedException {
//		login.realizarLogin("teste123@gmail.com", "teste123");
//		
//		Thread.sleep(2000);
//		
//		task.clicarNovaTarefa();
//		novaTarefa.cadastrarNovaTarefa();
//		task.clicarBuscarTarefa("livro");
//		
//	}
	
	@Test
	public void removerTask() throws InterruptedException {
		
		login.realizarLogin("teste123@gmail.com", "teste123");
		
		Thread.sleep(2000);
		
		task.clicarNovaTarefa();
		novaTarefa.cadastrarNovaTarefa();
		
		task.clicarBuscarTarefa("Livro de Animais");
		task.removerTask();
		task.clicarBuscarTarefa("Livro de Animais");
		
		Assert.assertEquals("nenhuma tarefa cadastrada :|", task.validaMsgNenhumaTarefaCadastrada());
		
	}

//	@After
//	public void fecharNavegador() {
//		driver.quit();
//	}

}
