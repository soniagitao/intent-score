package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView homeText;
    private TextView awayText;
    private TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        hasil = findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String hsl = getIntent().getExtras().getString("hasil");
            hasil.setText(hsl);
        }
    }
}
