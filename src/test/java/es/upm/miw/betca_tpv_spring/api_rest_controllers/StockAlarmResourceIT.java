package es.upm.miw.betca_tpv_spring.api_rest_controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.betca_tpv_spring.api_rest_controllers.StockAlarmResource.STOCK_ALARMS;

@ApiTestConfig
class StockAlarmResourceIT {

    @Autowired
    private RestService restService;

    @Autowired
    private WebTestClient webTestClient;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Test
    void testStockAlarmReadAll() {
        this.restService.loginAdmin(webTestClient)
                .get().uri(contextPath + STOCK_ALARMS)
                .exchange()
                .expectStatus().isOk();
    }
}
