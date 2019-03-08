package steps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import managers.DAO;
import managers.DriverManager;
import pages.CadastroPage;
import pages.InsertTaskPage;
import pages.LoginPage;
import pages.PerfilPage;
import pages.TasksPage;
import suporte.Generator;
import suporte.Screenshot;

//Ordenando por ordem alfabética a execução
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScriptSteps {
	
    @Rule
    public TestName test = new TestName();

	WebDriver driver;
	DriverManager dm = new DriverManager();
	LoginPage login;
	CadastroPage cadastro;
	TasksPage task;
	InsertTaskPage novaTarefa;
	PerfilPage novoPerfil;
	DAO dao;

	@Before
	public void conectar() {
		driver = dm.selectBrowser("chrome");
		login = new LoginPage(driver);
		cadastro = new CadastroPage(driver);
		task = new TasksPage(driver);
		novaTarefa = new InsertTaskPage(driver);
		novoPerfil = new PerfilPage(driver);
		dao = new DAO();
		//Removendo usuario via API
		driver.get("http://mark7.herokuapp.com/api/reset/batistinha@gmail.com?clean=full");
		
		driver.get("http://mark7.herokuapp.com/login");
	}

	@Test
	public void realizarCadastroUsuario() throws InterruptedException {
		
		//Removendo usuario via MongoDB
//		dao.conectar();
//		dao.removerUsuario("bruna@gmail.com");
//		dao.desconectar();
		
		login.clicarCadastro();
		cadastro.realizarCadastroUsuario("batistinha@gmail.com", "Batistinha", "bat2019");
		Thread.sleep(2000);
		Assert.assertEquals(task.validaUsuarioLogado(), "batistinha@gmail.com");
		
        //Salvando Screenshot
        String screenshotArquivo = "C:\\Selenium_ScreenShot\\taskit\\" + Generator.dataHoraParaArquivo()+"_"+test.getMethodName()+".png";
        Screenshot.tirar(driver,screenshotArquivo );
	}

//	@Test
//	public void efetuarLogin() throws InterruptedException {
//
//		login.realizarLogin("batistinha@gmail.com", "bat2019");
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
//		novaTarefa.cadastrarNovaTarefa("Livro de Animais", "20/01/2019", "Dog", "Cat", "Fox");
//		task.clicarBuscarTarefa("Livro de Animais");
//		
//	}
	
//	@Test
//	public void removerTask() throws InterruptedException {
//		
//		login.realizarLogin("teste123@gmail.com", "teste123");
//		
//		Thread.sleep(2000);
//		
//		task.clicarNovaTarefa();
//		novaTarefa.cadastrarNovaTarefa("Livro de Animais", "20/01/2019", "Dog", "Cat", "Fox");
//		
//		task.clicarBuscarTarefa("Livro de Animais");
//		task.removerTask();
//		task.clicarBuscarTarefa("Livro de Animais");
//		
//		Assert.assertEquals("nenhuma tarefa cadastrada :|", task.validaMsgNenhumaTarefaCadastrada());
//		
//	}
	
//	@Test
//	public void atualizarPerfil () throws InterruptedException {
//		login.realizarLogin("teste123@gmail.com", "teste123");
//		
//		Thread.sleep(2000);
//		
//		novoPerfil.clicaLinkPerfil();
//		
//		Thread.sleep(2000);
//		
//		novoPerfil.atualizaPerfil("Pedro Cardozo", "pedrao@prefeitura.com", "Prefeitura de Araraquara");
//		System.out.println(novoPerfil.validaMsgPerfilAtualizado());
//		}

//	@After
//	public void fecharNavegador() {
//		driver.quit();
//	}

}
