package Domain;

public class InvoiceValidator {

    /**
     * validates an invoice
     * @param invoice to validate
     * @throws InvoiceValidatorException if there are validation errors
     */
    public void validate(Invoice invoice){
        String date = invoice.getDate();

        String errors="";

        if(date.length()!=10){
            errors+="The date must have 10 characters\n";
        }

        if(date.charAt(2) != '.' || date.charAt(5) != '.'){
            errors+="Date format should be dd.mm.yyy\n";
        }

        if(!errors.isEmpty()){
            throw new InvoiceValidatorException(errors);
        }
    }
}
