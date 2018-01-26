package features;

import keyword.Features;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestFeatures extends Features{
    
        @Test
        public void testFeatures() throws IOException, InterruptedException {
            selectAction("Login");
            //selectFeatures();
        }

}

