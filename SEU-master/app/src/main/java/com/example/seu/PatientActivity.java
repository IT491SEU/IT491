package com.example.seu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class PatientActivity extends AppCompatActivity {
    EditText editTextPatientId;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        editTextPatientId = findViewById(R.id.patient_et_id);

        /* for (int i = 1; i <= 3; i++) {
            String id = String.valueOf(i);
            Patient patient
                    = new Patient(id, "Nora", "O", "nuon", "10", "2");
            firestore.collection("patients").document(id)
                    .set(patient);
        }*/
    }

    public void showPatientData(View view) {
        String patientId = editTextPatientId.getText().toString();

        if (patientId.isEmpty()) {
            Toast.makeText(this, "أكتب رقم الملف", Toast.LENGTH_LONG).show();
            return;
        }

        getPatientData(patientId);

    }

    private void getPatientData(final String patientId) {
        firestore.collection("patients")
                .document(patientId)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        Patient patient = task.getResult().toObject(Patient.class);

                        if (patient == null) {
                            Toast.makeText(PatientActivity.this, "رقم الملف غير صحيح ", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Intent intent = new Intent(PatientActivity.this, PatientDetailsActivity.class);
                        intent.putExtra("patientData", patient);
                        startActivity(intent);
                        finish();

                    }
                });
    }

}
