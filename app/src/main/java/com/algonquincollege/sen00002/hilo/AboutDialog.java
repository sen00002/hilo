package com.algonquincollege.sen00002.hilo;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * The purpose of this app is to make guesses from numbers 1 to 1000 and you will be given 10 chances if
 * you take less then five chances you are a great player and if you take more than 5 chances then you are
 * a good player and if you lose then you obviously suck!!
 *
 * @author Rajat + Sen (sen00002@algonquinlive.com)
 *         October 07,2017
 */

public class AboutDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder anyObj = new AlertDialog.Builder(getActivity());

        anyObj.setTitle("About Dialog")
                .setMessage(R.string.author)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });


        return anyObj.create();
    }
}
