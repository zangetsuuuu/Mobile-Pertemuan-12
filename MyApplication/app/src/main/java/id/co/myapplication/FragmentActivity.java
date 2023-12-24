    package id.co.myapplication;

    import android.os.Bundle;
    import android.view.MenuItem;
    import android.widget.FrameLayout;

    import com.google.android.material.tabs.TabLayout;
    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentTransaction;

    import com.google.android.material.bottomnavigation.BottomNavigationView;
    import id.co.myapplication.FirstFragment;
    import id.co.myapplication.SecondFragment;
    import id.co.myapplication.ThirdFragment;


    public class FragmentActivity extends AppCompatActivity {

        FrameLayout frameLayout;
        TabLayout tabLayout;
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fragment);

            frameLayout = (FrameLayout) findViewById(R.id.framelayout);
            tabLayout = (TabLayout) findViewById(R.id.tablayout);

            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new FirstFragment())
                    .addToBackStack(null)
                    .commit();

            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    Fragment fragment = null;

                    switch (tab.getPosition()){
                        case 0:
                            fragment = new FirstFragment();
                            break;
                        case 1:
                            fragment = new SecondFragment();
                            break;
                        case 2:
                            fragment = new ThirdFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit();
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
    }