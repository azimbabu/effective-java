package chapter2.item2.spi;

public class ServiceProviderTest {

  private static final Provider DEFAULT_PROVIDER =
      () ->
          new Service() {
            @Override
            public String toString() {
              return "Default service";
            }
          };
  private static final Provider COMP_PROVIDER =
      () ->
          new Service() {
            @Override
            public String toString() {
              return "Complementary service";
            }
          };
  private static final Provider ARMED_PROVIDER =
      () ->
          new Service() {
            @Override
            public String toString() {
              return "Armed service";
            }
          };

  public static void main(String[] args) {
    // Providers would execute these lines
    Services.registerDefaultProvider(DEFAULT_PROVIDER);
    Services.registerProvider("comp", COMP_PROVIDER);
    Services.registerProvider("armed", ARMED_PROVIDER);

    // Clients would execute these lines
    Service service1 = Services.newInstance();
    Service service2 = Services.newInstance("comp");
    Service service3 = Services.newInstance("armed");
    System.out.printf("%s, %s, %s%n", service1, service2, service3);
  }
}
