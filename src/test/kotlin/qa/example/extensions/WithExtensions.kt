package qa.example.extensions

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import io.qameta.allure.Step
import org.openqa.selenium.WebDriver
import kotlin.test.fail


open class BasePage(open val driver: WebDriver?) {

    fun WebElement.isNotDisplayed(): Boolean {
        return try {
            !this.isDisplayed
        } catch (e: NoSuchElementException) {
            true
        }
    }

    fun WebElement.waitForPresent(timeoutSeconds: Long = 60) {
            this.isDisplayed || fail("still waiting for element to be displayed: $this")
    }

    @Step("Wait for document ready within {1} seconds...")
    fun waitForDocumentReady(timeoutSeconds: Long = 60) {
        WebDriverWait(driver, timeoutSeconds).until { wd ->
            "complete" == (wd as JavascriptExecutor).executeScript("return document.readyState")
        }
    }

    @Step("Wait for ajax to finish within {1} seconds...")
    fun waitForAjaxToFinish(timeoutSeconds: Long = 60) {
            val js = driver as JavascriptExecutor
            assert(
                    js.executeScript("return !!jQuery && jQuery.active == 0") as Boolean
            ) { "ajax is still in progress" }
    }


}