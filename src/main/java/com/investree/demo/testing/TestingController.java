package com.investree.demo.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestingController {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void saveTransaksi() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting = "{\n" +
                "  \"bunga_persen\":\"72\",\n" +
                "  \"status\":\"true\",\n" +
                "  \"tenor\":\"24\",\n" +
                "  \"total_pinjaman\":\"56000000\"\n" +
                "  \n" +
                "}";
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
        ResponseEntity<String> exchange = testRestTemplate.exchange("http://localhost:8000/api/v1/Transaksi/save", HttpMethod.POST, entity, String.class);
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response= "+ exchange.getBody());
    }

    @Test
    public void listTransaksi() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> exchange = testRestTemplate.exchange("http://localhost:8000/api/v1/Transaksi/listPage", HttpMethod.GET,entity, String.class);

        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response = "+ exchange.getBody());

    }

    @Test
    public void updateTransaksi() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting = "{\n" +
                "  \"bunga_persen\":\"72\",\n" +
                "  \"status\":\"False\",\n" +
                "  \"tenor\":\"24\",\n" +
                "  \"total_pinjaman\":\"56000000\"\n" +
                "  \n" +
                "}";
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
        ResponseEntity<String> exchange = testRestTemplate.exchange("http://localhost:8000/api/v1/Transaksi/save/cb70811d-065f-4930-ad90-3d818e20b553", HttpMethod.PUT,entity, String.class);
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response = "+ exchange.getBody());
    }

}
