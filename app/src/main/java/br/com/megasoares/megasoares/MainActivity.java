package br.com.megasoares.megasoares;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PointF;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;

import br.com.megasoares.megasoares.conexao.ConexaoInfo;

public class MainActivity extends Activity {

    private final int PERMISSION_ABRIR_CAMERA = 9999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIrParaLoja = (Button) findViewById(R.id.btnIrParaLoja);

        btnIrParaLoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ConexaoInfo.of(MainActivity.this).isConectado()) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.megasoaresbycode.com.br/"));
                    startActivity(browserIntent);
                } else {
                    exibeMensagemSemConexao();
                }
            }
        });

        Button btnLerQRCode = (Button) findViewById(R.id.btnLerQRCode);
        btnLerQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ConexaoInfo.of(MainActivity.this).isConectado()) {
                    int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.CAMERA);
                    if (permissionCheck != PackageManager.PERMISSION_DENIED) {
                        Intent qrcodeIntent = new Intent(MainActivity.this, QRCodeDecodeActivity.class);
                        MainActivity.this.startActivity(qrcodeIntent);
                    } else {
                        if (ContextCompat.checkSelfPermission(MainActivity.this,
                                Manifest.permission.CAMERA)
                                != PackageManager.PERMISSION_GRANTED) {

                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{Manifest.permission.CAMERA},
                                    PERMISSION_ABRIR_CAMERA);
                        }
                    }
                } else {
                    exibeMensagemSemConexao();
                }
            }
        });

        Button btnPromocoes = (Button) findViewById(R.id.btnPromocoes);
        btnPromocoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent promocaoIntent = new Intent(MainActivity.this, PromocaoActivity.class);
                MainActivity.this.startActivity(promocaoIntent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case PERMISSION_ABRIR_CAMERA: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Intent qrcodeIntent = new Intent(MainActivity.this, QRCodeDecodeActivity.class);
                    MainActivity.this.startActivity(qrcodeIntent);
                }
                return;
            }
        }
    }

    private void exibeMensagemSemConexao() {
        Toast.makeText(MainActivity.this, "É necessário conexão com a internet.", Toast.LENGTH_SHORT).show();
    }

}
