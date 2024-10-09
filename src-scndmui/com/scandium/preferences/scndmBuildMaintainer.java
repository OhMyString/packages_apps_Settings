package com.scandiumui.preferences;

import android.content.Context;
import android.os.SystemProperties;
import androidx.annotation.VisibleForTesting;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class scndmBuildMaintainer extends BasePreferenceController {

    @VisibleForTesting

    public scndmBuildMaintainer(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    // scndmOSS Build Status
    /* This code was taken from BootleggersROM
       https://github.com/BootleggersROM/packages_apps_BootlegDumpster
    */
    @Override
    public CharSequence getSummary() {

        String scndmMaintainer = SystemProperties.get("ro.scandium.maintainer", "Unmaintained");
        String scndmBuildStatusSummary;

        if(scndmMaintainer.equalsIgnoreCase("Unmaintained") || scndmMaintainer.equalsIgnoreCase(null)){
            scndmBuildStatusSummary = mContext.getString(R.string.scndm_build_unmaintained_summary);
        } else {
            scndmBuildStatusSummary = mContext.getString(R.string.scndm_build_maintained_summary, scndmMaintainer);
        }
	    return scndmBuildStatusSummary;
    }
}