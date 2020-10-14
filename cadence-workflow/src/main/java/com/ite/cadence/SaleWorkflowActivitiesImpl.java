package com.ite.cadence;

import java.net.URI;
import java.time.Duration;
import java.util.UUID;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class SaleWorkflowActivitiesImpl implements SaleWorkflowActivities {

  private final RestTemplate restTemplate;

  public SaleWorkflowActivitiesImpl() {
    this.restTemplate = new RestTemplateBuilder().setReadTimeout(Duration.ofSeconds(30)).build();
  }

  @Override
  public String verifyInventory(final UUID saleId) {
    final URI uri =
        UriComponentsBuilder.fromHttpUrl("http://servico-estoque").port(8084).build().toUri();

    HttpEntity httpEntity = new HttpEntity(this.createHeaders(saleId));
    return this.restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class).getBody();
  }

  @Override
  public String validatePayment(final UUID saleId) {
    final URI uri =
        UriComponentsBuilder.fromHttpUrl("http://servico-pagamentos").port(8081).build().toUri();

    HttpEntity httpEntity = new HttpEntity(this.createHeaders(saleId));
    return this.restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class).getBody();
  }

  @Override
  public String startShipmentProcess(final UUID saleId) {
    final URI uri =
        UriComponentsBuilder.fromHttpUrl("http://servico-logistica").port(8083).build().toUri();

    HttpEntity httpEntity = new HttpEntity(this.createHeaders(saleId));
    return this.restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class).getBody();
  }

  @Override
  public String notifyCustomer(final UUID saleId, final String message) {
    final URI uri =
        UriComponentsBuilder.fromHttpUrl("http://servico-notificacoes").port(8082).build().toUri();
    final HttpHeaders headers = this.createHeaders(saleId);
    headers.set("message", message);
    HttpEntity httpEntity = new HttpEntity(headers);
    return this.restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class).getBody();
  }

  private HttpHeaders createHeaders(final UUID saleId) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("saleId", saleId.toString());
    return headers;
  }
}
