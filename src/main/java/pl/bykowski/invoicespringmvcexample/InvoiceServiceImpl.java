package pl.bykowski.invoicespringmvcexample;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    private final List<Invoice> invoiceList;

    public InvoiceServiceImpl() {
        this.invoiceList = new ArrayList<>();
        Invoice invoice = new Invoice();
        invoice.setId(1L);
        invoice.setDate(LocalDate.of(2022, 10,10));
        invoice.setPrice(BigDecimal.valueOf(200));
        invoice.setName("LiveBook: Spring Boot 2");
        invoiceList.add(invoice);
        Invoice invoice2 = new Invoice();
        invoice2.setId(2L);
        invoice2.setDate(LocalDate.of(2025, 10,10));
        invoice2.setPrice(BigDecimal.valueOf(500));
        invoice2.setName("LiveBook: Spring Boot 3");
        invoiceList.add(invoice2);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceList;
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceList.add(invoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceList.removeIf(element -> element.getId().equals(id));
    }

    @Override
    public void updateInvoice(Invoice newInvoice) {
        Invoice oldInvoice = invoiceList.stream().filter(element -> element.getId().equals(newInvoice.getId())).findFirst().get();
        int index = invoiceList.indexOf(oldInvoice);
        invoiceList.set(index, newInvoice);
    }
}
