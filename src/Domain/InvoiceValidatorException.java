package Domain;

public class InvoiceValidatorException extends RuntimeException {
    InvoiceValidatorException(String message) {

        super("Invoice Validator Exception ||| " + message);
    }
}
