package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.CommonFunctions;

public class Hooks {
    CommonFunctions commonFunctions=new CommonFunctions();
@Before
    public void beforeTest()
    {
        commonFunctions.openBrowser();
    }
    @After
    public void afetrTest()
    {
       commonFunctions.closeBrowser();
    }

}
