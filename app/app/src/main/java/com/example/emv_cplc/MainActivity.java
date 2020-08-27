package com.example.emv_cplc;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;


import com.github.devnied.emvnfccard.model.CPLC;
import com.github.devnied.emvnfccard.model.EmvCard;
import com.github.devnied.emvnfccard.model.EmvTrack1;
import com.github.devnied.emvnfccard.model.enums.CardStateEnum;
import com.github.devnied.emvnfccard.parser.EmvTemplate;
import com.github.devnied.emvnfccard.parser.impl.EmvParser;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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
        textView.setMovementMethod(new ScrollingMovementMethod());
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


            // extracted
            String infoInString = this.getEmvCardInfoAsString(mCard);
            textView.setText(infoInString);

        } catch (IOException e) {
            mException = true;
        }


    }

    private String getEmvCardInfoAsString(EmvCard mCard) {

        String str = "DATA:\n";
        str += "CPLC:\n" + mCard.getCplc();
        str += "\n\n Type:\n" + mCard.getType();
        str += "\n\n state:\n" + mCard.getState();

        str += "\n\n At:\n" + mCard.getAt();
        str += "\n\n AtrDescription:\n" + mCard.getAtrDescription();

        // here down there are personal data (except track where there are some non personal data)

        str += "\n\n Track1:\n" + mCard.getTrack1();
        str += "\n\n Track2:\n" + mCard.getTrack2();

        str += "\n\n IBAN:\n" + mCard.getIban();
        str += "\n\n CardNumber:\n" + mCard.getCardNumber();
        str += "\n\n ExpireDate:\n" + mCard.getExpireDate();
        str += "\n\n firstName:\n" + mCard.getHolderFirstname();
        str += "\n\n lastName:\n" + mCard.getHolderLastname();
        str += "\n\n BIC:\n" + mCard.getBic();


        return str;
    }


}
