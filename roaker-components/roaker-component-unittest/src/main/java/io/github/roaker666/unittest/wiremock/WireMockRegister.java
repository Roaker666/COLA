package io.github.roaker666.unittest.wiremock;

import io.github.roaker666.unittest.FixtureLoader;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;

public class WireMockRegister {

    public static void registerStub(WireMock wireMock, String resourcePath){
        StubMapping stubMapping = StubMapping.buildFrom(FixtureLoader.loadResource(resourcePath));
        wireMock.register(stubMapping);
    }
}
