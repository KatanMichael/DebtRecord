package com.michaelkatan.debtrecord.main;


import com.michaelkatan.debtrecord.interfaces.DAO;
import com.michaelkatan.debtrecord.models.Debt;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class FirebaseService implements DAO
{

    @Override
    public void addDebt(Debt debt)
    {


    }

    @Override
    public Debt getDebtById(String debtId) {
        return null;
    }

    @Override
    public List<Debt> allDebtOfPerson(String name) {
        return null;
    }

    @Override
    public List<Debt> allDebtToPrson(String name) {
        return null;
    }

    @Override
    public void updateExistingDebt(Debt debt) {

    }
}
