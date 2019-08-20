import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Daftar/Miscellanous/FieldUname'), username, 0)

Mobile.setText(findTestObject('Daftar/Miscellanous/FieldFullName'), fullname, 0)

Mobile.setText(findTestObject('Daftar/Miscellanous/FieldEmail'), email, 0)

Mobile.setText(findTestObject('Daftar/Miscellanous/FieldPassword'), password, 0)

Mobile.setText(findTestObject('Daftar/Miscellanous/FieldVerifPass'), vPassword, 0)

Mobile.setText(findTestObject('Daftar/Miscellanous/FieldPhone'), phone, 0)

switch (vResult.toString()) {
    case 'Failed':
        Mobile.tap(findTestObject('Daftar/Miscellanous/BtnDaftar'), 0)

        if (condition.toString() == 'wrongPass') {
            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnPassword'), 0)
        } else if (condition.toString() == 'emailExist') {
            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnEmailExists'), 0)
        } else if (condition.toString() == 'emptyField') {
            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnUnameEmpty'), 0)

            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnFNameEmpty'), 0)

            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnPassEmpty'), 0)

            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnVPassEmpty'), 0)

            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnPhoneEmpty'), 0)
        }
        
        break
        
        if (isEmpty.toString() == 'username') {
            Mobile.clearText(findTestObject('Daftar/Miscellanous/FieldUname'), 0)

            Mobile.tap(findTestObject('Daftar/Miscellanous/BtnDaftar'), 0)

            Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnUnameEmpty'), 0)
        } else if (isEmpty.toString() == 'fullname') {
            Mobile.clearText(findTestObject('Daftar/Miscellanous/FieldFullName'), 0)

            Mobile.tap(findTestObject('Daftar/Miscellanous/BtnDaftar'), 0)

            Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnEmailEmpty'), 0)
        } else if (isEmpty.toString() == 'email') {
            Mobile.clearText(findTestObject('Daftar/Miscellanous/FieldEmail'), 0)

            Mobile.tap(findTestObject('Daftar/Miscellanous/BtnDaftar'), 0)

            Mobile.delay(0, FailureHandling.STOP_ON_FAILURE)

            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnEmailEmpty'), 0)
        } else if (isEmpty.toString() == 'password') {
            Mobile.clearText(findTestObject('Daftar/Miscellanous/FieldPassword'), 0)

            Mobile.tap(findTestObject('Daftar/Miscellanous/BtnDaftar'), 0)

            Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnPassEmpty'), 0)
        } else if (vPassword.toString() == 'vpassword') {
            Mobile.clearText(findTestObject('Daftar/Miscellanous/FieldVerifPass'), 0)

            Mobile.tap(findTestObject('Daftar/Miscellanous/BtnDaftar'), 0)

            Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnVPassEmpty'), 0)
        } else if (isEmpty.toString() == 'phone') {
            Mobile.clearText(findTestObject('Daftar/Miscellanous/FieldPhone'), 0)

            Mobile.tap(findTestObject('Daftar/Miscellanous/BtnDaftar'), 0)

            Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

            Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/WarnPhoneEmpty'), 0)
        }
    case 'Passed':
        Mobile.tap(findTestObject('Daftar/Miscellanous/BtnDaftar'), 0)

        Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

        Mobile.verifyElementVisible(findTestObject('Daftar/Warnings/SUCCESS'), 0)

        break
}

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

