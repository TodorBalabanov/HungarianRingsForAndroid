package eu.veldsoft.hungarian.rings;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity extends Activity {

	private Rings rings = null;

	private ImageView views[] = {};

	private View.OnClickListener aRingClockwiseClick = new View.OnClickListener() {
		@Override
		public void onClick(View viwe) {
			rings.ccwa();
			GameActivity.this.updateInfo();
		}
	};

	private View.OnClickListener aRingCouterClockwiseClick = new View.OnClickListener() {
		@Override
		public void onClick(View viwe) {
			rings.cwa();
			GameActivity.this.updateInfo();
		}
	};

	private View.OnClickListener bRingClockwiseClick = new View.OnClickListener() {
		@Override
		public void onClick(View viwe) {
			rings.ccwb();
			GameActivity.this.updateInfo();
		}
	};

	private View.OnClickListener bRingCouterClockwiseClick = new View.OnClickListener() {
		@Override
		public void onClick(View viwe) {
			rings.cwb();
			GameActivity.this.updateInfo();
		}
	};

	private void updateInfo() {
		sound();
		repaint();
		congratulate();
	}

	private void congratulate() {
		if (rings.isDone() == true) {
			Toast.makeText(this, R.string.you_win, Toast.LENGTH_LONG).show();
		}

	}

	private void sound() {
		if (rings.isDone() == true) {
			MediaPlayer.create(this, R.raw.beep_02).start();
		} else {
			MediaPlayer.create(this, R.raw.hit_01).start();
		}
	}

	private void repaint() {
		int state[] = rings.getState();

		if (views.length != state.length) {
			return;
		}

		for (int i = 0; i < views.length; i++) {
			switch (state[i]) {
			case 1:
				views[i].setImageResource(R.drawable.blue);
				break;
			case 2:
				views[i].setImageResource(R.drawable.red);
				break;
			case 3:
				views[i].setImageResource(R.drawable.green);
				break;
			case 4:
				views[i].setImageResource(R.drawable.violet);
				break;
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		ImageView views[] = { (ImageView) findViewById(R.id.imageView000),
				(ImageView) findViewById(R.id.imageView001),
				(ImageView) findViewById(R.id.imageView002),
				(ImageView) findViewById(R.id.imageView003),
				(ImageView) findViewById(R.id.imageView004),
				(ImageView) findViewById(R.id.imageView005),
				(ImageView) findViewById(R.id.imageView006),
				(ImageView) findViewById(R.id.imageView007),
				(ImageView) findViewById(R.id.imageView008),
				(ImageView) findViewById(R.id.imageView009),
				(ImageView) findViewById(R.id.imageView010),
				(ImageView) findViewById(R.id.imageView011),
				(ImageView) findViewById(R.id.imageView012),
				(ImageView) findViewById(R.id.imageView013),
				(ImageView) findViewById(R.id.imageView014),
				(ImageView) findViewById(R.id.imageView015),
				(ImageView) findViewById(R.id.imageView016),
				(ImageView) findViewById(R.id.imageView017),
				(ImageView) findViewById(R.id.imageView100),
				(ImageView) findViewById(R.id.imageView101),
				(ImageView) findViewById(R.id.imageView102),
				(ImageView) findViewById(R.id.imageView103),
				(ImageView) findViewById(R.id.imageView104),
				(ImageView) findViewById(R.id.imageView105),
				(ImageView) findViewById(R.id.imageView106),
				(ImageView) findViewById(R.id.imageView107),
				(ImageView) findViewById(R.id.imageView108),
				(ImageView) findViewById(R.id.imageView109),
				(ImageView) findViewById(R.id.imageView110),
				(ImageView) findViewById(R.id.imageView111),
				(ImageView) findViewById(R.id.imageView112),
				(ImageView) findViewById(R.id.imageView113),
				(ImageView) findViewById(R.id.imageView114),
				(ImageView) findViewById(R.id.imageView115),
				(ImageView) findViewById(R.id.imageView116),
				(ImageView) findViewById(R.id.imageView117), };
		this.views = views;

		findViewById(R.id.imageView005).setOnClickListener(
				aRingCouterClockwiseClick);
		findViewById(R.id.imageView006).setOnClickListener(
				aRingCouterClockwiseClick);
		findViewById(R.id.imageView007).setOnClickListener(
				aRingCouterClockwiseClick);
		findViewById(R.id.imageView008).setOnClickListener(
				aRingCouterClockwiseClick);
		findViewById(R.id.imageView009).setOnClickListener(
				aRingCouterClockwiseClick);
		findViewById(R.id.imageView010).setOnClickListener(
				aRingCouterClockwiseClick);

		findViewById(R.id.imageView012).setOnClickListener(aRingClockwiseClick);
		findViewById(R.id.imageView013).setOnClickListener(aRingClockwiseClick);
		findViewById(R.id.imageView014).setOnClickListener(aRingClockwiseClick);
		findViewById(R.id.imageView015).setOnClickListener(aRingClockwiseClick);
		findViewById(R.id.imageView016).setOnClickListener(aRingClockwiseClick);
		findViewById(R.id.imageView017).setOnClickListener(aRingClockwiseClick);

		findViewById(R.id.imageView105).setOnClickListener(
				bRingCouterClockwiseClick);
		findViewById(R.id.imageView106).setOnClickListener(
				bRingCouterClockwiseClick);
		findViewById(R.id.imageView107).setOnClickListener(
				bRingCouterClockwiseClick);
		findViewById(R.id.imageView108).setOnClickListener(
				bRingCouterClockwiseClick);
		findViewById(R.id.imageView109).setOnClickListener(
				bRingCouterClockwiseClick);
		findViewById(R.id.imageView110).setOnClickListener(
				bRingCouterClockwiseClick);

		findViewById(R.id.imageView112).setOnClickListener(bRingClockwiseClick);
		findViewById(R.id.imageView113).setOnClickListener(bRingClockwiseClick);
		findViewById(R.id.imageView114).setOnClickListener(bRingClockwiseClick);
		findViewById(R.id.imageView115).setOnClickListener(bRingClockwiseClick);
		findViewById(R.id.imageView116).setOnClickListener(bRingClockwiseClick);
		findViewById(R.id.imageView117).setOnClickListener(bRingClockwiseClick);

		((ImageView) findViewById(R.id.ebinqoLogo))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View view) {
						GameActivity.this.startActivity(new Intent(
								Intent.ACTION_VIEW, Uri.parse(getResources()
										.getString(R.string.ebinqo_url))));
					}
				});

		rings = new Rings(this.getWindow().getDecorView().getWidth(), this
				.getWindow().getDecorView().getHeight());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.game_option_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.reset_game:
			rings.init(0, 0);
			GameActivity.this.repaint();
			break;
		case R.id.shuffle_game:
			rings.shuffle();
			GameActivity.this.repaint();
			break;
		case R.id.help_game:
			GameActivity.this.startActivity(new Intent(GameActivity.this,
					HelpActivity.class));
			break;
		case R.id.about_game:
			GameActivity.this.startActivity(new Intent(GameActivity.this,
					AboutActivity.class));
			break;
		}
		return true;
	}
}
