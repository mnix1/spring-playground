package com.displate.javaenabling.springworkshop.restclient.base;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.github.tomakehurst.wiremock.stubbing.Scenario;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.serviceUnavailable;

public class WiremockHelper extends WireMockExtension {

    WiremockHelper(Builder builder) {
        super(builder);
    }

    public static WiremockHelper buildWiremock() {
        return new WiremockHelper(WireMockExtension.newInstance()
                .options(WireMockConfiguration.wireMockConfig()
                        .port(8090)
                        .notifier(new ConsoleNotifier(true))));
    }

    public void failThreeTimesThenReturn(ResponseDefinitionBuilder responseDefBuilder) {
        this.stubFor(get("/users").inScenario("retry")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(serviceUnavailable())
                .willSetStateTo("second-attempt")
        );
        this.stubFor(get("/users").inScenario("retry")
                .whenScenarioStateIs("second-attempt")
                .willReturn(serviceUnavailable())
                .willSetStateTo("third-attempt"));

        this.stubFor(get("/users").inScenario("retry")
                .whenScenarioStateIs("third-attempt")
                .willReturn(serviceUnavailable())
                .willSetStateTo("fourth-attempt"));

        this.stubFor(get("/users").inScenario("retry")
                .whenScenarioStateIs("fourth-attempt")
                .willReturn(responseDefBuilder));
    }

}
