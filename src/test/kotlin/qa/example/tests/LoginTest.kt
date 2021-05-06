package qa.example.tests

import io.qameta.allure.Allure.step
import io.qameta.allure.Step
import io.qameta.allure.model.Status
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeAll
import qa.example.pages.login.GoogleFind
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.net.URI
import java.util.concurrent.TimeUnit

class AllureSimpleTest() {

    lateinit var driver: WebDriver
        private set

//    companion object {
//        @BeforeAll
//        @JvmStatic
//        internal fun beforeAll() {
//            println("beforeAll called")
//        }
//        internal fun setup() {
////        System.setProperty(UtilResources.getProperties("nameDriver"),
////            UtilResources.getProperties("pathDriver") + UtilResources.getProperties("exeDriver"))
//            driver = ChromeDriver()
//            driver!!.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
//            driver!!.manage()?.window()?.maximize()
//            driver!!.get("https://www.google.com/")
//        }
//    }

    @Test
    @DisplayName("allureSimpleTest displayName")
    fun allureSimpleTest() {
        step("Simple step")
        driver = ChromeDriver()
        driver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage()?.window()?.maximize()
        driver.get("https://www.google.com/")
        val google = GoogleFind(driver)
        google.pesquisaGoogle()
        step("Simple step with status", Status.FAILED)
        simpleTestMethod("method parameter")
    }

    @Step("Simple test method with step annotation")
    fun simpleTestMethod(param: String) {
        step("Method parameter: $param")
        step("Simple step inside test method")
    }

}