package pl.uzi.spirngsecuritytutorial.controllers;

import org.springframework.web.bind.annotation.*;
import pl.uzi.spirngsecuritytutorial.dao.Quotation;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuotationAPI {

    private List<Quotation> quotations;

    public QuotationAPI(){
        this.quotations = new ArrayList<>();
        quotations.add(new Quotation("Tak sadze","PU"));
        quotations.add(new Quotation("Andrzej tez sadzi","William William"));
    }

    //Access to all users
    @GetMapping("/quotations/all")
    public List<Quotation> getAll(){
        return quotations;
    }

    //Access to moderators
    @PostMapping("/quotations")
    public boolean addQuotation(@RequestBody Quotation quotation){
        return quotations.add(quotation);
    }

    //Access to admin
    @DeleteMapping("/quotations")
    public void deleteQuotation(@RequestParam int index){
        quotations.remove(index);
    }
}
