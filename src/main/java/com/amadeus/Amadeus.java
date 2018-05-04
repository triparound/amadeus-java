package com.amadeus;

import java.util.Map;
import lombok.NonNull;

/**
 * <p>The Amadeus API client. To initialize, use the builder as follows:</p>
 *
 * <pre>
 *   Amadeus amadeus = Amadeus.builder("CLIENT_ID", "CLIENT_SECRET").build();
 * </pre>
 *
 * <p>Or pass in environment variables directly:</p>
 *
 * <pre>
 *   Amadeus.builder(System.getenv()).build();
 * </pre>
 */
public class Amadeus extends HTTPClient {
  /**
   * The API version.
   */
  public static final String VERSION = "1.0.0";

  public ReferenceData referenceData;

  protected Amadeus(Configuration configuration) {
    super(configuration);
    this.referenceData = new ReferenceData(this);
  }

  /**
   * Creates a builder object that can be used to build
   * an Amadeus com.amadeus.client.
   *
   * <pre>
   * Amadeus amadeus = Amadeus.builder("CLIENT_ID", "CLIENT_SECRET").build();
   * </pre>
   *
   * @param clientId Your API com.amadeus.client credential ID
   * @param clientSecret Your API com.amadeus.client credential secret
   * @return a Configuration object
   */
  public static Configuration builder(@NonNull String clientId, @NonNull String clientSecret) {
    return new Configuration(clientId, clientSecret);
  }

  /**
   * Creates a builder object initialized with the environment variables that can be used to
   * build an Amadeus API com.amadeus.client.
   *
   * <pre>
   * Amadeus amadeus = Amadeus.builder(System.getenv()).build();
   * </pre>
   *
   * @param environment The system environment
   * @return a Configuration object
   */
  public static Configuration builder(Map<String, String> environment) {
    String clientId = environment.get("AMADEUS_CLIENT_ID");
    String clientSecret = environment.get("AMADEUS_CLIENT_ID");

    Configuration configuration = Amadeus.builder(clientId, clientSecret);
    configuration.parseEnvironment(environment);

    return configuration;
  }
}
