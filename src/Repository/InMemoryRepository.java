package Repository;

import Domain.Invoice;
import Domain.InvoiceValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository {

    private Map<String, Invoice> storage = new HashMap<>();
    private InvoiceValidator validator;

    public InMemoryRepository(InvoiceValidator validator) {
        this.validator = validator;
    }

    /**
     * inserts an invoice
     * @param invoice
     * @throws RepositoryException if an invoice with that id already exists
     */
    public void insert(Invoice invoice) {
        if (storage.containsKey(invoice.getId())) {
            throw new RepositoryException("An invoice with " + invoice.getId() + " already exists");
        }
        validator.validate(invoice);
        storage.put(invoice.getId(), invoice);
    }

    /**
     * @return a list with all invoices
     */
    public List<Invoice> getAll() {
        return new ArrayList<>(storage.values());
    }

}
