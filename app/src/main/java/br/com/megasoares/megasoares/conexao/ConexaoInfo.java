package br.com.megasoares.megasoares.conexao;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by guikessa on 23/07/17.
 */

public class ConexaoInfo {

    private Context context;

    private ConexaoInfo(Context context) {
        this.context = context;
    }

    public static ConexaoInfo of(Context context) {
        return new ConexaoInfo(context);
    }

    public NetworkInfo getNetworkInfo() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo;
    }

    public Boolean isConectado() {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();

    }

}
