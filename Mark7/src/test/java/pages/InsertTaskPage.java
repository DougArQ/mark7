package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsertTaskPage {

	WebDriver driver;

	public InsertTaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "title")
	WebElement campoNome;

	@FindBy(id = "dueDate")
	WebElement campoData;
	
	@FindBy(xpath = "//div[@class='bootstrap-tagsinput form-control']//input[@type='text']")
	WebElement campoTagsClick;
	
	@FindBy(xpath = "//div[@class='bootstrap-tagsinput form-control focus']//input[@type='text']")
	WebElement campoTags;

	@FindBy(id = "form-submit-button")
	WebElement btnCadastrar;

	@FindBy(linkText = "Voltar")
	WebElement btnVoltar;

	public InsertTaskPage cadastrarNovaTarefa() throws InterruptedException {
		Thread.sleep(2000);
		campoNome.sendKeys("Livro de Animais");
		campoData.sendKeys("20/01/2019");
		
		campoTagsClick.click();
		campoTags.sendKeys("dog");
		campoTags.sendKeys(Keys.TAB);
		
		campoTagsClick.click();
		campoTags.sendKeys("cat");
		campoTags.sendKeys(Keys.TAB);
		
		campoTagsClick.click();
		campoTags.sendKeys("raposa");
		campoTags.sendKeys(Keys.TAB);
		
		btnCadastrar.click();
		return this;

	}
}
