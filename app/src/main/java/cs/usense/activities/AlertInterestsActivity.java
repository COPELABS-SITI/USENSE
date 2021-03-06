/*
 * COPYRIGHTS COPELABS/ULHT, LGPLv3.0, 2016/11/25.
 * Class is part of the NSense application.
 */

package cs.usense.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cs.usense.R;
import cs.usense.adapters.AlertInterestsAdapter;
import cs.usense.interfaces.AlertInterestsInterfaces;
import cs.usense.models.AlertInterestItem;
import cs.usense.presenters.AlertInterestsPresenter;


/**
 * This class instantiates an activity that shows common interests.
 * @author Miguel Tavares (COPELABS/ULHT)
 * @version 1.0, 2016
 */
public class AlertInterestsActivity extends AppCompatActivity implements AlertInterestsInterfaces.View {

    /** This variable is used to debug AlertInterestsActivity interests */
    private static final String TAG = "AlertInterestsActivity";

    /** This variable is the image on top activity */
    @BindView(R.id.top_bar_image) ImageView topIcon;

    /** This variable is the that loads the interests */
    @BindView(R.id.list) ListView listView;

    /** This object is the presenter of this class */
    private AlertInterestsInterfaces.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_interests);
        setup();
    }

    /**
     * This method initialize everything needed in this activity
     */
    private void setup() {
        Log.i(TAG, "setup");
        ButterKnife.bind(this);
        topIcon.setColorFilter(getResources().getColor(R.color.white));
        mPresenter = new AlertInterestsPresenter(this);
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume");
        super.onResume();
        mPresenter.loadSimilarInterests(this);
    }

    @Override
    public void onReceiveSimilarInterests(ArrayList<AlertInterestItem> similarInterests) {
        Log.i(TAG, "onReceiveSimilarInterests");
        listView.setAdapter(new AlertInterestsAdapter(this, R.layout.item_alert_interests, similarInterests));
    }

    @Override
    public void onBackPressed() {
        Log.i(TAG, "onBackPressed");
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

}

