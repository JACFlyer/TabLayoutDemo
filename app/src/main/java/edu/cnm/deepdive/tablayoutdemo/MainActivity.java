package edu.cnm.deepdive.tablayoutdemo;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.PagerAdapter;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener;


public class MainActivity extends AppCompatActivity implements
    Tab1Fragment.OnFragmentInteractionListener,
    Tab2Fragment.OnFragmentInteractionListener,
    Tab3Fragment.OnFragmentInteractionListener,
    Tab4Fragment.OnFragmentInteractionListener {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      }
    });
    configureTabLayout();
  }

  private void configureTabLayout() {
    TabLayout tabLayout = findViewById(R.id.tab_layout);

    /* Obtaining a reference to the Tablayout object that was added to activity_main.xml and creating four tabs and assigning text to appear in each*/

    tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_email));
    tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_dialer));
    tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_map));
    tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_info));

    /* Reference to ViewPager instance in the layout file is obtained and an instance of the TabPagerAdapter class is created.*/

    final ViewPager viewPager = findViewById(R.id.pager);
    final PagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager(),
        tabLayout.getTabCount());

    viewPager.setAdapter(adapter);

    viewPager.addOnPageChangeListener(new
        TabLayoutOnPageChangeListener(tabLayout));

    /* onTabSelectedListener is configured on the TabLayout instance and the onTabSelected() method is implemented to set the current page on the ViewPager based on the currently selected tab number.  For the sake of completeness, the other listener methods are added as stubs*/

    tabLayout.addOnTabSelectedListener(new
                                           TabLayout.OnTabSelectedListener() {
                                             @Override
                                             public void onTabSelected(TabLayout.Tab tab) {
                                               viewPager.setCurrentItem(tab.getPosition());
                                             }

                                             @Override
                                             public void onTabUnselected(TabLayout.Tab tab) {

                                             }

                                             @Override
                                             public void onTabReselected(TabLayout.Tab tab) {

                                             }
                                           });
  }

  @Override
  public void onFragmentInteraction (Uri uri) {
  }













  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
