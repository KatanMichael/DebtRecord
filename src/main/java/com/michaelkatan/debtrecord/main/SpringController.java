package com.michaelkatan.debtrecord.main;


import com.google.gson.Gson;
import com.michaelkatan.debtrecord.models.Debt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringController
{
    @Autowired
    private FirebaseService firebaseService;

    Gson gson = new Gson();
    @RequestMapping(method = RequestMethod.POST,path = "/debt")

    public String addDebt(@RequestParam(name = "personA") String personA,
                          @RequestParam(name = "personB") String personB,
                          @RequestParam(name = "amount") int amount)
    {
        Debt debt = new Debt(personA,personB,amount);
        firebaseService.addDebt(debt);

        return gson.toJson(debt);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/debt/{id}")
    public String getDebt(@PathVariable String id)
    {

        final Debt debtById = firebaseService.getDebtById(id);

        return gson.toJson(debtById);


    }


}
