package id.sch.smktelkom_mlg.tugas1.xiirpl4022.formpendaftaranshinobi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etUmur;
    TextView tvView, tvView2, tvView3, tvView4;
    Button bSubmit, bSubmit2;
    RadioButton rbN, rbK;
    Spinner sD;
    CheckBox nin, tai, gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbN = (RadioButton) findViewById(R.id.radioButtonN);
        rbK = (RadioButton) findViewById(R.id.radioButtonK);
        nin = (CheckBox) findViewById(R.id.ninjutsu);
        tai = (CheckBox) findViewById(R.id.taijutsu);
        gen = (CheckBox) findViewById(R.id.genjutsu);
        bSubmit = (Button) findViewById(R.id.buttonSubmit);
        bSubmit2 = (Button) findViewById(R.id.buttonSubmit2);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etUmur = (EditText) findViewById(R.id.editTextUmur);
        tvView = (TextView) findViewById(R.id.textViewView);
        tvView2 = (TextView) findViewById(R.id.textViewView2);
        tvView3 = (TextView) findViewById(R.id.textViewView3);
        tvView4 = (TextView) findViewById(R.id.textViewView4);
        sD = (Spinner) findViewById(R.id.spinnerDesa);


        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doProcess();
                doClick();

            }
        });
        bSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick2();
                doClick3();

            }
        });

    }

    private void doClick3() {
        tvView4.setText("Asal Desa:" + sD.getSelectedItem().toString());
    }

    private void doClick2() {
        String view3 = "Jutsu Kamu :\n ";
        int startlen = view3.length();
        if (nin.isChecked()) view3 += nin.getText() + "\n";
        if (tai.isChecked()) view3 += tai.getText() + "\n";
        if (gen.isChecked()) view3 += gen.getText() + "\n";
        if (view3.length() == startlen) view3 += "Kamu Tidak Memilih Jutsu";
        tvView3.setText(view3);
    }

    private void doClick() {
        String view2 = null;
        if (rbN.isChecked()) {
            view2 = rbN.getText().toString();
        } else if (rbK.isChecked()) {
            view2 = rbK.getText().toString();
        }
        if (view2 == null) {
            tvView2.setText("Konten Belum Teriidentifikasi");
        } else {
            tvView2.setText("Kriteria Anda : " + view2);
        }
    }


    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            int umur = Integer.parseInt(etUmur.getText().toString());
            tvView.setText(nama + ", " + umur + "tahun");
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String umur = etUmur.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (umur.isEmpty()) {
            etUmur.setError("Umur Belum diisi");
        } else if (umur.length() != 2) {
            etUmur.setError("Umur Kamu Harus Lebih dari 1 digit");
        } else {
            etUmur.setError(null);
        }
        return valid;
    }
}





