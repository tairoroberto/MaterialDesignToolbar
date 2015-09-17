package br.com.trmasolucoes.materialdesigntoolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Toolbar toolbarBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        toolbar = (Toolbar) findViewById(R.id.toobarMain);
        toolbarBottom = (Toolbar) findViewById(R.id.ic_tb_bottom);

        toolbar.setTitle("Second Activity");
        setSupportActionBar(toolbar);//seta a toobar como actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Listener de click no menu
        toolbarBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = null;

                switch (menuItem.getItemId()) {
                    case R.id.action_facebook:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://facebook.com.br"));
                        break;
                    case R.id.action_youtube:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://youtube.com.br"));
                        break;
                    case R.id.action_google_plus:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://googleplus.com.br"));
                        break;
                    case R.id.action_linkedin:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://linkedin.com.br"));
                        break;
                    case R.id.action_whatsapp:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://whatsapp.com.br"));
                        break;
                }

                startActivity(intent);
                return true;
            }
        });

        //infla o menu
        toolbarBottom.inflateMenu(R.menu.menu_bottom);

        //implementa o click na imagem da toolbar
        toolbarBottom.findViewById(R.id.iv_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "Settings clicado", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            toolbar.setBackgroundResource(R.drawable.toolbar_rounded_corners);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
        }

        return true;
    }
}
