package hlabu.khrihfa.myapplication.Activity

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import hlabu.khrihfa.myapplication.Adapter.SubjectAdapter
import hlabu.khrihfa.myapplication.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.*
import com.google.firebase.firestore.EventListener
import hlabu.khrihfa.myapplication.model.Subject
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.view.*
import java.lang.Exception
import java.security.AccessController.getContext
import java.util.*
import kotlin.collections.ArrayList



class SecondActivity : AppCompatActivity() {
    var key: String = ""
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: SubjectAdapter

    private lateinit var db: FirebaseFirestore
    private lateinit var subList: ArrayList<Subject>

    private final var TAG = "TAG"

    // val settings: FirebaseFirestoreSettings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setSupportActionBar(second_toolbar)
        supportActionBar!!.setTitle("Majors")
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        second_toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"))

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager


        key = intent.getStringExtra("key")

        subList = ArrayList<Subject>()

        progressBar.visibility = View.VISIBLE

        db = FirebaseFirestore.getInstance()
       /* val settings = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(true)
            .build()
        db.firestoreSettings = settings */

        db.collection(key.toString()).orderBy("id")
            .addSnapshotListener(EventListener { documentSnapshots, firebaseFirestoreException ->
                if(firebaseFirestoreException != null){
                    Log.w(TAG, "Error" + firebaseFirestoreException.message)

                }
                for (doc in documentSnapshots!!.getDocumentChanges())
                {
                    if(doc.type == DocumentChange.Type.ADDED){
                        var subject:Subject = doc.document.toObject(Subject::class.java)
                        subList.add(subject)
                        adapter.notifyDataSetChanged()

                        progressBar.setVisibility(View.GONE);
                    }
                }

            })

        adapter = SubjectAdapter(subList)
        recyclerView.adapter = adapter





        /* db.collection("first_yr")
             .get()
             .addOnCompleteListener { task ->
                 if (task.isSuccessful) {
                     //   progressBar.visibility.


                     // var list: List<DocumentSnapshot>  = List<DocumentSnapshot>().Quer
                     for (document in task.result!!) {
                         val sub_name = document.data["sub_name"].toString()
                         val sub_code = document.data["sub_code"].toString()
                         val id = document.data["id"].toString()
                         val description = document.data["description"].toString()

                         var subject = Subject(sub_name, id, sub_code, description)

                         subList.add(subject)
                         adapter.notifyDataSetChanged()


                     }


                     progressBar.setVisibility(View.GONE);
                 } else {
                     Log.w("error", task.exception)
                 }
             }*/



    }

    override fun onStart() {
        super.onStart()
        adapter = SubjectAdapter(subList)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()


    }

    override fun onResume() {
        super.onResume()
        adapter = SubjectAdapter(subList)

        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()


    }


   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        try {
            if(resultCode == RESULT_OK) {
                subList.clear()
                adapter = SubjectAdapter(subList)

                db = FirebaseFirestore.getInstance()
/*
                val settings = FirebaseFirestoreSettings.Builder()
                    .setPersistenceEnabled(true)
                    .build()
                db.firestoreSettings = settings*/


                db.collection(key.toString()).orderBy("id")
                    .addSnapshotListener(EventListener { documentSnapshots, firebaseFirestoreException ->
                        if(firebaseFirestoreException != null){
                           Log.w(TAG, "Error" + firebaseFirestoreException.message)

                        }
                        for (doc in documentSnapshots!!.getDocumentChanges())
                        {
                            if(doc.type == DocumentChange.Type.ADDED){
                              var subject:Subject = doc.document.toObject(Subject::class.java)
                                subList.add(subject)
                                adapter.notifyDataSetChanged()

                            }
                        }

                    })


            }
        }catch (ex:Exception){
            Toast.makeText(
                applicationContext, ex.toString(),
                Toast.LENGTH_SHORT).show()
        }
    }
}
