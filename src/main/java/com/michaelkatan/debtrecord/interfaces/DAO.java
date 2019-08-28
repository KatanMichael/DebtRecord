package com.michaelkatan.debtrecord.interfaces;

import com.michaelkatan.debtrecord.models.Debt;

import java.util.List;

public interface DAO<T>
{
    void addDebt(Debt debt);

    Debt getDebtById(String debtId);

    List<Debt> allDebtOfPerson(String name);

    List<Debt> allDebtToPerson(String name);

    void updateExistingDebt(Debt debt);

}

