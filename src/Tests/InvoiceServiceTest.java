//package Tests;
//
//import Domain.InvoiceValidator;
//import Repository.InMemoryRepository;
//import Service.InvoiceService;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class InvoiceServiceTest {
//    private InvoiceValidator validator = new InvoiceValidator();
//    private InMemoryRepository repository = new InMemoryRepository(validator);
//    private InvoiceService service = new InvoiceService(repository);
//
//    @Test
//    void testsIfInsertAndGetAllWorksProperly() {
//        service.insert("1", 32, "aaaaa", "11.11.2012");
//        assertEquals(32, service.getAll().get(0).getAmmount());
//
//
//        try {
//            service.insert("1", 32, "aaaaa", "11.11.2012");
//        } catch (RuntimeException rex) { assertTrue(true); }
//    }
//}