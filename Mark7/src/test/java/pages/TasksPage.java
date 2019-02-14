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
	
	public String validaUsuarioLogado() {
		String email = emailLogado.getText();
		return email;
	}

	public TasksPage clicarNovaTarefa() {
		btnNovaTarefa.click();
		return this;
	}
	
	public String clicarBuscarTarefa(String tarefa) {
		campoBuscar.sendKeys(tarefa);
		btnBuscar.click();		
		return tarefa;
	}

}
