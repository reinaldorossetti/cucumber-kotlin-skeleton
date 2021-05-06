package qa.example.pages.login

import qa.example.pages.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class GoogleFind(private val driver: WebDriver) {

    @FindBy(name = "q")
    lateinit var pesquisa: WebElement

    @FindBy(name = "btnK")
    lateinit var button: WebElement

    @FindBy(css = "button[type=submit]")
    lateinit var submit: WebElement

    @FindBy(css = ".login-failed-message")
    lateinit var loginError: WebElement

    init {
        PageFactory.initElements(driver, this)
    }

    fun pesquisaGoogle(){
        pesquisa.sendKeys("Reinaldo Rossetti")
        button.click()
    }

}