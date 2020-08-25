package com.example.emv_cplc;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import com.github.devnied.emvnfccard.model.EmvCard;
import com.github.devnied.emvnfccard.parser.EmvTemplate;
import com.github.devnied.emvnfccard.parser.impl.EmvParser;

import java.io.IOException;
import java.util.Objects;

public class MainActivity extends FragmentActivity {

    private NfcAdapter nfcAdapter = null;
    private TextView textView = null;

    private Provider mProvider = new Provider();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView = findViewById(R.id.text_viewer);
        // this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (Objects.equals(getIntent().getAction(), NfcAdapter.ACTION_TECH_DISCOVERED)) {
            onNewIntent(getIntent());
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        //nfcAdapter.enableReaderMode(this, this, NfcAdapter.FLAG_READER_NFC_A, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //nfcAdapter.disableReaderMode(this);
    }


    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        final Tag mTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        if (mTag == null) {
            //Error
            return;
        }

        IsoDep mTagcomm = IsoDep.get(mTag);
        if (mTagcomm == null) {
            Toast.makeText(getApplicationContext(), "Failed loading IsoDep", Toast.LENGTH_LONG).show();
            return;
        }

        boolean mException = false;

        try {
            EmvCard mReadCard = null;
            // Open connection
            mTagcomm.connect();

            mProvider.setmTagCom(mTagcomm);

            EmvTemplate.Config config = EmvTemplate.Config()
                    .setContactLess(true) // Enable contact less reading (default: true)
                    .setReadAllAids(true) // Read all aids in card (default: true)
                    .setReadTransactions(true) // Read all transactions (default: true)
                    .setReadCplc(true) // Read and extract CPCLC data (default: false)
                    .setRemoveDefaultParsers(false) // Remove default parsers for GeldKarte and EmvCard (default: false)
                    .setReadAt(true) // Read and extract ATR/ATS and description
                    ;
            // Create Parser
            EmvTemplate parser = EmvTemplate.Builder() //
                    .setProvider(mProvider) // Define provider
                    .setConfig(config) // Define config
                    //.setTerminal(terminal) (optional) you can define a custom terminal implementation to create APDU
                    .build();

            EmvCard mCard = parser.readEmvCard();
            if (mCard == null) {
                return;
            }

            String str = "CPLC:\n" + mCard.getCplc().toString()
                    + "\n\n CardNo:\n" + mCard.getCardNumber()
                    + "\n\n IBAN: \n" + mCard.getIban()
                    + "\n\n ExpireDate: \n" + mCard.getExpireDate();

            // extracted
            textView.setText(str);
            //TODO whatever


        } catch (IOException e) {
            mException = true;
        }


    }
}
