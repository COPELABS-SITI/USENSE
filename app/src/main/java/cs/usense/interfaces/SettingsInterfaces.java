/*
 * COPYRIGHTS COPELABS/ULHT, LGPLv3.0, 2017/7/28.
 * Class is part of the NSense application.
 */

package cs.usense.interfaces;


import android.content.Context;

import java.util.ArrayList;

import cs.usense.models.SettingsItem;


/**
 * This interface is used to implement MVP design pattern.
 * It establishes the communication between the view and the presenter
 * @author Miguel Tavares (COPELABS/ULHT)
 * @version 1.0, 2017
 */
public interface SettingsInterfaces {

    /**
     * This interface implements the view behavior
     */
    interface View {
        void startSelectedActivity(Class activity, boolean finishThisActivity);
        void onReceiveSettingsData(ArrayList<SettingsItem> data);
    }

    /**
     * This interface implements how the presenter replies to the view
     */
    interface Presenter {
        void onItemClick(int option);
        void onResume(Context context);
        void onDestroy();
    }

}
