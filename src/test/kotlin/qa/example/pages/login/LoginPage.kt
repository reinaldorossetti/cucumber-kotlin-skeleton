package qa.example.pages.login

import qa.example.pages.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

abstract class GoogleFind(driver: WebDriver) : AbstractPage(driver) {

    @FindBy(id = "email")
    lateinit var email: WebElement

    @FindBy(id = "password")
    lateinit var password: WebElement

    @FindBy(css = "button[type=submit]")
    lateinit var submit: WebElement

    @FindBy(css = ".login-failed-message")
    lateinit var loginError: WebElement

    init {
        PageFactory.initElements(driver, this)
    }

    override fun pageUrl() = "${baseUrl()}/login"

}