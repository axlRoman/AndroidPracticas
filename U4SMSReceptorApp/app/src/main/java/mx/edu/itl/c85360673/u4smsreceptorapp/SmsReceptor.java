package mx.edu.itl.c85360673.u4smsreceptorapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceptor extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            for (SmsMessage message : messages) {
                String remitente = message.getDisplayOriginatingAddress();
                String contenido = message.getDisplayMessageBody();

                Toast.makeText(context, "Mensaje recibido de: " + remitente + "\nContenido: " + contenido, Toast.LENGTH_LONG).show();
            }
        }
    }
}
