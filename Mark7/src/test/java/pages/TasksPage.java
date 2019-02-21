package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage {
	
	WebDriver driver;

	public TasksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="insert-button")
	WebElement btnNovaTarefa;
	
	@FindBy(xpath="//span[@class='profile-address']")
	WebElement emailLogado;
	
	@FindBy(id="search-input")
	WebElement campoBuscar;
	
	@FindBy(id="search-button")
	WebElement btnBuscar;
	
	@FindBy(id="delete-button")
	WebElement btnDelete;
	
	@FindBy(xpath="//button[contains(text(),'Sim')]")
	WebElement btnConfirmarExclusao;
	
	@FindBy(xpath="//div[contains(text(),'nenhuma tarefa cadastrada :|')]")
	WebElement msgNenhumaTarefaCadastrada;
	
	public String validaUsuarioLogado() {
		String email = emailLogado.getText();
		return email;
	}

	public TasksPage clicarNovaTarefa() {
		btnNovaTarefa.click();
		return this;
	}
	
	public String clicarBuscarTarefa(String tarefa) throws InterruptedException {
		Thread.sleep(2000);
		campoBuscar.sendKeys(tarefa);
		btnBuscar.click();		
		return tarefa;
	}
	
	public TasksPage removerTask() throws InterruptedException {
		btnDelete.click();
		Thread.sleep(2000);
		
		btnConfirmarExclusao.click();
		return this;
	}
	
	public String validaMsgNenhumaTarefaCadastrada() {
		
		String msg = msgNenhumaTarefaCadastrada.getText();
		return msg;
		
	}

}
