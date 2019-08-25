package com.michaelkatan.debtrecord.main;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.michaelkatan.debtrecord.interfaces.DAO;
import com.michaelkatan.debtrecord.models.Debt;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class FirebaseService implements DAO
{
    FirebaseApp firebaseApp;

    public FirebaseService()
    {
        initFirebase();
    }

    private void initFirebase()
    {


            FirebaseOptions options = null;
            try {
                InputStream stream = this.getClass().getResourceAsStream("/debtrecord.json");
                options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(stream))
                        .setDatabaseUrl("https://triviaapi-d1d92.firebaseio.com")
                        .build();
            } catch (IOException e) {
                e.printStackTrace();
            }

            firebaseApp = null;
            List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
            if(firebaseApps!=null && !firebaseApps.isEmpty()){
                for(FirebaseApp app : firebaseApps){
                    if(app.getName().equals(FirebaseApp.DEFAULT_APP_NAME))
                        firebaseApp = app;
                }
            }
            else
                firebaseApp = FirebaseApp.initializeApp(options);
        }



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
