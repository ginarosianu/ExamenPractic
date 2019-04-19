package Service;

import Domain.Invoice;
import Repository.InMemoryRepository;

import java.util.List;

public class InvoiceService {

    private InMemoryRepository invoiceRepository;

    public InvoiceService(InMemoryRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    /**
     * inserts an invoice
     * @param id the id of the invoice
     * @param ammount the ammount of invoice
     * @param description the description of the invoice
     * @param date the date of the invoice
     */
    public void insert(String id, int ammount, String description, String date) {
        Invoice invoice = new Invoice(id, ammount, description, date);
        invoiceRepository.insert(invoice);
    }

    /**
     * @return an List with all invoices
     */
    public List<Invoice> getAll() {
        return invoiceRepository.getAll();
    }


}
