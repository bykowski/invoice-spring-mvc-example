package pl.bykowski.invoicespringmvcexample;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoices();
    void saveInvoice(Invoice invoice);
    void deleteInvoice(Long id);
    void updateInvoice(Invoice newInvoice);

}
