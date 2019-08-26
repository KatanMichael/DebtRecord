package com.michaelkatan.debtrecord.main;


import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.michaelkatan.debtrecord.interfaces.DAO;
import com.michaelkatan.debtrecord.models.Debt;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class FirebaseService implements DAO
{
    private FirebaseApp firebaseApp;
    private final Firestore firestore;

    public FirebaseService()
    {
        initFirebase();

        firestore = FirestoreClient.getFirestore();
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
        final ApiFuture<DocumentReference> debts =
                firestore.collection("debts").add(debt);

    }

    @Override
    public Debt getDebtById(String debtId)
    {
        final ApiFuture<QuerySnapshot> query = firestore.collection("debts").whereEqualTo("debtId", debtId)
                .get();

        List<Debt> documents = null;
        try {
          documents  = query.get().toObjects(Debt.class);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(documents.size() == 0)
        {
            return null;
        }else
        {
            return documents.get(0);
        }

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
