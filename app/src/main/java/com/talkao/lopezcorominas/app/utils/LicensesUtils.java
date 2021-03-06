package com.talkao.lopezcorominas.app.utils;

import android.content.Context;

import com.talkao.lopezcorominas.app.R;

import de.psdev.licensesdialog.LicensesDialog;

/**
 * @author Jesús López Corominas
 */
public abstract class LicensesUtils {

    private LicensesUtils() {

    }

    public static void showLicenses(Context context) {
        new LicensesDialog.Builder(context)
                .setNotices(R.raw.notices)
                .setIncludeOwnLicense(false)
                .setCloseText(R.string.button_accept)
                .build()
                .show();
    }
}
