package hlabu.khrihfa.myapplication

import android.app.Application
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class Information_Technology : Application() {

    override fun onCreate() {
        super.onCreate()
      //  FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build();
    }
}