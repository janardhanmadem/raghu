package raghu;

import org.testng.annotations.Test;

import com.experitest.client.Client;

public class sample_trail {
	@Test
	
	public void test(){
	
    // This is a code snippet that should be added to your RFT script
    // TODO: add the following to the class imports: import com.experitest.client.*;
    Client client = new com.experitest.client.Client("localhost", 8889);
    client.setProjectBaseDirectory("C:\\Users\\Myplex QA\\workspace\\project3");
    client.setDevice("adb:C2104");
   // logSeeTestCommand();
    client.launch("com.apalya.myplex/.LoginActivity", true, false);
   // logSeeTestCommand();
    //client.launch("com.apalya.myplex/.LoginActivity", true, false);
    //logSeeTestCommand();
    client.click("NATIVE", "text=login to myplex", 0, 1);
    //logSeeTestCommand();
    client.click("NATIVE", "hint=e-mail address", 0, 1);
   // logSeeTestCommand();
    client.sendText("exampleapalya@gmail.com");
    //logSeeTestCommand();
    if(client.waitForElement("NATIVE", "hint=password:", 0, 10000)){
        // If statement
    }
    //logSeeTestCommand();
    client.elementSendText("NATIVE", "hint=password:", 0, "apalya01");
    //logSeeTestCommand();
    client.sleep(5000);
    //logSeeTestCommand();
    //client.sendText("{\"ESC\"}");
    //logSeeTestCommand();
    client.click("NATIVE", "xpath=//*[@text='login to myplex']", 0, 1);
    //logSeeTestCommand();
    client.click("NATIVE", "xpath=//*[@id='customactionbar_drawer']", 0, 1);
    //logSeeTestCommand();
    client.verifyElementFound("NATIVE", "xpath=//*[@text='examplpalya@gmail.com']", 0);
    //logSeeTestCommand();


}}
