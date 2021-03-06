package ai.api.test;

import android.text.TextUtils;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Locale;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Config(emulateSdk = 18, manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class ProtocolTest {

    private static final String ACCESS_TOKEN = "YOUR_ACCESS_TOKEN_HERE";
    private static final String SUBSCRIPTION_KEY = "INSERT_SUBSCRIPTION_KEY_HERE";


    @Test
    public void testCheck() {
        assertTrue(true);
    }

    @Test
    public void AIDataServiceDebugTest() {
        final AIConfiguration config = new AIConfiguration(ACCESS_TOKEN, SUBSCRIPTION_KEY, Locale.US.toString(), AIConfiguration.RecognitionEngine.Google);
        config.setDebug(true);

        final AIDataService aiDataService = new AIDataService(config);

        final AIRequest aiRequest = new AIRequest();
        aiRequest.setQuery("Hello");

        try {
            final AIResponse aiResponse = aiDataService.request(aiRequest);
            assertNotNull(aiResponse);
            assertFalse(aiResponse.isError());
            assertFalse(TextUtils.isEmpty(aiResponse.getId()));
            assertNotNull(aiResponse.getResult());

            assertFalse(TextUtils.isEmpty(aiResponse.getResult().getAction()));

        } catch (final AIServiceException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
