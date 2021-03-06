package glass.stats;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.glass.view.MenuUtils;

public class MenuActivity extends Activity {

    private static final int MENU_STOP = 1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.stats, menu);
    	MenuItem stop = menu.add(MENU_STOP);
    	MenuUtils.setDescription(stop, R.string.stop);
    	MenuUtils.setInitialMenuItem(menu, stop);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_STOP: //R.id.stop:
                return stopService(new Intent(this, StatsService.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        openOptionsMenu();
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        finish();
    }
}
