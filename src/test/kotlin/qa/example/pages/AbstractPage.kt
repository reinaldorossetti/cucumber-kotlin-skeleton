package qa.example.pages

import LocalTestBase
import qa.example.extensions.WithPageUrl
import org.openqa.selenium.WebDriver
import io.qameta.allure.Step

abstract class AbstractPage(driver: WebDriver) {

    @Step
    private fun stepExemplo(url: String) {
        println("Step Exemplo...")
    }

}