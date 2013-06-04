package com.example.admobexample;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements AdListener{
	
	private AdView ads;
	private InterstitialAd interstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AdRequest request = new AdRequest();
		request.addTestDevice(AdRequest.TEST_EMULATOR);
		request.addTestDevice("8A30188902572F5D008C14012A2F1454");
		
		ads = new AdView(this, AdSize.BANNER, "a1517f4930cd4c5");
		LinearLayout container = (LinearLayout)findViewById(R.id.container);
		container.addView(ads);
		ads.loadAd(request);
		
		interstitial = new InterstitialAd(this, "a1517f4930cd4c5");
		interstitial.loadAd(request);
		interstitial.setAdListener(this);
	}
	
	@Override
	protected void onDestroy() {
		if(ads != null) {
			ads.destroy();
		}
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onDismissScreen(Ad arg0) {}

	@Override
	public void onFailedToReceiveAd(Ad arg0, ErrorCode arg1) {}

	@Override
	public void onLeaveApplication(Ad arg0) {}

	@Override
	public void onPresentScreen(Ad arg0) {}

	@Override
	public void onReceiveAd(Ad ad) {
		if (ad == interstitial) {
		      interstitial.show();
		}
	}

}
