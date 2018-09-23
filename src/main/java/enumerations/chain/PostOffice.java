package enumerations.chain;

import java.util.Iterator;

class Mail {
  enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}
  enum Scanability {UNSCANNABLE, YES1, YES2, YES3, YES4}
  enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}
  enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}
  enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}
  GeneralDelivery generalDelivery;
  Scanability scanability;
  Readability readability;
  Address address;
  ReturnAddress returnAddress;
  static long counter = 0;
  long id = counter++;
  @Override
  public String toString() {
    return "Mail" + id;
  }
  public String details() {
    return toString() +
            ", General Delivery: " + generalDelivery +
            ", Scanability: " + scanability +
            ", Readability: " + readability +
            ", Address: " + address +
            ", Return Adress: " + returnAddress;
  }
  public static Mail randomMail(){
    Mail m = new Mail();
    m.generalDelivery = Enums.random(GeneralDelivery.class);
    m.scanability = Enums.random(Scanability.class);
    m.readability = Enums.random(Readability.class);
    m.address = Enums.random(Address.class);
    m.returnAddress = Enums.random(ReturnAddress.class);
    return m;
  }
  public static Iterable<Mail> generator(final int count) {
    return new Iterable<Mail>() {
      int n = count;
      @Override
      public Iterator<Mail> iterator() {
        return new Iterator<Mail>() {
          @Override
          public boolean hasNext() {
            return n-- > 0;
          }
          @Override
          public Mail next() {
            return randomMail();
          }
        };
      }
    };
  }
}

public class PostOffice {
  enum MailHandler {
    GENERAL_DELIVERY {
      @Override
      boolean handle(Mail m) {
        switch (m.generalDelivery) {
          case YES:
            System.out.println("Using general delivery for " + m);
            return true;
          default:
            return false;
        }
      }
    }, MACHINE_SCAN {
      @Override
      boolean handle(Mail m) {
        switch (m.scanability) {
          case UNSCANNABLE:
            return false;
          default:
            switch (m.address) {
              case INCORRECT:
                return false;
              default:
                System.out.println("Delivering " + m + " automatically");
                return true;
            }
        }
      }
    }, VISUAL_INSPECTION {
      @Override
      boolean handle(Mail m) {
        switch (m.readability) {
          case ILLEGIBLE:
            return false;
          default:
            System.out.println("Delivering " + m + " normally");
            return true;
        }
      }
    }, RETURN_TO_SENDER {
      @Override
      boolean handle(Mail m) {
        switch (m.returnAddress) {
          case MISSING:
            return false;
          default:
            System.out.println("Returning " + m + " to sender");
            return true;
        }
      }
    };
    abstract boolean handle(Mail mail);
  }
  public static void main(String[] args) {
    for (Mail mail : Mail.generator(10)) {
      System.out.println(mail.details());
      handle(mail);
      System.out.println("********");
    }
  }
  private static void handle(Mail mail) {
    for (MailHandler handler : MailHandler.values())
      if(handler.handle(mail))
        return;
    System.out.println(mail + " is dead");
  }
}
