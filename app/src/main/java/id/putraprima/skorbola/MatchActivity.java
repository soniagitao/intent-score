package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    public static final String HASIL_KEY = "hasil";
    private TextView homeText;
    private TextView awayText;
    private ImageView homeLogo;
    private ImageView awayLogo;
    int skorHome = 0;
    int skorAway = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        homeText = findViewById(R.id.txt_home);
        awayText = findViewById(R.id.txt_away);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);

        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String home = extras.getString(MainActivity.HOMETEAM_KEY);
            homeText.setText(home);

            String away = extras.getString(MainActivity.AWAYTEAM_KEY);
            awayText.setText(away);

            Bitmap bmp1 = (Bitmap) extras.get("homelogo");
            homeLogo.setImageBitmap(bmp1);

            Bitmap bmp2 = (Bitmap) extras.get("awaylogo");
            awayLogo.setImageBitmap(bmp2);
        }
    }

    public void handlescorehome(View view) {
       skorHome++;
       addscorehome(skorHome);
    }

    public void handleScoreAway(View view) {
        skorAway++;
        addscoreaway(skorAway);
    }

    public void addscoreaway(int skorAway) {
        TextView scoreView = findViewById(R.id.score_away);
        scoreView.setText(String.valueOf(skorAway));
    }

    private void addscorehome(int skorHome) {
        TextView scoreView = findViewById(R.id.score_home);
        scoreView.setText(String.valueOf(skorHome));
    }

    public void handleCek(View view) {
        String hasil = null;
        if (skorHome == skorAway){
            hasil = "Draw";
        }else if (skorHome>skorAway) {
            hasil = homeText.getText().toString();
        }else if (skorAway>skorHome) {
            hasil = awayText.getText().toString();
        }

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(HASIL_KEY, hasil);
        startActivity(intent);
    }

}
